package br.com.example.loja.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.example.loja.modelo.Banco;
import br.com.example.loja.modelo.ItemCardapio;
import br.com.example.loja.modelo.Lanche;
import br.com.example.loja.modelo.Promocao;

public class PedirLanche implements IAcao {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("pedirLanche");
		
		String slanchePedido = request.getParameter("lanche");
		
		if(slanchePedido == null)
			throw new IOException("Escolha um lanche !!!!!");
			
		Lanche lancheBd = Banco.getLancheCardapio(ItemCardapio.fromString(slanchePedido));
		
		Gson gson = new GsonBuilder().create();
		String jsonResult = gson.toJson(lancheBd);		
		Lanche lanchePedido = gson.fromJson(jsonResult, Lanche.class);
		
		for (ItemCardapio itemCardapio : ItemCardapio.values()) { 
			
			String stringQtdDoIngrediente = request.getParameter(itemCardapio.toString());
			
			if(stringQtdDoIngrediente == null)
				break;
			
			int qtIngrediente = Integer.parseInt(stringQtdDoIngrediente);
			
			for (int i = 0; i < qtIngrediente; i++)
				lanchePedido.addIngredienteNoLanche(Banco.getIngredienteCardapio(itemCardapio));
		}
		
		String sPromocao = request.getParameter("promocao");
		
		if (sPromocao != null)
		{
			switch (sPromocao) {
				case "0": lanchePedido.setPromocao(Promocao.LIGHT);			break;
				case "1": lanchePedido.setPromocao(Promocao.MUITA_CARNE);	break;
				case "2": lanchePedido.setPromocao(Promocao.MUITO_QUEIJO);	break;
			}
		}
		
		request.setAttribute("lanchePedido", Banco.saveLanchePedido(lanchePedido));
		
		System.out.println(lanchePedido.toString());
		
		return "redirect:entrada?acao=MostrarPedidos";
	}

}
