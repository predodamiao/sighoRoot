/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ItemConsumo;
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
public class ItemConsumoDAO {
    public static List<ItemConsumo> obterItensConsumo() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<ItemConsumo> itensConsumo = new ArrayList<ItemConsumo>();
        ItemConsumo itemConsumo = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from itemConsumo");
            while(rs.next()){
                itemConsumo = (ItemConsumo) (rs);
                itensConsumo.add(itemConsumo);
            }
            
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        
        
        return itensConsumo;
    }
    
    public static ItemConsumo obterItemConsumo(int codItem) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        ItemConsumo item = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from ItemConsumo where id = "+ codItem);
            rs.first();
            item = instanciarItemConsumo(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return item;
    }

        public static ItemConsumo instanciarItemConsumo (ResultSet rs)throws ClassNotFoundException, SQLException{
        ItemConsumo item = new ItemConsumo(rs.getFloat("codigo"),
                rs.getString("descricao"),
                rs.getFloat("precoVenda"),
                null);
                
        return item;
    }
    
}
