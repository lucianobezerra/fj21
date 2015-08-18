<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <h1>Altera Contato Cód: ${contato.id}</h1>
    <hr/>
    <form action="gravaContato" method="post">
      <input type="hidden" name="id" value="${contato.id}" />
      <fmt:formatDate value='${contato.dataNascimento.time}' pattern='dd/MM/yyyy' var="dataFormatada" />
      Nome: <input type="text"     name="nome"    value="${contato.nome}" /><br/>
      E-Mail: <input type="text"   name="email"   value="${contato.email}" /><br/>
      Endereço: <input type="text" name="endereco" value="${contato.endereco}" /><br/>
      Data Nascimento: <caelum:campoData id="dataNascimento" value="${dataFormatada}" /><br/>
      <input type="submit" value="Gravar"/>
    </form>
    <c:import url="rodape.jsp" />
  </body>
</html>