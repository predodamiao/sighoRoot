package Model;

import DAO.ItemRestauranteDAO;
import java.sql.SQLException;
import java.util.List;

public class ItemRestaurante extends ItemConsumo {

    private float acrescimo;
    private int tempoPreparo;

    public ItemRestaurante(float codigo, String descricao, float precoVenda, CategoriaItemConsumo categoria, float acrescimo, int tempoPreparo) {
        super (codigo, descricao, precoVenda, CategoriaItemConsumo.Restaurante);
        this.acrescimo = acrescimo;
        this.tempoPreparo = tempoPreparo;
    }

    public static ItemRestaurante obterItemRestaurante(int codItem) throws ClassNotFoundException, SQLException{
        return ItemRestauranteDAO.obterItensRestaurante(codItem);
    }
    
    public static List<ItemRestaurante> obterItensRestaurante() throws ClassNotFoundException, SQLException{
        return ItemRestauranteDAO.obterItensRestaurante();
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

}