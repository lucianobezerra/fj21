<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <c:import url="cabecalho.jsp" />
    <jsp:useBean id="dao" class="dao.ContatoDao" />
    <display:table id="contatos" name="${dao.contatos}">
      <display:column property="id"       title="Cod" sortable="true"/>
      <display:column property="nome"     title="Nome" sortable="true"/>
      <display:column property="email"    title="Email" autolink="true" />
      <display:column property="endereco" title="Endereço"/>
      <display:column property="dataNascimento.time" title="Nascimento" format="{0, date, dd/MM/yyyy }"/>
    </display:table>
    <c:import url="rodape.jsp" />
  </body>
</html>
