/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.Solicitacao;
import Model.StatusSolicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoDAO {

    public static List<Solicitacao> obterSolicitacoes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Solicitacao> solicitacoes = new ArrayList<>();
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

    public static Solicitacao obterSolicitacao(int codSolicitacao) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Solicitacao solicitacao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Solicitacao where id = " + codSolicitacao);
            rs.first();
            solicitacao = instanciarSolicitacao(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return solicitacao;
    }

    public static Solicitacao instanciarSolicitacao(ResultSet rs) throws ClassNotFoundException, SQLException {
        Solicitacao solicitacao = new Solicitacao(rs.getInt("id"),
                rs.getDate("data"),
                rs.getInt("quantidade"),
                Enum.valueOf(StatusSolicitacao.class, rs.getString("status")),
                null,
                null,
                null,
                null);
        solicitacao.setIdFuncionarioSolicitante(rs.getInt("idFuncionario"));
        solicitacao.setIdHospedagem(rs.getInt("idHospedagem"));
        solicitacao.setIdServico(rs.getString("idServico"));
        solicitacao.setIdOpcao(rs.getString("idOpcaoRestaurante"));
        return solicitacao;
    }

    public static void gravar(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into solicitacao (id, data, quantidade, status, idFuncionario, idHospedagem, idServico, idOpcaoRestaurante) values (?,?,?,?,?,?,?,?)");
            comando.setInt(1, solicitacao.getId());
            comando.setDate(2, new java.sql.Date(solicitacao.getData().getTime()));
            comando.setInt(3, solicitacao.getQuantidade());
            comando.setString(4, solicitacao.getStatus().toString());
            if (solicitacao.getFuncionarioSolicitante() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, solicitacao.getFuncionarioSolicitante().getId());
            }
            if (solicitacao.getHospedagem() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, solicitacao.getHospedagem().getId());
            }
            if (solicitacao.getServico() == null) {
                comando.setNull(7, Types.FLOAT);
            } else {
                comando.setString(7, solicitacao.getServico().getCodigo());
            }
            if (solicitacao.getOpcao() == null) {
                comando.setNull(8, Types.FLOAT);
            } else {
                comando.setString(8, solicitacao.getOpcao().getCodigo());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Solicitacao solicitacao) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from Solicitacao where id = " + solicitacao.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}
