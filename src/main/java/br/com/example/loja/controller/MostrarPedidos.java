package br.com.example.loja.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.example.loja.modelo.Banco;
import br.com.example.loja.modelo.Lanche;

public class MostrarPedidos implements IAcao {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("MostrarPedidos");
		
		List<Lanche> lanchesPedidos = Banco.getLanchesPedidos();
		
		request.setAttribute("lanchesPedidos", lanchesPedidos);		
		
		return "forward:listaPedidos.jsp";
	}

}
