package Controller;

import Model.Hospedagem;
import Model.MomentoPagamento;
import Model.Pagamento;
import Model.TipoPagamento;
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

public class ManterPagamentoController extends HttpServlet {

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
            request.setAttribute("momentos", MomentoPagamento.obterMomentosPagamento());
            request.setAttribute("tipos", TipoPagamento.obterTiposPagamento());
            
            if(!operacao.equals("Incluir")){
                int idPagamento = Integer.parseInt(request.getParameter("id"));
                Pagamento pagamento = Pagamento.obterPagamento(idPagamento);
                request.setAttribute("pagamento", pagamento);
            }
            
            RequestDispatcher view = request.getRequestDispatcher("/manterPagamento.jsp");
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
        int idHospedagem = Integer.parseInt(request.getParameter("hospedagem"));
        String idTipoPagamento = request.getParameter("tipo");
        String idMomentoPagamento = request.getParameter("momento");
        float valor = Float.parseFloat(request.getParameter("valor"));
        int parcelas = Integer.parseInt(request.getParameter("parcelas"));

        try {
            Hospedagem hospedagem = null;
            if (idHospedagem != 0) {
                hospedagem = Hospedagem.obterHospedagem(idHospedagem);
            }
            MomentoPagamento momento = null;
            if (idMomentoPagamento != null) {
                momento = MomentoPagamento.obterMomentoPagamento(idMomentoPagamento);
            }
            TipoPagamento tipo = null;
            if (idTipoPagamento != null) {
                tipo = TipoPagamento.obterTipoPagamento(idTipoPagamento);
            }
            Pagamento pagamento = new Pagamento(id, valor, data, parcelas, tipo, momento, hospedagem);
            if (operacao.equals("Incluir")) {
                pagamento.gravar();
            }else if(operacao.equals("Exluir")){
                pagamento.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPagamentoController");
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
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
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
