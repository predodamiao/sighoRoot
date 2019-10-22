/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.MomentoPagamento;
import Model.Pagamento;
import Model.TipoPagamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {

    public static List<Pagamento> obterPagamentos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Pagamento> pagamentos = new ArrayList<Pagamento>();
        Pagamento pagamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pagamento");
            while (rs.next()) {
                pagamento = instanciarPagamento(rs);
                pagamentos.add(pagamento);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return pagamentos;
    }

    public static Pagamento obterPagamento(int codPagamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Pagamento pagamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pagamento where id = " + codPagamento);
            rs.first();
            pagamento = instanciarPagamento(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return pagamento;
    }

    public static Pagamento instanciarPagamento(ResultSet rs) throws ClassNotFoundException, SQLException {
        Pagamento pagamento = new Pagamento(rs.getInt("id"),
                rs.getFloat("valor"),
                rs.getDate("data"),
                rs.getInt("parcelas"),
                Enum.valueOf(TipoPagamento.class, rs.getString("tipo")),
                Enum.valueOf(MomentoPagamento.class, rs.getString("momento")),
                null);
        pagamento.setIdHospedagem(rs.getInt("idHospedagem"));
        return pagamento;
    }

    public static void gravar(Pagamento pagamento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into pagamento (id, valor, data, parcelas, tipo, momento, idHospedagem) values (?,?,?,?,?,?,?)");
            comando.setInt(1, pagamento.getId());
            comando.setFloat(2, pagamento.getValor());
            comando.setDate(3, new java.sql.Date(pagamento.getData().getTime()));
            comando.setInt(4, pagamento.getQuantidadeParcelas());
            comando.setString(5, pagamento.getTipo().toString());
            comando.setString(6, pagamento.getMomento().toString());
            if (pagamento.getHospedagem() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, pagamento.getHospedagem().getId());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir (Pagamento pagamento) throws ClassNotFoundException, SQLException{
        
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from Pagamento where id = "+pagamento.getId();
            comando.execute(stringSQL);
        }finally{
            fecharConexao(conexao,comando);
        }
        
    }

}
