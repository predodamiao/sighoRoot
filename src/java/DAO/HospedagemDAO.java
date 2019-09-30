/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Hospedagem;
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
public class HospedagemDAO {
    public static List<Hospedagem> obterHospedagens() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Hospedagem> hospedagens  = new ArrayList<Hospedagem>();
        Hospedagem hospedagem = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from hospedagem");
            while(rs.next()){
                hospedagem = instanciarHospedagem(rs);
                hospedagens.add(hospedagem);
            }
            
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return hospedagens;
    }
    
    public static Hospedagem obterHospedagem(int codHospedagem) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Hospedagem hospedagem = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from hospedagem where id = " + codHospedagem);
            rs.first();
            hospedagem = instanciarHospedagem(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return hospedagem;
    }

    public static Hospedagem instanciarHospedagem (ResultSet rs)throws ClassNotFoundException, SQLException{
        Hospedagem hospedagem = new Hospedagem(rs.getInt("id"),
                rs.getDate("dataChegada"),
                rs.getDate("dataSaida"),
                rs.getDate("dataEstimadaChegada"),
                rs.getDate("dataEstimadaSaida"),
                rs.getBoolean("checked"),
                null,
                null,
                null);
        
        hospedagem.setIdTipoQuarto(rs.getInt("tipoQuarto"));
        hospedagem.setIdQuarto(rs.getInt("quarto"));
        hospedagem.setIdHospedeResponsavel(rs.getInt("hospedeResponsavel"));
        
        return hospedagem;
    }
    
}
