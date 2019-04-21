package br.com.example.loja.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.example.loja.controller.IAcao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAction = request.getParameter("acao");		
		String nomeDaClasse = "br.com.example.loja.controller." + paramAction;
		String nome;
		
		try {
			Class<?> classe  = Class.forName(nomeDaClasse);		
			IAcao acao = (IAcao) classe.getDeclaredConstructor().newInstance();
			nome = acao.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new ServletException(e);			
		}

		String[] tipoEEndereco = nome.split(":");
		
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(tipoEEndereco[1])			
		}
		
		
		
	}

}
