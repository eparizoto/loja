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
			<input type="radio" name="lanche" value=${ lanche.nome }> ${ lanche.nome }<br>
		</c:forEach>

		<br /> Se desejar, escolha os ingredientes adicionais do lanche: <br />

		<c:forEach items="${ingredientes}" var="ingrediente">
			<br><input type="number" name=${ ingrediente.id } min="0" max="5" value = "0"> ${ ingrediente.nome }<br>
		</c:forEach>

		<br /> <input type="submit" value="Pedir Lanche"> <input
			type="hidden" name="acao" value=pedirLanche> <br />
	</form>

</body>
</html>