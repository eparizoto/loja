package br.com.example.loja.tests;




import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.example.loja.modelo.Banco;
import br.com.example.loja.modelo.Ingrediente;
import br.com.example.loja.modelo.ItemCardapio;
import br.com.example.loja.modelo.Lanche;
import br.com.example.loja.modelo.Promocao;

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
	
	@Test
	public void testPrecoXBaconPromocaoMuitaCarne() {

		Banco.getInstance();

		Lanche xBacon = Banco.getLanche(ItemCardapio.XBACON);
		
		int totalDeCarneDoLanche = 21;
		
		for(int i = 1; i < totalDeCarneDoLanche; i++) {
			
			xBacon.add(Banco.getIngrediente(ItemCardapio.HAMBURGUER_CARNE));
			
		}

		double valorXBaconSemPromocao = xBacon.getValor();
		
		xBacon.setPromocao(Promocao.MUITA_CARNE);
		double valorXBaconNaPromocao = xBacon.getValor();
		double valorXBaconNaPromocaoCalculado = valorXBaconSemPromocao - 
				totalDeCarneDoLanche /3 *(Banco.getIngrediente(ItemCardapio.HAMBURGUER_CARNE).getValor());
		
		if (valorXBaconNaPromocao == valorXBaconNaPromocaoCalculado)
			assertTrue(true);
		else
			assertTrue(false);
	}

}
