/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.CategoriaServico;
import Model.OpcaoRestaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OpcaoRestauranteDAO {

    public static List<OpcaoRestaurante> obterOpcoesRestaurante() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<OpcaoRestaurante> itensRestaurante = new ArrayList<OpcaoRestaurante>();
        OpcaoRestaurante itemRestaurante = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from opcaoRestaurante");
            while (rs.next()) {
                itemRestaurante = instanciarOpcaoRestaurante(rs);
                itensRestaurante.add(itemRestaurante);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return itensRestaurante;
    }

    public static OpcaoRestaurante obterOpcaoRestaurante(String codOpcao) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        OpcaoRestaurante item = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            System.out.println("select * from opcaoRestaurante where id ='" + codOpcao +"'");
            ResultSet rs = comando.executeQuery("select * from opcaoRestaurante where id ='" + codOpcao +"'");
            rs.first();
            item = instanciarOpcaoRestaurante(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return item;
    }

    public static OpcaoRestaurante instanciarOpcaoRestaurante(ResultSet rs) throws ClassNotFoundException, SQLException {
        OpcaoRestaurante opcao = new OpcaoRestaurante(rs.getString("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getFloat("preco"),
                Enum.valueOf(CategoriaServico.class, rs.getString("categoria")),
                rs.getFloat("acrescimo"),
                rs.getInt("tempoPreparo"));
        return opcao;
    }

    public static void gravar(OpcaoRestaurante opcao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into opcaoRestaurante (id, nome, descricao, preco, categoria, acrescimo, tempoPreparo) values (?,?,?,?,?,?,?)");
            comando.setString(1, opcao.getCodigo());
            comando.setString(2, opcao.getNome());
            comando.setString(3, opcao.getDescricao());
            comando.setFloat(4, opcao.getPreco());
            comando.setString(5, opcao.getCategoria().toString());
            comando.setFloat(6, opcao.getAcrescimo());
            comando.setInt(7, opcao.getTempoPreparo());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir (OpcaoRestaurante opcao) throws ClassNotFoundException, SQLException{
        
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from opcaoRestaurante where id = "+opcao.getCodigo();
            comando.execute(stringSQL);
        }finally{
            fecharConexao(conexao,comando);
        }
        
    }

}
