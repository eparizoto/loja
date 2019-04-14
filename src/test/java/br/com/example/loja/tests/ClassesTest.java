package br.com.example.loja.tests;




import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.example.loja.modelo.Banco;
import br.com.example.loja.modelo.Ingrediente;
import br.com.example.loja.modelo.ItemCardapio;
import br.com.example.loja.modelo.Lanche;

public class ClassesTest {

	@Test
	public void testPrecoXBacon() {

		Banco.getInstance();

		Lanche xBacon = Banco.getLanche(ItemCardapio.XBACON);

		double valorXBacon = xBacon.getValor();
		double valorIngredientesXBacon = 0.00;

		List<Ingrediente> lst = xBacon.getIngredientes();

		for (Ingrediente ingrediente : lst) {

			valorIngredientesXBacon += ingrediente.getValor();
		}

		if (valorIngredientesXBacon == valorXBacon)
			assertTrue(true);
		else
			assertTrue(false);
	}

}
