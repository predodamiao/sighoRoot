package Model;

import DAO.SolicitacaoDAO;
import java.sql.SQLException;
import java.util.*;

public class Solicitacao {

    private Date data;
    private int quantidade;
    private StatusSolicitacao status;
    private Pessoa responsavel;
    private Hospedagem hospedagem;
    private ItemConsumo item;
    private int idPessoa;
    private int idHospedagem;

    public Solicitacao(Date data, StatusSolicitacao status, Pessoa responsavel, Hospedagem hospedagem, ItemConsumo item) {
        this.data = data;
        this.status = status;
        this.responsavel = responsavel;
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

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
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


}