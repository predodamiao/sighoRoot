/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public static List<Reserva> obterReservas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Reserva> reservas = new ArrayList<Reserva>();
        Reserva reserva = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from reserva");
            while (rs.next()) {
                reserva = instanciarReserva(rs);
                reservas.add(reserva);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return reservas;
    }

    public static Reserva obterReserva(int codReserva) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Reserva reserva = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from Reserva where id = " + codReserva);
            rs.first();
            reserva = instanciarReserva(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return reserva;
    }

    public static Reserva instanciarReserva(ResultSet rs) throws ClassNotFoundException, SQLException {
        Reserva reserva = new Reserva(rs.getInt("id"),
                rs.getDate("dataEstimadaChegada"),
                rs.getDate("dataEstimadaSaida"),
                null,
                null);
        reserva.setIdTipoQuarto(rs.getInt("tipoQuarto"));
        reserva.setIdHospedeResponsavel(rs.getInt("hospedeResponsavel"));
        return reserva;
    }

    public static void gravar(Reserva reserva) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into Reserva (id, dataEstimadaChegada, dataEstimadaSaida, tipoQuarto,  hospedeResponsavel) values (?,?,?,?,?)");
            comando.setInt(1, reserva.getId());
            comando.setDate(2, new java.sql.Date(reserva.getDataEstimadaChegada().getTime()));
            comando.setDate(3, new java.sql.Date(reserva.getDataEstimadaSaida().getTime()));
            if (reserva.getTipoQuarto() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(4, reserva.getTipoQuarto().getId());
            }
            if (reserva.getHospedeResponsavel() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, reserva.getHospedeResponsavel().getId());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Reserva reserva) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from Reserva where id = " + reserva.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void alterar(Reserva reserva) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update Reserva set "
                    + "dataEstimadaChegada = '" + new java.sql.Date(reserva.getDataEstimadaChegada().getTime()) + "', "
                    + "dataEstimadaSaida = '" + new java.sql.Date(reserva.getDataEstimadaSaida().getTime()) + "', "
                    + "hospedeResponsavel = ";
            if (reserva.getHospedeResponsavel() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + reserva.getHospedeResponsavel().getId();
            }
            stringSQL = stringSQL + ", tipoQuarto = ";
            if (reserva.getTipoQuarto() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + reserva.getTipoQuarto().getId();
            }

            stringSQL = stringSQL + " where id = " + reserva.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }

}
