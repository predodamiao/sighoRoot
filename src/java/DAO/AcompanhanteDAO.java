/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Acompanhante;
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
public class AcompanhanteDAO {
    public static List<Acompanhante> obterAcompanhantes() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Acompanhante> acompanhantes = new ArrayList<Acompanhante>();
        Acompanhante acompanhante = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from acompanhante");
            while(rs.next()){
                acompanhante = (Acompanhante) (rs);
                acompanhantes.add(acompanhante);
            }
            
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return acompanhantes;
    }
    
    public static Acompanhante obterAcompanhante(int codAcompanhante) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Acompanhante acompanhante = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from acompanhante where idHospede = "+ codAcompanhante);
            rs.first();
            acompanhante = instanciarAcompanhante(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return acompanhante;
    }
    
    public static Acompanhante instanciarAcompanhante (ResultSet rs)throws ClassNotFoundException, SQLException{
        Acompanhante acompanhante = new Acompanhante(rs.getString("nome"),
                rs.getDate("dataNascimento"),
                rs.getInt("idade"),
                rs.getBoolean("ocupaCama"),
                null);
        
        acompanhante.setIdHospedagem(rs.getInt("idHospedagem"));
        return acompanhante;
    }
}