package DAO;

import static DAO.DAO.fecharConexao;
import Model.CategoriaFuncionario;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return funcionarios;
    }

    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario where id = " + codFuncionario);
            rs.first();
            funcionario = instanciarFuncionario(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return funcionario;
    }

    public static Funcionario instanciarFuncionario(ResultSet rs) throws ClassNotFoundException, SQLException {
        Funcionario funcionario = new Funcionario(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("rg"),
                rs.getString("cpf"),
                rs.getDate("dataNascimento"),
                rs.getDate("dataAdmissao"),
                Enum.valueOf(CategoriaFuncionario.class, rs.getString("categoriaFuncionario")));
        return funcionario;
    }
    
    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            comando = conexao.prepareStatement("insert into hospede (id, nome, telefone, email, rg, cpf, dataNascimento, dataAdmissao, categoria) values (?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, funcionario.getId());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getTelefone());
            comando.setString(4, funcionario.getEmail());
            comando.setString(5, funcionario.getRg());
            comando.setString(6, funcionario.getCpf());
            comando.setDate(7, (java.sql.Date) funcionario.getDataNascimento());
            comando.setDate(8, (Date) funcionario.getDataAdmissao());
            comando.setString(9, funcionario.getCategoria().toString());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
