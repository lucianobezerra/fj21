<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <c:import url="cabecalho.jsp" />
    <table>
      <tbody>
      <thead>
      <th>Nome</th>
      <th>Email</th>
      <th>Endereço</th>
      <th>Nascimento</th>
      <th colspan="2">Ação</th>
      </thead>
      </tbody>
      <c:forEach var="contato" items="${contatos}">
        <tr>
          <td>${contato.nome}</td>
          <td><c:choose>
              <c:when test="${not empty contato.email}">
                <a href="mailto:${contato.email}">${contato.email}</a>
              </c:when>
              <c:otherwise>E-mail não informado</c:otherwise>
            </c:choose>
          </td>
          <td>${contato.endereco}</td>
          <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
          <td><a href="mvc?logica=AlteraContato&id=${contato.id}">Editar</a></td>
          <td><a href="mvc?logica=RemoveContato&id=${contato.id}">Excluir</a></td>
        </tr>
      </c:forEach>
    </table>
    <a href="mvc?logica=AdicionaContato">Novo Contato</a><br/>
    <c:import url="rodape.jsp" />
  </body>
</html>
