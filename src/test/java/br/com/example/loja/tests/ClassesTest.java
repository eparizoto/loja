package br.com.example.loja.tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.Test;

import br.com.example.loja.modelo.Banco;
import br.com.example.loja.modelo.Ingrediente;
import br.com.example.loja.modelo.ItemCardapio;
import br.com.example.loja.modelo.Lanche;
import br.com.example.loja.modelo.Promocao;

public class ClassesTest {
	
	public ClassesTest() {
		super();
		Banco.getInstance();
	}


	@Test
	public void testPrecoXBacon() {

		Lanche xBacon = Banco.getNewLanche(ItemCardapio.XBACON);

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
	public void testPrecoXBurger() {

		Lanche xBurger = Banco.getNewLanche(ItemCardapio.XBURGER);

		BigDecimal valorXBurger = xBurger.getValor();
		BigDecimal valorIngredientesXBurger = new BigDecimal(0.00);

		List<Ingrediente> lst = xBurger.getIngredientes();

		for (Ingrediente ingrediente : lst) {

			valorIngredientesXBurger = valorIngredientesXBurger.add(ingrediente.getValor());
		}

		if (valorIngredientesXBurger.equals(valorXBurger))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	
	@Test
	public void testPrecoXEgg() {

		Lanche xEgg = Banco.getNewLanche(ItemCardapio.XEGG);

		BigDecimal valorXEgg = xEgg.getValor();
		BigDecimal valorIngredientesXEgg = new BigDecimal(0.00);
		
		List<Ingrediente> lst = xEgg.getIngredientes();

		for (Ingrediente ingrediente : lst) {

			valorIngredientesXEgg = valorIngredientesXEgg.add(ingrediente.getValor());
		}

		if (valorIngredientesXEgg.equals(valorXEgg))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	
	@Test
	public void testPrecoXEggBacon() {

		Lanche xEggBacon = Banco.getNewLanche(ItemCardapio.XEGG_BACON);

		BigDecimal valorXEggBacon = xEggBacon.getValor();
		BigDecimal valorIngredientesXEggBacon = new BigDecimal(0.00);
		
		List<Ingrediente> lst = xEggBacon.getIngredientes();

		for (Ingrediente ingrediente : lst) {

			valorIngredientesXEggBacon = valorIngredientesXEggBacon.add(ingrediente.getValor());
		}

		if (valorIngredientesXEggBacon.equals(valorXEggBacon))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	
	@Test
	public void testPrecoXBaconPromocaoMuitaCarne() {

		Lanche xBacon = Banco.getNewLanche(ItemCardapio.XBACON);
		
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
	
	
	@Test
	public void testPrecoXBaconPromocaoMuitoQueijo() {

		Lanche xBacon = Banco.getNewLanche(ItemCardapio.XBACON);
		
		int totalDeQueijoDoLanche = 21;
		
		for(int i = 1; i < totalDeQueijoDoLanche; i++) 			
			xBacon.addIngredienteNoLanche(Banco.getIngredienteCardapio(ItemCardapio.QUEIJO));
			
		BigDecimal valorXBaconSemPromocao = xBacon.getValor();
		
		xBacon.setPromocao(Promocao.MUITO_QUEIJO);
		BigDecimal valorXBaconNaPromocao = xBacon.getValor();
		BigDecimal valorXBaconNaPromocaoCalculado = valorXBaconSemPromocao.subtract(
				Banco.getIngredienteCardapio(ItemCardapio.QUEIJO).getValor().multiply(new BigDecimal(totalDeQueijoDoLanche /3)));
		
		if (valorXBaconNaPromocao.equals(valorXBaconNaPromocaoCalculado))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	
	@Test
	public void testPrecoXBurgerPromocaoLight() {

		Lanche xBurger = Banco.getNewLanche(ItemCardapio.XBURGER);
		
		int totalDeAlfaceDoLanche = 1;
		
		for(int i = 0; i < totalDeAlfaceDoLanche; i++) 			
			xBurger.addIngredienteNoLanche(Banco.getIngredienteCardapio(ItemCardapio.ALFACE));
			
		BigDecimal valorXBurgerSemPromocao = xBurger.getValor();
		
		xBurger.setPromocao(Promocao.LIGHT);
		BigDecimal valorXBurgerNaPromocao = xBurger.getValor().setScale(2, RoundingMode.DOWN);
		BigDecimal valorXBurgerNaPromocaoCalculado = valorXBurgerSemPromocao.multiply(new BigDecimal(0.90)).setScale(2, RoundingMode.DOWN);
		
		if (valorXBurgerNaPromocao.equals(valorXBurgerNaPromocaoCalculado))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	
	@Test
	public void testValorIngrediente()
	{
		Ingrediente ingrediente = Banco.getIngredienteCardapio(ItemCardapio.ALFACE);
		
		ingrediente.setValor(1.50);
		
		if(Banco.getIngredienteCardapio(ItemCardapio.ALFACE).getValor().equals(ingrediente.getValor()))
			assertTrue(true);
		else 
			assertTrue(false);
	}
		

}
