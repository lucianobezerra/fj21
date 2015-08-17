package logica;

import dao.ContatoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;

public class RemoveContato implements Logica{

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    long id = Long.parseLong(req.getParameter("id"));
    Contato contato = new Contato();
    contato.setId(id);
    ContatoDao dao = new ContatoDao();
    dao.remove(contato);
    System.out.println("Excluindo Contato");
    return "lista-contatos.jsp";
  }
  
}
