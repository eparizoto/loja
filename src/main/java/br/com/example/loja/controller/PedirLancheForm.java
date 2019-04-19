package br.com.example.loja.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.example.loja.modelo.Banco;
import br.com.example.loja.modelo.Ingrediente;
import br.com.example.loja.modelo.Lanche;

public class PedirLancheForm implements IAcao {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("pedirLancheForm");

		List<Lanche> listaLanches = Banco.getLanchesCardapio();
		List<Ingrediente> listaIngredientes = Banco.getIngredientesCardapio();

		request.setAttribute("lanches", listaLanches);
		request.setAttribute("ingredientes", listaIngredientes);
		
		return "forward:pedidoLancheForm.jsp";
	}

}
