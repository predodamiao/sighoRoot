package Model;

import DAO.HospedagemDAO;
import java.sql.SQLException;
import java.util.*;

public class Hospedagem {

    private int id;
    private Date dataChegada;
    private Date dataSaida;
    private Date dataEstimadaChegada;
    private Date dataEstimadaSaida;
    private boolean checked;
    private TipoQuarto tipoQuarto;
    private Quarto quarto;
    private Hospede hospedeResponsavel;
    private int idTipoQuarto;
    private int idQuarto;
    private int idHospedeResponsavel;

    public Hospedagem(int id, Date dataChegada, Date dataSaida, Date dataEstimadaChegada, Date dataEstimadaSaida, boolean checked, TipoQuarto tipoQuarto, Quarto quarto, Hospede hospedeResponsavel) {
        this.id = id;
        this.dataChegada = dataChegada;
        this.dataSaida = dataSaida;
        this.dataEstimadaChegada = dataEstimadaChegada;
        this.dataEstimadaSaida = dataEstimadaSaida;
        this.checked = checked;
        this.tipoQuarto = tipoQuarto;
        this.quarto = quarto;
        this.hospedeResponsavel = hospedeResponsavel;
    }

    public static Hospedagem obterHospedagem(int codHospedagem) throws ClassNotFoundException, SQLException {
        return HospedagemDAO.obterHospedagem(codHospedagem);
    }

    public static List<Hospedagem> obterHospedagens() throws ClassNotFoundException, SQLException {
        return HospedagemDAO.obterHospedagens();
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataEstimadaChegada() {
        return dataEstimadaChegada;
    }

    public void setDataEstimadaChegada(Date dataEstimadaChegada) {
        this.dataEstimadaChegada = dataEstimadaChegada;
    }

    public Date getDataEstimadaSaida() {
        return dataEstimadaSaida;
    }

    public void setDataEstimadaSaida(Date dataEstimadaSaida) {
        this.dataEstimadaSaida = dataEstimadaSaida;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public TipoQuarto getTipoQuarto() throws ClassNotFoundException, SQLException {
        if ((this.idTipoQuarto != 0) && (this.tipoQuarto == null)) {
            this.tipoQuarto = TipoQuarto.obterTipoQuarto(this.idTipoQuarto);
        }

        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public Quarto getQuarto() throws ClassNotFoundException, SQLException {
        if ((this.idQuarto != 0) && (this.quarto == null)) {
            this.quarto = Quarto.obterQuarto(this.idQuarto);
        }

        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospedeResponsavel() throws ClassNotFoundException, SQLException {
        if ((this.idHospedeResponsavel != 0) && (this.hospedeResponsavel == null)) {
            this.hospedeResponsavel = Hospede.obterHospede(this.idHospedeResponsavel);
        }

        return hospedeResponsavel;
    }

    public void setHospedeResponsavel(Hospede hospedeResponsavel) {
        this.hospedeResponsavel = hospedeResponsavel;
    }

    public int getIdTipoQuarto() {
        return idTipoQuarto;
    }

    public void setIdTipoQuarto(int idTipoQuarto) {
        this.idTipoQuarto = idTipoQuarto;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getIdHospedeResponsavel() {
        return idHospedeResponsavel;
    }

    public void setIdHospedeResponsavel(int idHospedeResponsavel) {
        this.idHospedeResponsavel = idHospedeResponsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        HospedagemDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        HospedagemDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        HospedagemDAO.alterar(this);
    }

}
