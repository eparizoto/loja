<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.example.loja.modelo.Ingrediente"%>
<%@ page import="java.util.List,br.com.example.loja.modelo.Lanche"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedir Lanche</title>
</head>
<body>

	<h1>Nossa Loja - Pedido de Lanche</h1>

	Escolha um Lanche:
	<br />

	<form action="${linkEntradaServlet }" method="post">
		<c:forEach items="${lanches}" var="lanche">
			<input type="radio" name="lanche" value=${ lanche.nome }> ${ lanche.nome } - R$ ${ lanche.valor }<br>
		</c:forEach>

		<br /> Se desejar, escolha os ingredientes adicionais do lanche: <br />

		<c:forEach items="${ingredientes}" var="ingrediente">
			<br><input type="number" name="${ ingrediente.nome }" min="0" max="5" value = "0"> ${ ingrediente.nome } - R$ ${ ingrediente.valor }<br>			
		</c:forEach>

		<br /> 
		
		Colocar promoção no lanche: 
		<input type="radio" name="promocao" value="0"> Light
		<input type="radio" name="promocao" value="1"> Muita Carne 
		<input type="radio" name="promocao" value="2"> Muito Queijo<br />
		<br />		
		 <li><input type="submit" value="Pedir Lanche">&nbsp<a href="/loja/entrada?acao=MostrarPedidos">Exibir pedidos</a></li>
		<input type="hidden" name="acao" value=PedirLanche> 
		<br />
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