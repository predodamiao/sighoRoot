package Model;

import DAO.OpcaoRestauranteDAO;
import java.sql.SQLException;
import java.util.List;

public class OpcaoRestaurante extends Servico {

    private float acrescimo;
    private int tempoPreparo;

    public OpcaoRestaurante(String codigo, String nome, String descricao, float precoVenda, CategoriaServico categoria, float acrescimo, int tempoPreparo) {
        super(codigo, nome, descricao, precoVenda, CategoriaServico.RESTAURANTE);
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
