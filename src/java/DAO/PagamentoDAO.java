/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Pagamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Henrique
 */
public class PagamentoDAO {
    public static List<Pagamento> obterPagamentos() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Pagamento> pagamentos = new ArrayList<Pagamento>();
        Pagamento pagamento = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from pagamento");
            while(rs.next()){
                pagamento = instanciarPagamento(rs);
                pagamentos.add(pagamento);
            }
            
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return pagamentos;
    }
    
    public static Pagamento obterPagamento(int codPagamento) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Pagamento pagamento = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from pagamento where id = "+ codPagamento);
            rs.first();
            pagamento = instanciarPagamento(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return pagamento;
    }
     
    public static Pagamento instanciarPagamento (ResultSet rs)throws ClassNotFoundException, SQLException{
        Pagamento pagamento = new Pagamento(rs.getFloat("valor"),
                rs.getDate("data"),
                rs.getInt("parcelas"),
                null,
                null,
                null);
        
        pagamento.setIdHospedagem(rs.getInt("idHospedagem"));
        return pagamento;
    }
}
