package Model;

import DAO.ConsumoDAO;
import java.sql.SQLException;
import java.util.*;

public class Consumo {

    private int id;
    private Date data;
    private int quantidade;
    private Funcionario funcionarioResponsavel;
    private Hospedagem hospedagem;
    private ItemConsumo itemConsumido;
    private int idFuncionario;
    private int idHospedagem;
    private int idItemConsumido;

    public Consumo(int id, Date data, int quantidade, Funcionario funcionarioResponsavel, Hospedagem hospedagem, ItemConsumo itemConsumido) {
        this.id = id;
        this.data = data;
        this.quantidade = quantidade;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.hospedagem = hospedagem;
        this.itemConsumido = itemConsumido;
    }

    public static Consumo obterConsumo(int codConsumo) throws ClassNotFoundException, SQLException {
        return ConsumoDAO.obterConsumo(codConsumo);
    }

    public static List<Consumo> obterConsumos() throws ClassNotFoundException, SQLException {
        return ConsumoDAO.obterConsumos();
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

    public Funcionario getFuncionarioResponsavel() throws ClassNotFoundException, SQLException {
        if ((this.idFuncionario != 0) && (this.funcionarioResponsavel == null)) {
            this.funcionarioResponsavel = Funcionario.obterFuncionario(this.idFuncionario);
        }
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
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

    public ItemConsumo getItemConsumido() throws ClassNotFoundException, SQLException {
        if ((this.idItemConsumido != 0) && (this.itemConsumido == null)) {
            this.itemConsumido = ItemConsumo.obterItemConsumo(this.idItemConsumido);
        }

        return itemConsumido;
    }

    public void setItemConsumido(ItemConsumo itemConsumido) {
        this.itemConsumido = itemConsumido;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(int idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public int getIdItemConsumido() {
        return idItemConsumido;
    }

    public void setIdItemConsumido(int idItemConsumido) {
        this.idItemConsumido = idItemConsumido;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ConsumoDAO.gravar(this);
    }

}
