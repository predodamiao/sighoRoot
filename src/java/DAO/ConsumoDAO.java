/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.Consumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ConsumoDAO {

    public static List<Consumo> obterConsumos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Consumo> consumos = new ArrayList<>();
        Consumo consumo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from consumo");
            while (rs.next()) {
                consumo = instanciarConsumo(rs);
                consumos.add(consumo);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return consumos;
    }

    public static Consumo obterConsumo(int codConsumo) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Consumo consumo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from consumo where id = " + codConsumo);
            rs.first();
            consumo = instanciarConsumo(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return consumo;
    }

    public static Consumo instanciarConsumo(ResultSet rs) throws ClassNotFoundException, SQLException {
        Consumo consumo = new Consumo(rs.getInt("id"),
                rs.getDate("data"),
                rs.getInt("quantidade"),
                null,
                null,
                null);
        consumo.setIdFuncionario(rs.getInt("idFuncionario"));
        consumo.setIdItemConsumido(rs.getInt("idItem"));
        consumo.setIdHospedagem(rs.getInt("idHospedagem"));
        return consumo;
    }

    public static void gravar(Consumo consumo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into consumo (id, data, quantidade, idFuncionario, idHospedagem, idItem) values (?,?,?,?,?,?)");
            comando.setInt(1, consumo.getId());
            comando.setDate(2, new java.sql.Date(consumo.getData().getTime()));
            comando.setInt(3, consumo.getQuantidade());
            if (consumo.getFuncionarioResponsavel() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(4, consumo.getFuncionarioResponsavel().getId());
            }

            if (consumo.getHospedagem() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, consumo.getHospedagem().getId());
            }

            if (consumo.getItemConsumido() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, consumo.getItemConsumido().getCodigo());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Consumo consumo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from consumo where id = " + consumo.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Consumo consumo) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update consumo set "
                    + "data = '" + new java.sql.Date(consumo.getData().getTime()) + "', "
                    + "quantidade = " + consumo.getQuantidade() + ", "
                    + "idHospedagem = ";
            if (consumo.getHospedagem() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + consumo.getHospedagem().getId();
            }
            stringSQL = stringSQL + ", idFuncionario = ";
            if (consumo.getFuncionarioResponsavel() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + consumo.getFuncionarioResponsavel().getId();
            }
            stringSQL = stringSQL + ", idItem = ";
            if (consumo.getItemConsumido() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + consumo.getItemConsumido().getCodigo();
            }

            stringSQL = stringSQL + " where id = " + consumo.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}
