package Model;

import DAO.TipoQuartoDAO;
import java.sql.SQLException;
import java.util.List;

public class TipoQuarto {

    private int id;
    private String nome;
    private String descricao;
    private float preco;

    public TipoQuarto(int id, String nome, String descricao, float preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public static TipoQuarto obterTipoQuarto(int codTipoQuarto) throws ClassNotFoundException, SQLException {
        return TipoQuartoDAO.obterTipoQuarto(codTipoQuarto);
    }

    public static List<TipoQuarto> obterTiposQuarto() throws ClassNotFoundException, SQLException {
        return TipoQuartoDAO.obterTiposQuarto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void gravar() throws SQLException {
        TipoQuartoDAO.gravar(this);
    }

}
