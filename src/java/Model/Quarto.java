package Model;

import DAO.QuartoDAO;
import java.sql.SQLException;
import java.util.List;

public class Quarto {

    private int identificacao;
    private int quantidadeCamasCasal;
    private int quantidadeCamasSolteiro;
    private boolean ocupado;
    private TipoQuarto tipo;
    private int idTipoQuarto;

    public Quarto(int identificacao, int quantidadeCamasCasal, int quantidadesCamaSolteiro, boolean ocupado, TipoQuarto tipo) {
        this.identificacao = identificacao;
        this.quantidadeCamasCasal = quantidadeCamasCasal;
        this.quantidadeCamasSolteiro = quantidadesCamaSolteiro;
        this.tipo = tipo;
    }

    public static Quarto obterQuarto(int codQuarto) throws ClassNotFoundException, SQLException {
        return QuartoDAO.obterQuarto(codQuarto);
    }

    public static List<Quarto> obterQuartos() throws ClassNotFoundException, SQLException {
        return QuartoDAO.obterQuartos();
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public int getQuantidadeCamasCasal() {
        return quantidadeCamasCasal;
    }

    public void setQuantidadeCamasCasal(int quantidadeCamasCasal) {
        this.quantidadeCamasCasal = quantidadeCamasCasal;
    }

    public int getQuantidadeCamasSolteiro() {
        return quantidadeCamasSolteiro;
    }

    public void setQuantidadeCamasSolteiro(int quantidadeCamasSolteiro) {
        this.quantidadeCamasSolteiro = quantidadeCamasSolteiro;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public TipoQuarto getTipo() throws ClassNotFoundException, SQLException {
        if ((this.idTipoQuarto != 0) && (this.tipo == null)) {
            this.tipo = TipoQuarto.obterTipoQuarto(this.idTipoQuarto);
        }

        return tipo;
    }

    public void setTipo(TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public int getIdTipoQuarto() {
        return idTipoQuarto;
    }

    public void setIdTipoQuarto(int idTipoQuarto) {
        this.idTipoQuarto = idTipoQuarto;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        QuartoDAO.gravar(this);
    }

}
