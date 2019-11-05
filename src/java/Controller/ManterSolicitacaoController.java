package Controller;

import Model.Funcionario;
import Model.Hospedagem;
import Model.OpcaoRestaurante;
import Model.Servico;
import Model.Solicitacao;
import Model.StatusSolicitacao;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManterSolicitacaoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        } else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("hospedagens", Hospedagem.obterHospedagens());
            request.setAttribute("funcionarios", Funcionario.obterFuncionarios());
            request.setAttribute("servicos", Servico.obterServicos());
            request.setAttribute("opcoes", OpcaoRestaurante.obterOpcoesRestaurante());
            request.setAttribute("status", StatusSolicitacao.obterStatusSolicitacoes());

            if (!operacao.equals("Incluir")) {
                int idSolicitacao = Integer.parseInt(request.getParameter("id"));
                Solicitacao solicitacao = Solicitacao.obterSolicitacao(idSolicitacao);
                request.setAttribute("solicitacao", solicitacao);
            }

            RequestDispatcher view = request.getRequestDispatcher("/manterSolicitacao.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ParseException, ClassNotFoundException, SQLException, ServletException {
        String operacao = request.getParameter("operacao");
        int id = Integer.parseInt(request.getParameter("id"));
        Date data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        int idHospedagem = 0;
        int idFuncionario = 0;
        String idStatus = null;
        int codigoServico = 0;
        int codigoOpcao = 0;

        if (!operacao.equals("Excluir")) {
            idHospedagem = Integer.parseInt(request.getParameter("hospedagem"));
            idFuncionario = Integer.parseInt(request.getParameter("funcionarioSolicitante"));
            idStatus = request.getParameter("status");
            codigoServico = Integer.parseInt(request.getParameter("servico"));
            codigoOpcao = Integer.parseInt(request.getParameter("opcao"));
        }
        try {
            Hospedagem hospedagem = null;
            if (idHospedagem != 0) {
                hospedagem = Hospedagem.obterHospedagem(idHospedagem);
            }
            Funcionario funcionario = null;
            if (idFuncionario != 0) {
                funcionario = Funcionario.obterFuncionario(idFuncionario);
            }
            StatusSolicitacao status = null;
            if (idStatus != null) {
                status = StatusSolicitacao.obterStatusSolicitacao(idStatus);
            }
            Servico servico = null;
            if (codigoServico != 0) {
                servico = Servico.obterServico(codigoServico);
            }
            OpcaoRestaurante opcao = null;
            if (codigoOpcao != 0) {
                opcao = OpcaoRestaurante.obterOpcaoRestaurante(codigoOpcao);
            }
            System.out.println("ID: "+id);
            Solicitacao solicitacao = new Solicitacao(id, data, quantidade, status, funcionario, hospedagem, servico, opcao);
            if (operacao.equals("Incluir")) {
                solicitacao.gravar();
            } else if (operacao.equals("Excluir")) {
                solicitacao.excluir();
            } else if (operacao.equals("Editar")) {
                solicitacao.alterar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaSolicitacaoController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterSolicitacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterSolicitacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterSolicitacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterSolicitacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterSolicitacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterSolicitacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
