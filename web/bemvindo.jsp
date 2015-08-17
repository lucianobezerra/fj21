<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <% String mensagem = "Bem Vindo a Caelum!"; %>
    <% out.println(mensagem); %>
    <br/>
    <% String desenvolvido = "Desenvolvido por LUCIANO BEZERRA"; %>
    <%= desenvolvido %>
    <% System.out.println("Tudo foi executado!"); %>
  </body>
</html>
