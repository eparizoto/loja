package br.com.example.loja.modelo;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Lanche {
	
	private static int lastId = 0;
	private int id;
	private String nome;
	private double valor;
	private List<Ingrediente> ingredientes;
	private Promocao promocao;
	
	public Lanche(String nomeLanche, List<Ingrediente> ingredientesLanche) {
		Lanche.lastId++;
		this.id = lastId;
		this.nome = nomeLanche;
		this.ingredientes = ingredientesLanche;
		this.promocao = null;
		this.valor = 0.00;
		calculaPrecoDoLanche(this.promocao);				
	}
	
	public Lanche(String nomeLanche, List<Ingrediente> ingredientesLanche, Promocao promocao) {
		Lanche.lastId++;
		this.id = lastId;
		this.nome = nomeLanche;
		this.promocao = promocao;	
		this.ingredientes = ingredientesLanche;
		this.valor = 0.00;
		calculaPrecoDoLanche(this.promocao);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	private double calculaPrecoDoLanche(Promocao promocao) {
		
		this.valor = 0.00;
		
		for (Ingrediente ingrediente : ingredientes)
			this.valor += ingrediente.getValor();
		
		if(promocao == null)
			return 0.00;
		
		this.promocao = promocao;
		
		switch (promocao)
		{
			case LIGHT:
				boolean temAlface = ingredientes.stream().filter(i->i.getNome().equals(ItemCardapio.ALFACE.toString())).findFirst().isPresent();
				boolean temBacon = ingredientes.stream().filter(i->i.getNome().equals(ItemCardapio.BACON.toString())).findFirst().isPresent();
				
				if(temAlface && !temBacon) 
					this.valor = valor * 0.90;										
								
				break;
				
			case MUITA_CARNE:
				long totalCarne = ingredientes.stream().filter(i->i.getNome().equals(ItemCardapio.HAMBURGUER_CARNE.toString())).count();
				long carneFree = totalCarne/3;
				this.valor = valor - (carneFree * Banco.getIngredienteCardapio(ItemCardapio.HAMBURGUER_CARNE).getValor());
				
				break;
				
			case MUITO_QUEIJO:
				long totalQueijo = ingredientes.stream().filter(i->i.getNome().equals(ItemCardapio.QUEIJO.toString())).count();
				long queijoFree = totalQueijo/3;
				this.valor = valor - (queijoFree * Banco.getIngredienteCardapio(ItemCardapio.QUEIJO).getValor());
				
				break;
		}
		
		return this.valor;			
	}
	
	public void setPromocao(Promocao promocao) {
		calculaPrecoDoLanche(promocao);		
	}


	public void addIngredienteNoLanche(Ingrediente ingrediente) {		
		this.getIngredientes().add(ingrediente);
		this.calculaPrecoDoLanche(null);		
	}
	
	@Override
	public String toString() {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	

}
