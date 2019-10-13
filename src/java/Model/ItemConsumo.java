package Model;

import DAO.ItemConsumoDAO;
import java.sql.SQLException;
import java.util.List;

public class ItemConsumo {

    private String codigo;
    private String descricao;
    private float precoVenda;
    private CategoriaItemConsumo categoria;

    public ItemConsumo(String codigo, String descricao, float precoVenda, CategoriaItemConsumo categoria) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
    }

    public static ItemConsumo obterItemConsumo(int codItemConsumo) throws ClassNotFoundException, SQLException {
        return ItemConsumoDAO.obterItemConsumo(codItemConsumo);
    }

    public static List<ItemConsumo> obterItensConsumo() throws ClassNotFoundException, SQLException {
        return ItemConsumoDAO.obterItensConsumo();
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

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public CategoriaItemConsumo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaItemConsumo categoria) {
        this.categoria = categoria;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ItemConsumoDAO.gravar(this);
    }

}
