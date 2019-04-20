package br.com.example.loja.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.example.loja.modelo.Banco;
import br.com.example.loja.modelo.ItemCardapio;

public class SalvarCardapio implements IAcao {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("SalvarCardapio");
	
		 Enumeration<String> parameterNames = request.getParameterNames();
		 
		 while (parameterNames.hasMoreElements()) {
			 
			 String paramName = parameterNames.nextElement();
			 
			 String paramValue = request.getParameter(paramName);
			 
			 ItemCardapio itemCardapio = ItemCardapio.fromString(paramName);
			 
			 if(itemCardapio != null)
				 Banco.updateValorIngrediente(itemCardapio, Double.parseDouble(paramValue));
		 }
		 
		return "redirect:entrada?acao=ListarCardapio";
	}

}
