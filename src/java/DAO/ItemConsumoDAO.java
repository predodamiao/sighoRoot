/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.CategoriaItemConsumo;
import Model.ItemConsumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemConsumoDAO {

    public static List<ItemConsumo> obterItensConsumo() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ItemConsumo> itensConsumo = new ArrayList<ItemConsumo>();
        ItemConsumo itemConsumo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itemConsumo");
            while (rs.next()) {
                itemConsumo = instanciarItemConsumo(rs);
                itensConsumo.add(itemConsumo);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return itensConsumo;
    }

    public static ItemConsumo obterItemConsumo(int codItem) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ItemConsumo item = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from ItemConsumo where id = " + codItem);
            rs.first();
            item = instanciarItemConsumo(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return item;
    }

    public static ItemConsumo instanciarItemConsumo(ResultSet rs) throws ClassNotFoundException, SQLException {
        ItemConsumo item = new ItemConsumo(rs.getFloat("id"),
                rs.getString("descricao"),
                rs.getFloat("precoVenda"),
                Enum.valueOf(CategoriaItemConsumo.class, rs.getString("categoria")));
        return item;
    }

    public static void gravar(ItemConsumo item) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            comando = conexao.prepareStatement("insert into itemConsumo (id, descricao, precoVenda, categoria) values (?,?,?,?)");
            comando.setFloat(1, item.getCodigo());
            comando.setString(2, item.getDescricao());
            comando.setFloat(3, item.getPrecoVenda());
            comando.setString(4, item.getCategoria().toString());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
