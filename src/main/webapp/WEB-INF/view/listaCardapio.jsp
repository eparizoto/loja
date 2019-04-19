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
<title>Cardapio de Ingredientes e Lanches</title>
</head>
<body style="">

	<h1>Nossa Loja - Cardápio</h1>

	<h2>Lanches:</h2>

	<table style="width: 45%">
		<tr>
			<th>Lanche</th>
			<th>Ingredientes</th>
			<th>Preço</th>
		</tr>

		<c:forEach items="${lanchesCardapio}" var="lanche">
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

	<h2>Ingredientes Adicionais:</h2>

	<table style="width: 25%">
		<tr>
			<th>Ingrediente Adicional</th>
			<th>Preço</th>
		</tr>

		<c:forEach items="${ingredientesCardapio}" var="ingrediente">
			<tr>
				<td>${ingrediente.nome }</td>
				<td>${ingrediente.valor }</td>
			</tr>
		</c:forEach>

	</table>

	<br />
	<li>
		<a href="/loja/entrada?acao=PedirLancheForm">Pedir um lanche</a>&nbsp
		<a href="/loja/entrada?acao=MostrarPedidos">Exibir pedidos</a>
	</li>

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


