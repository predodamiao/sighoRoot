package DAO;

import Model.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from funcionario");
            while(rs.next()){
                funcionario = (Funcionario) (rs);
                funcionarios.add(funcionario);
            }
            
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return funcionarios;
    }
    
    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from funcionario where id = "+ codFuncionario);
            rs.first();
            funcionario = instanciarFuncionario(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return funcionario;
    }
    
    public static Funcionario instanciarFuncionario (ResultSet rs)throws ClassNotFoundException, SQLException{
        Funcionario funcionario = new Funcionario(rs.getString("nome"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("rg"),
                rs.getString("cpf"),
                rs.getDate("dataNascimento"),
                rs.getString("logradouro"),
                rs.getInt("numero"),
                rs.getString("complemento"),
                rs.getString("bairro"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("pais"),
                rs.getString("cep"),
                rs.getDate("dataAdmissao"),
                null);
                
        return funcionario;
    }
    
}
