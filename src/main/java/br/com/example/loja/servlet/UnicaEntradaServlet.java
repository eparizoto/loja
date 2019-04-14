package br.com.example.loja.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.example.loja.controller.ListarCardapio;
import br.com.example.loja.controller.PedirLancheForm;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAction = request.getParameter("acao");
		
		if(paramAction.equals("listarCardapio")) {			
			ListarCardapio listarCardapio = new ListarCardapio();
			listarCardapio.execute(request, response);
		}
		else if(paramAction.equals("pedirLancheForm")) {
			PedirLancheForm pedirLanche = new PedirLancheForm();
			pedirLanche.execute(request, response);
		}
		
		
		
		
	}

}
