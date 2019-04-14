package br.com.example.loja.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.example.loja.modelo.Banco;
import br.com.example.loja.modelo.Ingrediente;
import br.com.example.loja.modelo.Lanche;

public class ListarCardapio {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listarCardapio");
		
		Banco bd = Banco.getInstance();
		
		List<Lanche> listaLanches = bd.getLanchesCardapio();
		List<Ingrediente> listaIngredientes = bd.getIngredientesCardapio();
		
		request.setAttribute("lanches", listaLanches);
		request.setAttribute("ingredientes", listaIngredientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/listaCardapio.jsp");
		rd.forward(request, response);			
	}

}
