/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.Hospedagem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class HospedagemDAO {

    public static List<Hospedagem> obterHospedagens() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
        Hospedagem hospedagem = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from hospedagem");
            while (rs.next()) {
                hospedagem = instanciarHospedagem(rs);
                hospedagens.add(hospedagem);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return hospedagens;
    }

    public static Hospedagem obterHospedagem(int codHospedagem) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Hospedagem hospedagem = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from hospedagem where id = " + codHospedagem);
            rs.first();
            hospedagem = instanciarHospedagem(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return hospedagem;
    }

    public static Hospedagem instanciarHospedagem(ResultSet rs) throws ClassNotFoundException, SQLException {
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

    public static void gravar(Hospedagem hospedagem) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into hospedagem (id, dataChegada, dataSaida, dataEstimadaChegada, dataEstimadaSaida, checked, tipoQuarto, quarto, hospedeResponsavel) values (?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, hospedagem.getId());
            comando.setDate(2, new java.sql.Date(hospedagem.getDataChegada().getTime()));
            comando.setDate(3, new java.sql.Date(hospedagem.getDataSaida().getTime()));
            comando.setDate(4, new java.sql.Date(hospedagem.getDataEstimadaChegada().getTime()));
            comando.setDate(5, new java.sql.Date(hospedagem.getDataEstimadaSaida().getTime()));
            comando.setBoolean(6, hospedagem.isChecked());
            if (hospedagem.getTipoQuarto() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, hospedagem.getTipoQuarto().getId());
            }
            if (hospedagem.getQuarto() == null) {
                comando.setNull(8, Types.INTEGER);
            } else {
                comando.setInt(8, hospedagem.getQuarto().getIdentificacao());
            }
            if (hospedagem.getHospedeResponsavel() == null) {
                comando.setNull(9, Types.INTEGER);
            } else {
                comando.setInt(9, hospedagem.getHospedeResponsavel().getId());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
