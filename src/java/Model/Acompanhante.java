package Model;

import DAO.AcompanhanteDAO;
import java.sql.SQLException;
import java.util.*;

public class Acompanhante {

    private String nome;

    private Date dataNascimento;

    private int idade;

    private boolean ocupaCama;

    private Hospedagem hospedagem;

    private int idHospedagem;

    public Acompanhante(String nome, Date dataNascimento, int idade, boolean ocupaCama, Hospedagem hospedagem) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.ocupaCama = ocupaCama;
        this.hospedagem = hospedagem;
    }

    public static Acompanhante obterAcompanhante(int codAcompanhante) throws ClassNotFoundException, SQLException{
        return AcompanhanteDAO.obterAcompanhante(codAcompanhante);
    }
    
    public static List<Acompanhante> obterAcompanhantes() throws ClassNotFoundException, SQLException{
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isOcupaCama() {
        return ocupaCama;
    }

    public void setOcupaCama(boolean ocupaCama) {
        this.ocupaCama = ocupaCama;
    }

    public Hospedagem getHospedagem() throws ClassNotFoundException, SQLException {
        if((this.idHospedagem != 0) && (this.hospedagem == null)){
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
