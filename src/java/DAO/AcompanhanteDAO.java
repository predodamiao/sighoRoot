package DAO;

import static DAO.DAO.fecharConexao;
import Model.Acompanhante;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class AcompanhanteDAO {

    public static List<Acompanhante> obterAcompanhantes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Acompanhante> acompanhantes = new ArrayList<Acompanhante>();
        Acompanhante acompanhante = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from acompanhante");
            while (rs.next()) {
                acompanhante = instanciarAcompanhante(rs);
                acompanhantes.add(acompanhante);
            }
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return acompanhantes;
    }

    public static Acompanhante obterAcompanhante(int codAcompanhante) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Acompanhante acompanhante = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from acompanhante where id = " + codAcompanhante);
            rs.first();
            acompanhante = instanciarAcompanhante(rs);
        } finally {
            DAO.fecharConexao(conexao, comando);
        }
        return acompanhante;
    }

    public static Acompanhante instanciarAcompanhante(ResultSet rs) throws ClassNotFoundException, SQLException {
        Acompanhante acompanhante = new Acompanhante(rs.getInt("id"),
                rs.getString("nome"),
                rs.getDate("dataNascimento"),
                rs.getBoolean("ocupaCama"),
                null);
        acompanhante.setIdHospedagem(rs.getInt("idHospedagem"));
        return acompanhante;
    }

    public static void gravar(Acompanhante acompanhante) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into acompanhante(id, nome, dataNascimento, ocupaCama, idHospedagem) values (?,?,?,?,?)");
            comando.setInt(1, acompanhante.getId());
            comando.setString(2, acompanhante.getNome());
            comando.setDate(3, new java.sql.Date(acompanhante.getDataNascimento().getTime()));
            comando.setBoolean(4, acompanhante.isOcupaCama());
            System.out.println(acompanhante.getDataNascimento());
            System.out.println(new java.sql.Date(acompanhante.getDataNascimento().getTime()));

            if (acompanhante.getHospedagem() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, acompanhante.getHospedagem().getId());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Acompanhante acompanhante) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from acompanhante where id =" + acompanhante.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Acompanhante acompanhante) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update acompanhante set "
                    + "nome = '" + acompanhante.getNome() + "', "
                    + "dataNascimento = '" + new java.sql.Date(acompanhante.getDataNascimento().getTime()) + "', "
                    + "ocupaCama = " + acompanhante.isOcupaCama() + ", "
                    + "idHospedagem = ";
            if (acompanhante.getHospedagem() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + acompanhante.getHospedagem().getId();
            }

            stringSQL = stringSQL + " where id = " + acompanhante.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}
