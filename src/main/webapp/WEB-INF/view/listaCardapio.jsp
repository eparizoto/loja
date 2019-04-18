<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<body>

	<h1>Nossa Loja - Cardápio</h1>

	Lanches:
	<br />

	<ul>
		<c:forEach items="${lanches}" var="lanche">
			<li>${lanche.nome }</li>
		</c:forEach>
	</ul>
	
	
	<br />
	Ingredientes:
	<br />

	<ul>
		<c:forEach items="${ingredientes}" var="ingrediente">
			<li>${ingrediente.nome }</li>
		</c:forEach>
	</ul>
	
	<br />
	<li><a href="/loja/entrada?acao=pedirLancheForm">PEDIR UM LANCHE</a></li>

</body>
</html>