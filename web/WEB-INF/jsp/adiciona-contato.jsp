<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="jquery/jquery-ui.css" rel="stylesheet" />
  <script src="jquery/jquery.js"></script>
  <script src="jquery/jquery-ui.js"></script>
 </head>
  <body>
    <c:import url="cabecalho.jsp" />
    <h1>Adiciona Contato</h1>
    <hr/>
    <form action="gravaContato" method="post">
      Nome: <input type="text" name="nome" /><br/>
      E-Mail: <input type="text" name="email" /><br/>
      Endereço: <input type="text" name="endereco" /><br/>
      Data Nascimento: <caelum:campoData id="dataNascimento"/> <br/>
      <input type="submit" value="Gravar"/>
    </form>
    <c:import url="rodape.jsp" />
  </body>
</html>