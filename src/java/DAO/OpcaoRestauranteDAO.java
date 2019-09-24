/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.OpcaoRestaurante;
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
    
    public static OpcaoRestaurante obterItensRestaurante(int codOpcao) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        OpcaoRestaurante item = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from OpcaoRestaurante where id = "+ codOpcao);
            rs.first();
            item = instanciarOpcaoRestaurante(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return item;
    }
    
     public static OpcaoRestaurante instanciarOpcaoRestaurante(ResultSet rs) throws ClassNotFoundException, SQLException {
        OpcaoRestaurante opcao = new OpcaoRestaurante(rs.getFloat("id"),
                rs.getString("descricao"),
                rs.getFloat("precoVenda"),
                null,
                rs.getFloat("acrescimo"),
                rs.getInt("tempoPreparo"));

        return opcao;
    }

}
