package Model;

import DAO.OpcaoRestauranteDAO;
import java.sql.SQLException;
import java.util.List;

public class OpcaoRestaurante extends Servico {

    private float acrescimo;
    private int tempoPreparo;

    public OpcaoRestaurante(int codigo, String nome, String descricao, float precoVenda, CategoriaServico categoria, float acrescimo, int tempoPreparo) {
        super(codigo, nome, descricao, precoVenda, CategoriaServico.RESTAURANTE);
        this.acrescimo = acrescimo;
        this.tempoPreparo = tempoPreparo;
    }

    public static OpcaoRestaurante obterOpcaoRestaurante(int codItem) throws ClassNotFoundException, SQLException {
        return OpcaoRestauranteDAO.obterOpcaoRestaurante(codItem);
    }

    public static List<OpcaoRestaurante> obterOpcoesRestaurante() throws ClassNotFoundException, SQLException {
        return OpcaoRestauranteDAO.obterOpcoesRestaurante();
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
    
    @Override
    public void excluir() throws SQLException, ClassNotFoundException{
       OpcaoRestauranteDAO.excluir(this);
    }

}
