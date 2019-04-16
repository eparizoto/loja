package br.com.example.loja.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.example.loja.modelo.ItemCardapio;

public class PedirLanche {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("pedirLanche");
		
		String lanchePedido = request.getParameter("lanche");
		System.out.println(lanchePedido);
		
		for (int i = 0; i < ItemCardapio.values().length; i++) {
			
			System.out.println(request.getParameter(String.valueOf(i)));		
		}
		

		
	}

}
