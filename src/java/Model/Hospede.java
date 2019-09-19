package Model;

import DAO.HospedeDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Hospede extends Pessoa {

    private String passaporte;

    public Hospede(String nome, String telefone, String email, String rg, String cpf, Date dataNascimento, String logradouro, int numeroResidencia, String complemento, String bairro, String cidade, String estado, String pais, String cep, String passaporte) {
        super(nome, telefone, email, rg, cpf, dataNascimento, logradouro, numeroResidencia, complemento, bairro, cidade, estado, pais, cep);
        this.passaporte = passaporte;
    }

    public static Hospede obterHospede(int codHospede) throws ClassNotFoundException, SQLException{
        return HospedeDAO.obterHospede(codHospede);
    }
    
    public static List<Hospede> obterHospedes() throws ClassNotFoundException, SQLException{
        return HospedeDAO.obterHospedes();
    }
    
    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }
    
    

}
