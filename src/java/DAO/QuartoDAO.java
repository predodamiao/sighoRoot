/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Quarto;
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
public class QuartoDAO {
    public static List<Quarto> obterQuartos() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Quarto> quartos = new ArrayList<Quarto>();
        Quarto quarto = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from quarto");
            while(rs.next()){
                quarto = instanciarQuarto(rs);
                quartos.add(quarto);
            }
            
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return quartos;
    }
    
    public static Quarto obterQuarto(int codQuarto) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Quarto quarto = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from quarto where id = "+ codQuarto);
            rs.first();
            quarto = instanciarQuarto(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return quarto;
    }
          
    public static Quarto instanciarQuarto(ResultSet rs) throws ClassNotFoundException, SQLException {
        Quarto quarto = new Quarto(rs.getInt("numero"),
                rs.getInt("numeroCamasCasal"),
                rs.getInt("numeroCamasSolteiro"),
                rs.getBoolean("ocupado"),
                null);

        quarto.setIdTipoQuarto(rs.getInt("tipoQuarto"));
        
        return quarto;
    }
    
}
