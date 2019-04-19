package br.com.example.loja.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Lanche> lanchesCardapio = new ArrayList<Lanche>();	
	private static List<Ingrediente> ingredientesCardapio = new ArrayList<Ingrediente>();
	private static List<Lanche> lanchesPedidos = new ArrayList<Lanche>();
	private static Banco instance = null;
	private static int lastLanchePedidoId = 0;
	private static int lastLancheCardapioId = 0;
	private static int lastIngredienteCardapioId = 0;
	
	static {
		
		Banco.addNewIngredienteAoCardapio(new Ingrediente(ItemCardapio.ALFACE.toString(), 0.40));
		Banco.addNewIngredienteAoCardapio(new Ingrediente(ItemCardapio.BACON.toString(), 2.00));
		Banco.addNewIngredienteAoCardapio(new Ingrediente(ItemCardapio.HAMBURGUER_CARNE.toString(), 3.00));
		Banco.addNewIngredienteAoCardapio(new Ingrediente(ItemCardapio.OVO.toString(), 0.80));
		Banco.addNewIngredienteAoCardapio(new Ingrediente(ItemCardapio.QUEIJO.toString(), 1.50));
		
		List<Ingrediente> ingredientesXBacon = new ArrayList<Ingrediente>();
		ingredientesXBacon.add(Banco.getIngredienteCardapio(ItemCardapio.BACON));
		ingredientesXBacon.add(Banco.getIngredienteCardapio(ItemCardapio.HAMBURGUER_CARNE));
		ingredientesXBacon.add(Banco.getIngredienteCardapio(ItemCardapio.QUEIJO));
		Banco.addNewLancheAoCardapio(new Lanche(ItemCardapio.XBACON.toString(), ingredientesXBacon));
		
		List<Ingrediente> ingredientesXBurger = new ArrayList<Ingrediente>();
		ingredientesXBurger.add(Banco.getIngredienteCardapio(ItemCardapio.HAMBURGUER_CARNE));
		ingredientesXBurger.add(Banco.getIngredienteCardapio(ItemCardapio.QUEIJO));		
		Banco.addNewLancheAoCardapio(new Lanche(ItemCardapio.XBURGER.toString(), ingredientesXBurger));
		
		List<Ingrediente> ingredientesXEgg = new ArrayList<Ingrediente>();
		ingredientesXEgg.add(Banco.getIngredienteCardapio(ItemCardapio.OVO));
		ingredientesXEgg.add(Banco.getIngredienteCardapio(ItemCardapio.HAMBURGUER_CARNE));
		ingredientesXEgg.add(Banco.getIngredienteCardapio(ItemCardapio.QUEIJO));		
		Banco.addNewLancheAoCardapio(new Lanche(ItemCardapio.XEGG.toString(), ingredientesXEgg));
		
		List<Ingrediente> ingredientesXEggBacon = new ArrayList<Ingrediente>();
		ingredientesXEggBacon.add(Banco.getIngredienteCardapio(ItemCardapio.OVO));
		ingredientesXEggBacon.add(Banco.getIngredienteCardapio(ItemCardapio.BACON));
		ingredientesXEggBacon.add(Banco.getIngredienteCardapio(ItemCardapio.HAMBURGUER_CARNE));
		ingredientesXEggBacon.add(Banco.getIngredienteCardapio(ItemCardapio.QUEIJO));		
		Banco.addNewLancheAoCardapio(new Lanche(ItemCardapio.XEGG_BACON.toString(), ingredientesXEggBacon));
		
	}

	public static Lanche addNewLancheAoCardapio(Lanche lanche) {
		lanche.setId(++Banco.lastLancheCardapioId);
		Banco.lanchesCardapio.add(lanche);
		return lanche;
	}
	
	public static Ingrediente addNewIngredienteAoCardapio(Ingrediente ingrediente) {
		ingrediente.setId(++Banco.lastIngredienteCardapioId);
		Banco.ingredientesCardapio.add(ingrediente);
		return ingrediente;
	}

	public static Banco getInstance() {
		
		if (instance != null)
			return instance;
		
		instance = new Banco();
		return instance;		
	}
	
	public static List<Ingrediente> getIngredientesCardapio(){
		return Banco.ingredientesCardapio;
	}
	
	public static List<Lanche> getLanchesCardapio(){
		return Banco.lanchesCardapio;		
	}
	
	public static Ingrediente getIngredienteCardapio(ItemCardapio ingrediente) {
		
		try {
			
			return ingredientesCardapio.stream().filter(i->i.getNome().equals(ingrediente.toString())).findFirst().get(); 
						
		} catch (Exception e) {
			return null;
		}
		
	}
		
	public static Lanche getLancheCardapio(ItemCardapio lanche) {
		
		try {
			
			return lanchesCardapio.stream().filter(i->i.getNome().equals(lanche.toString())).findFirst().get();		
						
		} catch (Exception e) {
			return null;
		}
		
	}

	public static Lanche saveLanchePedido(Lanche lanche) {
		Banco.lastLanchePedidoId++;
		lanche.setId(Banco.lastLanchePedidoId);
		Banco.lanchesPedidos.add(lanche);
		
		return lanche;		
	}

	public static List<Lanche> getLanchesPedidos() {
		
		return Banco.lanchesPedidos;
	}
}
