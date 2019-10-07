package Model;

import DAO.AcompanhanteDAO;
import java.sql.SQLException;
import java.util.*;

public class Acompanhante {

    private int id;
    private String nome;
    private Date dataNascimento;
    private boolean ocupaCama;
    private Hospedagem hospedagem;
    private int idHospedagem;

    public Acompanhante(int id, String nome, Date dataNascimento, boolean ocupaCama, Hospedagem hospedagem) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.ocupaCama = ocupaCama;
        this.hospedagem = hospedagem;
    }

    public static Acompanhante obterAcompanhante(int codAcompanhante) throws ClassNotFoundException, SQLException {
        return AcompanhanteDAO.obterAcompanhante(codAcompanhante);
    }

    public static List<Acompanhante> obterAcompanhantes() throws ClassNotFoundException, SQLException {
        return AcompanhanteDAO.obterAcompanhantes();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isOcupaCama() {
        return ocupaCama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOcupaCama(boolean ocupaCama) {
        this.ocupaCama = ocupaCama;
    }

    public Hospedagem getHospedagem() throws ClassNotFoundException, SQLException {
        if ((this.idHospedagem != 0) && (this.hospedagem == null)) {
            this.hospedagem = Hospedagem.obterHospedagem(this.idHospedagem);
        }

        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public int getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(int idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

}
