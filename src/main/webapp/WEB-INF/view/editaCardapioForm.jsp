<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.example.loja.modelo.Ingrediente"%>
<%@ page import="java.util.List,br.com.example.loja.modelo.Lanche"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cardapio de Ingredientes e Lanches</title>
</head>
<body style="">

	<h1>Nossa Loja - Editar Cardápio</h1> 
	<hr>

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
				<td>R$ ${lanche.valor }</td>
			</tr>
		</c:forEach>
	</table>
	<form action="${linkEntradaServlet }" method="post">
		<h2>Editar Ingredientes Adicionais:</h2>
	
		<table style="width: 30%">
			<tr>
				<th>Ingrediente Adicional</th>
				<th>Preço R$</th>
			</tr>
	
			<c:forEach items="${ingredientesCardapio}" var="ingrediente">
				<tr>
					<td>${ingrediente.nome }</td>
					<td><input type="number" name="${ingrediente.nome }" min="0.01" step="0.01" value= "${ingrediente.valor }"></td>
				</tr>
			</c:forEach>
		</table>
	
		<br />
		<input type="submit" value="Salvar alterações">&nbsp<a href="/loja/entrada?acao=ListarCardapio">Listar Cardápio</a>
		<input type="hidden" name="acao" value=SalvarCardapio>
	</form> 
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


