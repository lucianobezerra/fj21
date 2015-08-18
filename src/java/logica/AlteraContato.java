package logica;

import dao.ContatoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;

public class AlteraContato implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    long id = Long.parseLong(req.getParameter("id"));
    Contato contato = new ContatoDao().getContato(id);
    req.setAttribute("contato", contato);
    return "/WEB-INF/jsp/altera-contato.jsp";
  }
  
}
