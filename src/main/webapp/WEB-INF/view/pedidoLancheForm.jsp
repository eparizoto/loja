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



	<form action="${linkEntradaServlet }" method="post">
		Escolha um Lanche:
		<br />
		
		<table style="width: 60%">
			<tr>
				<th>Lanche</th>
				<th>Ingredientes</th>
				<th>Preço</th>
			</tr>			
			<c:forEach items="${lanches}" var="lanche">
				<tr>
					<td><input type="radio" name="lanche" value=${ lanche.nome }>${ lanche.nome }</td>
					<td> 
						<c:forEach items="${lanche.ingredientes}" var="ingrediente">
								${ingrediente.nome }
						</c:forEach>				
					</td>
					<td> R$ ${ lanche.valor }</td>
				</tr>
			</c:forEach>
		</table>

		<br /> Se desejar, escolha os ingredientes adicionais do lanche: <br />
		<c:forEach items="${ingredientes}" var="ingrediente">
			<br><input type="number" name="${ ingrediente.nome }" min="0" max="10" value = "0"> ${ ingrediente.nome } - R$ ${ ingrediente.valor }<br>			
		</c:forEach>
				
		<br /> 
		Colocar promoção no lanche: 
		<input type="radio" name="promocao" value="0"> Light
		<input type="radio" name="promocao" value="1"> Muita Carne 
		<input type="radio" name="promocao" value="2"> Muito Queijo<br />
		<br />		
		<input type="submit" value="Pedir Lanche">&nbsp<a href="/loja/entrada?acao=MostrarPedidos">Exibir pedidos</a>
		<a href="/loja/entrada?acao=ListarCardapio">Listar Cardapio</a>&nbsp
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