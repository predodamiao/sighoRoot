package Model;

import DAO.SolicitacaoDAO;
import java.sql.SQLException;
import java.util.*;

public class Solicitacao {

    private int id;
    private Date data;
    private int quantidade;
    private StatusSolicitacao status;
    private Funcionario funcionarioSolicitante;
    private Hospedagem hospedagem;
    private Servico servico;
    private int idFuncionarioSolicitante;
    private int idHospedagem;

    public Solicitacao(int id, Date data, int quantidade, StatusSolicitacao status, Funcionario funcionario, Hospedagem hospedagem, Servico servico) {
        this.id = id;
        this.data = data;
        this.quantidade = quantidade;
        this.status = status;
        this.funcionarioSolicitante = funcionario;
        this.hospedagem = hospedagem;
        this.servico = servico;
    }

    public static Solicitacao obterSolicitacao(int codSolicitacao) throws ClassNotFoundException, SQLException {
        return SolicitacaoDAO.obterSolicitacao(codSolicitacao);
    }

    public static List<Solicitacao> obterSolicitacoes() throws ClassNotFoundException, SQLException {
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

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionarioSolicitante() {
        return funcionarioSolicitante;
    }

    public void setFuncionarioSolicitante(Funcionario funcionario) {
        this.funcionarioSolicitante = funcionario;
    }

    public int getIdFuncionarioSolicitante() {
        return idFuncionarioSolicitante;
    }

    public void setIdFuncionarioSolicitante(int idFuncionario) {
        this.idFuncionarioSolicitante = idFuncionario;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        SolicitacaoDAO.gravar(this);
    }

}
