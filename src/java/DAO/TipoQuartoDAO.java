/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.fecharConexao;
import Model.TipoQuarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                tipoQuarto = instanciarTipoQuarto(rs);
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
        TipoQuarto tipo = new TipoQuarto(rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getFloat("preco"));
        return tipo;
    }

    public static void gravar(TipoQuarto tipo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            comando = conexao.prepareStatement("insert into tipoQuarto (id, nome, descricao, preco) values (?,?,?,?)");
            comando.setInt(1, tipo.getId());
            comando.setString(2, tipo.getNome());
            comando.setString(3, tipo.getDescricao());
            comando.setFloat(4, tipo.getPreco());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
