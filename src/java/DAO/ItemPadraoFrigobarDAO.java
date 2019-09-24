/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ItemPadraoFrigobar;
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

    public static List<ItemPadraoFrigobar> obterItensPadraoFrigobar() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ItemPadraoFrigobar> itensPadroesFrigobar = new ArrayList<ItemPadraoFrigobar>();
        ItemPadraoFrigobar itensPadraoFrigobar = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itensPadraoFrigobar");
            while (rs.next()) {
                itensPadraoFrigobar = (ItemPadraoFrigobar) (rs);
                itensPadroesFrigobar.add(itensPadraoFrigobar);
            }

        } finally {
            DAO.fecharConexao(conexao, comando);
        }

        return itensPadroesFrigobar;
    }
    
    public static ItemPadraoFrigobar obterItensPadraoFrigobar(int codItem) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        ItemPadraoFrigobar item = null;
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

    public static ItemPadraoFrigobar instanciarItemPadraoFrigobar(ResultSet rs) throws ClassNotFoundException, SQLException {
        ItemPadraoFrigobar item = new ItemPadraoFrigobar(rs.getInt("quantidade"),
                null);

        item.setIdItemConsumo(rs.getInt("idItem"));

        return item;
    }

}
