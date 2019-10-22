package Model;

import DAO.ServicoDAO;
import java.sql.SQLException;
import java.util.List;

public class Servico {

    private String codigo;
    private String nome;
    private String descricao;
    private float preco;
    private CategoriaServico categoria;

    public Servico(String codigo, String nome, String descricao, float preco, CategoriaServico categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public static Servico obterServico(String codServico) throws ClassNotFoundException, SQLException {
        return ServicoDAO.obterServico(codServico);
    }

    public static List<Servico> obterServicos() throws ClassNotFoundException, SQLException {
        return ServicoDAO.obterServicos();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public void gravar() throws SQLException, ClassNotFoundException {
        ServicoDAO.gravar(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaServico getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaServico categoria) {
        this.categoria = categoria;
    }

}