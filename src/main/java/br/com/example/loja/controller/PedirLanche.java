package br.com.example.loja.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.example.loja.modelo.Banco;
import br.com.example.loja.modelo.Ingrediente;
import br.com.example.loja.modelo.ItemCardapio;
import br.com.example.loja.modelo.Lanche;
import br.com.example.loja.modelo.Promocao;

public class PedirLanche {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("pedirLanche");
		
		String slanchePedido = request.getParameter("lanche");
		
		if(slanchePedido == null)
			throw new IOException("Escolha um lanche !!!!!");
			
		Lanche lanchePedido = new Lanche(slanchePedido, new ArrayList<Ingrediente>());
		
		for (ItemCardapio itemCardapio : ItemCardapio.values()) { 
			
			String stringQtdDoIngrediente = request.getParameter(itemCardapio.toString());
			
			if(stringQtdDoIngrediente == null)
				continue;
			
			int qtIngrediente = Integer.parseInt(stringQtdDoIngrediente);
			
			for (int i = 0; i < qtIngrediente; i++)
				lanchePedido.addIngredienteNoLanche(Banco.getIngredienteCardapio(itemCardapio));
		}
		
		String sPromocao = request.getParameter("promocao");
		
		switch (sPromocao) {
			case "0": lanchePedido.setPromocao(Promocao.LIGHT);			break;
			case "1": lanchePedido.setPromocao(Promocao.MUITA_CARNE);	break;
			case "2": lanchePedido.setPromocao(Promocao.MUITO_QUEIJO);	break;
		}
						
		request.setAttribute("lanchePedido", Banco.saveLanchePedido(lanchePedido));
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/pedidoEfetuado.jsp");
		rd.forward(request, response);
		
		System.out.println(lanchePedido.toString());	
	}

}
