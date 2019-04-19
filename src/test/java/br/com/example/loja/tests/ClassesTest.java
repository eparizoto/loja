package br.com.example.loja.tests;




import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
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

		Lanche xBacon = Banco.getLancheCardapio(ItemCardapio.XBACON);

		BigDecimal valorXBacon = xBacon.getValor();
		BigDecimal valorIngredientesXBacon = new BigDecimal(0.00);

		List<Ingrediente> lst = xBacon.getIngredientes();

		for (Ingrediente ingrediente : lst) {

			valorIngredientesXBacon = valorIngredientesXBacon.add(ingrediente.getValor());
		}

		if (valorIngredientesXBacon.equals(valorXBacon))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	@Test
	public void testPrecoXBaconPromocaoMuitaCarne() {

		Banco.getInstance();

		Lanche xBacon = Banco.getLancheCardapio(ItemCardapio.XBACON);
		
		int totalDeCarneDoLanche = 21;
		
		for(int i = 1; i < totalDeCarneDoLanche; i++) 			
			xBacon.addIngredienteNoLanche(Banco.getIngredienteCardapio(ItemCardapio.HAMBURGUER_CARNE));
			
		BigDecimal valorXBaconSemPromocao = xBacon.getValor();
		
		xBacon.setPromocao(Promocao.MUITA_CARNE);
		BigDecimal valorXBaconNaPromocao = xBacon.getValor();
		BigDecimal valorXBaconNaPromocaoCalculado = valorXBaconSemPromocao.subtract(
				Banco.getIngredienteCardapio(ItemCardapio.HAMBURGUER_CARNE).getValor().multiply(new BigDecimal(totalDeCarneDoLanche /3)));
		
		if (valorXBaconNaPromocao.equals(valorXBaconNaPromocaoCalculado))
			assertTrue(true);
		else
			assertTrue(false);
	}

}
