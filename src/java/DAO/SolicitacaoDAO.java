/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Solicitacao;
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
public class SolicitacaoDAO {

    public static List<Solicitacao> obterSolicitacoes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
        Solicitacao solicitacao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from solicitacao");
            while (rs.next()) {
                solicitacao = instanciarSolicitacao(rs);
                solicitacoes.add(solicitacao);
            }

        } finally {
            DAO.fecharConexao(conexao, comando);
        }

        return solicitacoes;
    }

    public static Solicitacao obterSolicitacao(int codSolicitacao) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Solicitacao solicitacao = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery ("select * from Solicitacao where id = "+ codSolicitacao );
            rs.first();
            solicitacao = instanciarSolicitacao(rs); 
        } finally{
            DAO.fecharConexao(conexao, comando);
        }
        
        return solicitacao;
    }
    
    public static Solicitacao instanciarSolicitacao(ResultSet rs) throws ClassNotFoundException, SQLException {
        Solicitacao solicitacao = new Solicitacao(rs.getDate("data"),
                rs.getInt("quantidade"),
                null,
                null,
                null,
                null);

        solicitacao.setIdPessoa(rs.getInt("solicitante"));
        solicitacao.setIdHospedagem(rs.getInt("idHospedagem"));
        return solicitacao;
    }

}
