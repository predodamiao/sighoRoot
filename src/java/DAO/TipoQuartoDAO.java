/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TipoQuarto;
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
public class TipoQuartoDAO {

    public static List<TipoQuarto> obterTiposQuarto() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoQuarto> tiposQuarto = new ArrayList<TipoQuarto>();
        TipoQuarto tipoQuarto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tipoQuarto");
            while (rs.next()) {
                tipoQuarto = (TipoQuarto) (rs);
                tiposQuarto.add(tipoQuarto);
            }

        } finally {
            DAO.fecharConexao(conexao, comando);
        }

        return tiposQuarto;
    }

    public static TipoQuarto obterTipoQuarto(int codTipoQuarto) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        TipoQuarto tipo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from quarto where id = " + codTipoQuarto);
            rs.first();
            tipo = instanciarTipoQuarto(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }

        return tipo;
    }

    public static TipoQuarto instanciarTipoQuarto(ResultSet rs) throws ClassNotFoundException, SQLException {
        TipoQuarto tipo = new TipoQuarto(rs.getString("descricao"),
                rs.getFloat("preco"));

        return tipo;
    }

}
