package br.com.example.loja.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Lanche> lanchesCardapio = new ArrayList<Lanche>();	
	private static List<Ingrediente> ingredientesCardapio = new ArrayList<Ingrediente>();
	private static Banco instance = null;
	
	public static Banco getInstance() {
		
		if (instance != null)
			return instance;
		
		instance = new Banco();
		return instance;		
	}
	
	public Banco() {
		
		Ingrediente alface = new Ingrediente(ItemCardapio.ALFACE.toString(), 0.40);
		Ingrediente bacon = new Ingrediente(ItemCardapio.BACON.toString(), 2.00);
		Ingrediente hambCarne = new Ingrediente(ItemCardapio.HAMBURGUER_CARNE.toString(), 3.00);
		Ingrediente ovo = new Ingrediente(ItemCardapio.OVO.toString(), 0.80);
		Ingrediente queijo = new Ingrediente(ItemCardapio.QUEIJO.toString(), 1.50);
		
		Banco.ingredientesCardapio.add(alface);
		Banco.ingredientesCardapio.add(bacon);
		Banco.ingredientesCardapio.add(hambCarne);
		Banco.ingredientesCardapio.add(ovo);
		Banco.ingredientesCardapio.add(queijo);
		
		List<Ingrediente> ingredientesXBacon = new ArrayList<Ingrediente>();
		ingredientesXBacon.add(bacon);
		ingredientesXBacon.add(hambCarne);
		ingredientesXBacon.add(queijo);		
		Banco.lanchesCardapio.add(new Lanche(ItemCardapio.XBACON.toString(), ingredientesXBacon));
		
		List<Ingrediente> ingredientesXBurger = new ArrayList<Ingrediente>();
		ingredientesXBurger.add(hambCarne);
		ingredientesXBurger.add(queijo);		
		Banco.lanchesCardapio.add(new Lanche(ItemCardapio.XBURGER.toString(), ingredientesXBurger));
		
		List<Ingrediente> ingredientesXEgg = new ArrayList<Ingrediente>();
		ingredientesXEgg.add(ovo);
		ingredientesXEgg.add(hambCarne);
		ingredientesXEgg.add(queijo);		
		Banco.lanchesCardapio.add(new Lanche(ItemCardapio.XEGG.toString(), ingredientesXEgg));
		
		List<Ingrediente> ingredientesXEggBacon = new ArrayList<Ingrediente>();
		ingredientesXEggBacon.add(ovo);
		ingredientesXEggBacon.add(bacon);
		ingredientesXEggBacon.add(hambCarne);
		ingredientesXEggBacon.add(queijo);		
		Banco.lanchesCardapio.add(new Lanche(ItemCardapio.XEGG_BACON.toString(), ingredientesXEggBacon));
		
	}

	public List<Ingrediente> getIngredientesCardapio(){
		return Banco.ingredientesCardapio;
	}
	
	public List<Lanche> getLanchesCardapio(){
		return Banco.lanchesCardapio;		
	}
	
	public static Ingrediente getIngrediente(ItemCardapio ingrediente) {
		
		try {
					
			return ingredientesCardapio.stream().filter(i->i.getNome().equals(ingrediente.toString())).findFirst().get();
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	public static Lanche getLanche(ItemCardapio lanche) {
		
		try {
			
			return lanchesCardapio.stream().filter(i->i.getNome().equals(lanche.toString())).findFirst().get();
			
		} catch (Exception e) {
			return null;
		}
		
	}

}
