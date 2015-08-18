package logica;

import dao.ContatoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;

public class ListaContatos implements Logica {

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    List<Contato> contatos = new ContatoDao().getContatos();
    req.setAttribute("contatos", contatos);
    return "/WEB-INF/jsp/lista-contatos.jsp";
  }
}
