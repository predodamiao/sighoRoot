/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.CategoriaItemConsumo;
import Model.OpcaoRestaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OpcaoRestauranteDAO {

    public static List<OpcaoRestaurante> obterItensRestaurante() throws ClassNotFoundException, SQLException {
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

    public static OpcaoRestaurante obterItensRestaurante(int codOpcao) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        OpcaoRestaurante item = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from OpcaoRestaurante where id = " + codOpcao);
            rs.first();
            item = instanciarOpcaoRestaurante(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return item;
    }

    public static OpcaoRestaurante instanciarOpcaoRestaurante(ResultSet rs) throws ClassNotFoundException, SQLException {
        OpcaoRestaurante opcao = new OpcaoRestaurante(rs.getFloat("id"),
                rs.getString("descricao"),
                rs.getFloat("precoVenda"),
                Enum.valueOf(CategoriaItemConsumo.class, rs.getString("categoria")),
                rs.getFloat("acrescimo"),
                rs.getInt("tempoPreparo"));
        return opcao;
    }

    public static void gravar(OpcaoRestaurante opcao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            comando = conexao.prepareStatement("insert into opcaoRestaurante (id, descricao, precoVenda, categoria, acrescimo, tempoPreparo) values (?,?,?,?,?,?)");
            comando.setFloat(1, opcao.getCodigo());
            comando.setString(2, opcao.getDescricao());
            comando.setFloat(3, opcao.getPrecoVenda());
            comando.setString(4, opcao.getCategoria().toString());
            comando.setFloat(5, opcao.getAcrescimo());
            comando.setInt(6, opcao.getTempoPreparo());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
