package servlet;

import dao.ContatoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;

@WebServlet(name = "AdicionaContato", urlPatterns = {"/adicionaContato"})
public class AdicionaContato extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String nome     = request.getParameter("nome");
    String endereco = request.getParameter("endereco");
    String email    = request.getParameter("email");
    String dataTexto= request.getParameter("dataNascimento");
    Calendar dataNascimento = null;
    try{
      Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
      dataNascimento = Calendar.getInstance();
      dataNascimento.setTime(date);
    }catch(ParseException e){
      out.println("Erro na conversão da data");
      return;
    }
    Contato contato = new Contato();
    contato.setNome(nome);
    contato.setEndereco(endereco);
    contato.setEmail(email);
    contato.setDataNascimento(dataNascimento);
    ContatoDao dao = new ContatoDao();
    dao.adiciona(contato);
    RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
    rd.forward(request, response);
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
    processRequest(request, response);
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
    processRequest(request, response);
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
