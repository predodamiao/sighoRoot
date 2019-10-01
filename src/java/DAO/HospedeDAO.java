/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Hospede;
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
public class HospedeDAO {
    public static List<Hospede> obterHospedes() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Hospede> hospedes  = new ArrayList<Hospede>();
        Hospede hospede = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from hospede");
            while(rs.next()){
                hospede = instanciarHospede(rs);
                hospedes.add(hospede);
            }
            
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return hospedes;
    }
    
     public static Hospede obterHospede(int codHospede) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Hospede hospede = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from hospede where id = "+ codHospede);
            rs.first();
            hospede = instanciarHospede(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return hospede;
    }
    
    public static Hospede instanciarHospede (ResultSet rs)throws ClassNotFoundException, SQLException{
        Hospede hospede = new Hospede(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("rg"),
                rs.getString("cpf"),
                rs.getDate("dataNascimento"),
                rs.getString("passaporte"));
       
        return hospede;
    }
    
}
