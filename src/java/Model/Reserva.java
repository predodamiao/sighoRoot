package Model;

import DAO.ReservaDAO;
import java.sql.SQLException;
import java.util.*;

public class Reserva {

    private int id;
    private Date dataEstimadaChegada;
    private Date dataEstimadaSaida;
    private TipoQuarto tipoQuarto;
    private Hospede hospedeResponsavel;
    private int idTipoQuarto;
    private int idHospedeResponsavel;

    public Reserva(int id,Date dataEstimadaChegada, Date dataEstimadaSaida, TipoQuarto tipoQuarto, Hospede hospedeResponsavel) {
        this.id = id;
        this.dataEstimadaChegada = dataEstimadaChegada;
        this.dataEstimadaSaida = dataEstimadaSaida;
        this.tipoQuarto = tipoQuarto;
        this.hospedeResponsavel = hospedeResponsavel;
    }

    public static Reserva obterReserva(int codReserva) throws ClassNotFoundException, SQLException{
        return ReservaDAO.obterReserva(codReserva);
    }

    public static List<Reserva> obterReservas() throws ClassNotFoundException, SQLException {
        return ReservaDAO.obterReservas();
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

    public TipoQuarto getTipoQuarto() throws ClassNotFoundException, SQLException {
        if ((this.idTipoQuarto != 0) && (this.tipoQuarto == null)) {
            this.tipoQuarto = TipoQuarto.obterTipoQuarto(this.idTipoQuarto);
        }

        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
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
        ReservaDAO.gravar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ReservaDAO.excluir(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ReservaDAO.alterar(this);
    }

}
