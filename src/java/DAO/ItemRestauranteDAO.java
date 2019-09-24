/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ItemRestaurante;
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
public class ItemRestauranteDAO {

    public static List<ItemRestaurante> obterItensRestaurante() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ItemRestaurante> itensRestaurante = new ArrayList<ItemRestaurante>();
        ItemRestaurante itemRestaurante = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from opcaoRestaurante");
            while (rs.next()) {
                itemRestaurante = (ItemRestaurante) (rs);
                itensRestaurante.add(itemRestaurante);
            }

        } finally {
            DAO.fecharConexao(conexao, comando);
        }

        return itensRestaurante;
    }
    
    public static ItemRestaurante obterItensRestaurante(int codItem) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        ItemRestaurante item = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from ItemRestaurante where id = "+ codItem);
            rs.first();
            item = instanciarItemRestaurante(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return item;
    }
    
     public static ItemRestaurante instanciarItemRestaurante(ResultSet rs) throws ClassNotFoundException, SQLException {
        ItemRestaurante opcao = new ItemRestaurante(rs.getFloat("codigo"),
                rs.getString("descricao"),
                rs.getFloat("precoVenda"),
                null,
                rs.getFloat("acrescimo"),
                rs.getInt("tempoPreparo"));

        return opcao;
    }

}
