package Model;

import DAO.OpcaoRestauranteDAO;
import java.sql.SQLException;
import java.util.List;

public class OpcaoRestaurante extends ItemConsumo {

    private float acrescimo;
    private int tempoPreparo;

    public OpcaoRestaurante(float codigo, String descricao, float precoVenda, CategoriaItemConsumo categoria, float acrescimo, int tempoPreparo) {
        super(codigo, descricao, precoVenda, CategoriaItemConsumo.Restaurante);
        this.acrescimo = acrescimo;
        this.tempoPreparo = tempoPreparo;
    }

    public static OpcaoRestaurante obterItemRestaurante(int codItem) throws ClassNotFoundException, SQLException {
        return OpcaoRestauranteDAO.obterItensRestaurante(codItem);
    }

    public static List<OpcaoRestaurante> obterItensRestaurante() throws ClassNotFoundException, SQLException {
        return OpcaoRestauranteDAO.obterItensRestaurante();
    }

    public float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    @Override
    public void gravar() throws SQLException, ClassNotFoundException {
        OpcaoRestauranteDAO.gravar(this);
    }

}
