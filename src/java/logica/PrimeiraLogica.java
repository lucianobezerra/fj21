package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
    System.out.println("Executando a Lógica");
    System.out.println("Retornando o JSP");
    return "primeira-logica.jsp";
  }

}
