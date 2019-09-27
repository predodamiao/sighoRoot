/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ItemFrigobar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lavínia Beghini
 */
public class ItemPadraoFrigobarDAO {

    public static List<ItemFrigobar> obterItensPadraoFrigobar() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ItemFrigobar> itensPadroesFrigobar = new ArrayList<ItemFrigobar>();
        ItemFrigobar itensPadraoFrigobar = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itemFrigobar");
            while (rs.next()) {
                itensPadraoFrigobar = instanciarItemPadraoFrigobar(rs);
                itensPadroesFrigobar.add(itensPadraoFrigobar);
            }

        } finally {
            DAO.fecharConexao(conexao, comando);
        }

        return itensPadroesFrigobar;
    }
    
    public static ItemFrigobar obterItensPadraoFrigobar(int codItem) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        ItemFrigobar item = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from ItemFrigobar where idItem = "+ codItem);
            rs.first();
            item = instanciarItemPadraoFrigobar(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return item;
    }    

    public static ItemFrigobar instanciarItemPadraoFrigobar(ResultSet rs) throws ClassNotFoundException, SQLException {
        ItemFrigobar item = new ItemFrigobar(rs.getInt("id"),
                rs.getInt("quantidade"),
                null);

        item.setIdItemConsumo(rs.getInt("idItem"));

        return item;
    }

}
