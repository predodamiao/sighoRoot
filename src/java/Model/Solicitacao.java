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
    private OpcaoRestaurante opcao;
    private int idFuncionarioSolicitante;
    private int idHospedagem;
    private String idServico;
    private String idOpcao;

    public Solicitacao(int id, Date data, int quantidade, StatusSolicitacao status, Funcionario funcionario, Hospedagem hospedagem, Servico servico, OpcaoRestaurante opcao) {
        this.id = id;
        this.data = data;
        this.quantidade = quantidade;
        this.status = status;
        this.funcionarioSolicitante = funcionario;
        this.hospedagem = hospedagem;
        this.servico = servico;
        this.opcao = opcao;
    }

    public static Solicitacao obterSolicitacao(int codSolicitacao) throws ClassNotFoundException, SQLException {
        return SolicitacaoDAO.obterSolicitacao(codSolicitacao);
    }

    public static List<Solicitacao> obterSolicitacoes() throws ClassNotFoundException, SQLException {
        return SolicitacaoDAO.obterSolicitacoes();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Funcionario getFuncionarioSolicitante() throws ClassNotFoundException, SQLException {
        if ((this.idFuncionarioSolicitante != 0) && (this.funcionarioSolicitante == null)) {
            this.funcionarioSolicitante = Funcionario.obterFuncionario(this.idFuncionarioSolicitante);
        }
        return funcionarioSolicitante;
    }

    public void setFuncionarioSolicitante(Funcionario funcionarioSolicitante) {
        this.funcionarioSolicitante = funcionarioSolicitante;
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

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public OpcaoRestaurante getOpcao() {
        return opcao;
    }

    public void setOpcao(OpcaoRestaurante opcao) {
        this.opcao = opcao;
    }

    public int getIdFuncionarioSolicitante() {
        return idFuncionarioSolicitante;
    }

    public void setIdFuncionarioSolicitante(int idFuncionarioSolicitante) {
        this.idFuncionarioSolicitante = idFuncionarioSolicitante;
    }

    public int getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(int idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public String getIdServico() {
        return idServico;
    }

    public void setIdServico(String idServico) {
        this.idServico = idServico;
    }

    public String getIdOpcao() {
        return idOpcao;
    }

    public void setIdOpcao(String idOpcao) {
        this.idOpcao = idOpcao;
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        SolicitacaoDAO.gravar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
       SolicitacaoDAO.excluir(this);
    }

}
