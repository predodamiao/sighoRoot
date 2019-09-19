package Model;

import DAO.TipoQuartoDAO;
import java.sql.SQLException;
import java.util.List;

public class TipoQuarto {

    private String descricao;
    private float preco;

    public TipoQuarto(String descricao, float preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

        public static TipoQuarto obterTipoQuarto(int codTipoQuarto) throws ClassNotFoundException, SQLException{
        return TipoQuartoDAO.obterTipoQuarto(codTipoQuarto);
    }
    
    public static List<TipoQuarto> obterTiposQuarto() throws ClassNotFoundException, SQLException{
        return TipoQuartoDAO.obterTiposQuarto();
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

}
