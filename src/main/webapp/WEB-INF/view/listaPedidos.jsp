<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.example.loja.modelo.Ingrediente"%>
<%@ page import="java.util.List,br.com.example.loja.modelo.Lanche"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos Feitos</title>
</head>
<body style="">

	<h1>Nossa Loja - Pedidos feitos</h1>

	<h2>Lanches:</h2>

	<table style="width: 45%">
		<tr>
			<th>Lanche</th>
			<th>Ingredientes</th>
			<th>Pre�o</th>
		</tr>

		<c:forEach items="${lanchesPedidos}" var="lanche">
			<tr>
				<td>${lanche.nome }</td>
				<td><c:forEach items="${lanche.ingredientes }" var="lancheIngrediente">
						-&nbsp${lancheIngrediente.nome}
					</c:forEach>
				</td>
				<td>${lanche.valor }</td>
			</tr>
		</c:forEach>
	</table>
	
	<br />	
	<a href="/loja/entrada?acao=ListarCardapio">Listar Cardapio</a>&nbsp
	<a href="/loja/entrada?acao=PedirLancheForm">Pedir Lanche</a>
	
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