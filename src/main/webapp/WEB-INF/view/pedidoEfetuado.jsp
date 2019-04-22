<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.example.loja.modelo.Ingrediente"%>
<%@ page import="java.util.List,br.com.example.loja.modelo.Lanche"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedido efetuado</title>
</head>
<body>

	<h1>Nossa Loja - Pedido de Lanche</h1>
	<hr>

	<br /> Lanche pedido: ${lanchePedido.nome} Total: ${lanchePedido.valor} <br />

	<br /> Ingredientes Adicionais:

	<ul>
		<c:forEach items="${lanchePedido.ingredientes}" var="ingrediente">
			<li>${ingrediente.nome }</li>
		</c:forEach>
	</ul>

	<br />
	<li><a href="/loja/entrada?acao=ListarCardapio">CARDÁPIO</a></li>


</body>

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

* {
	font-family: verdana;
}
</style>
</html>