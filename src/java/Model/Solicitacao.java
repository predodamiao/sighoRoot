package Model;

import DAO.SolicitacaoDAO;
import java.sql.SQLException;
import java.util.*;

public class Solicitacao {

    private int id;
    private Date data;
    private int quantidade;
    private StatusSolicitacao status;
    private Funcionario funcionario;
    private Hospede hospede;
    private Hospedagem hospedagem;
    private ItemConsumo item;
    private int idFuncionario;
    private int idHospede;
    private int idHospedagem;

    public Solicitacao(int id, Date data, int quantidade, StatusSolicitacao status, Funcionario funcionario, Hospede hospede, Hospedagem hospedagem, ItemConsumo item) {
        this.id = id;
        this.data = data;
        this.quantidade = quantidade;
        this.status = status;
        this.funcionario = funcionario;
        this.hospede = hospede;
        this.hospedagem = hospedagem;
        this.item = item;
    }

        public static Solicitacao obterSolicitacao(int codSolicitacao) throws ClassNotFoundException, SQLException{
        return SolicitacaoDAO.obterSolicitacao(codSolicitacao);
    }
    
    public static List<Solicitacao> obterSolicitacoes() throws ClassNotFoundException, SQLException{
        return SolicitacaoDAO.obterSolicitacoes();
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public StatusSolicitacao getStatus() {
        return status;
    }

    public void setStatus(StatusSolicitacao status) {
        this.status = status;
    }

    public Hospedagem getHospedagem() {
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

    public ItemConsumo getItem() {
        return item;
    }

    public void setItem(ItemConsumo item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }


}