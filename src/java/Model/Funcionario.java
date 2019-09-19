package Model;

import DAO.FuncionarioDAO;
import java.sql.SQLException;
import java.util.*;

public class Funcionario extends Pessoa {

    private Date dataAdmissao;
    private CategoriaFuncionario categoria;
    
    public Funcionario(String nome, String telefone, String email, String rg, String cpf, Date dataNascimento, String logradouro, int numeroResidencia, String complemento, String bairro, String cidade, String estado, String pais, String cep, Date dataAdmissao, CategoriaFuncionario categoria) {
        super(nome, telefone, email, rg, cpf, dataNascimento, logradouro, numeroResidencia, complemento, bairro, cidade, estado, pais, cep);
        this.dataAdmissao = dataAdmissao;
        this.categoria = categoria;
    }
    
    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException{
        return FuncionarioDAO.obterFuncionario(codFuncionario);
    }
    
    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException{
        return FuncionarioDAO.obterFuncionarios();
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public CategoriaFuncionario getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFuncionario categoria) {
        this.categoria = categoria;
    }


}
