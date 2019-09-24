/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Consumo;
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
public class ConsumoDAO {
    public static List<Consumo> obterConsumos() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Consumo> consumos  = new ArrayList<Consumo>();
        Consumo consumo = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from consumo");
            while(rs.next()){
                consumo = instanciarConsumo(rs);
                consumos.add(consumo);
            }
            
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return consumos;
    }
    
    public static Consumo obterConsumo(int codConsumo) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Consumo consumo = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from consumo where id = " + codConsumo);
            rs.first();
            consumo = instanciarConsumo(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return consumo;
    }
      
    public static Consumo instanciarConsumo (ResultSet rs)throws ClassNotFoundException, SQLException{
        Consumo consumo = new Consumo(rs.getDate("dataConsumo"),
                rs.getInt("quantidade"),
                null,
                null,
                null);
        
        consumo.setIdFuncionario(rs.getInt("idFuncionario"));
        consumo.setIdItemConsumido(rs.getInt("idItem"));
        consumo.setIdHospedagem(rs.getInt("idHospedagem"));
        return consumo;
    }
}
