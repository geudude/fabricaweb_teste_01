<%@page import="br.com.fabricateste.persistencia.entidade.Usuario"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de usuário</title>
</head>
<body>
<%@include file="menu.jsp"
 %>
	<%
	Usuario u = request.getAtttribute("usuario");
	%>
	<form method="POST" action="usucontroller.do">
		Id:<input type="text" name="id" value="<%u.getId();%>"/><br>
		Nome:<input type="text" name="nome" value="<%u.getNome();%>"/><br>
		Login:<input type="text" name="login" value="<%u.getLogin();%>"/><br>
		Senha:<input type="password" name="senha"/><br>
		
		<input type="submit" value="Salvar"/>
	</form>
</body>
</html>