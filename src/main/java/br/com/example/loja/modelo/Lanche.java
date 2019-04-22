package br.com.example.loja.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Lanche {
	
	private int id;
	private String nome;
	private BigDecimal valor;
	private List<Ingrediente> ingredientes;
	private Promocao promocao;
	
	public Lanche(String nomeLanche, List<Ingrediente> ingredientesLanche) {
		this.nome = nomeLanche;
		this.ingredientes = ingredientesLanche;
		this.promocao = null;
		this.valor = new BigDecimal(0.00);
		calculaPrecoDoLanche(this.promocao);				
	}
	
	
	public Lanche(String nomeLanche, List<Ingrediente> ingredientesLanche, Promocao promocao) {
		this.nome = nomeLanche;
		this.promocao = promocao;	
		this.ingredientes = ingredientesLanche;
		this.valor = new BigDecimal(0.00);
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

	
	public BigDecimal getValor() {
		return valor.setScale(2, RoundingMode.DOWN);
	}

	
	public void setValor(double valor) {
		this.valor = new BigDecimal(valor);
	}

	
	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	
	private BigDecimal calculaPrecoDoLanche(Promocao promocao) {
		
		this.valor = new BigDecimal(0.00);
		
		for (Ingrediente ingrediente : this.ingredientes)
			this.valor = this.valor.add(ingrediente.getValor());
		
		if(promocao == null)
			return this.valor;
		
		this.promocao = promocao;
		
		switch (promocao)
		{
			case LIGHT:
				boolean temAlface = this.ingredientes.stream().filter(i->i.getNome().equals(ItemCardapio.ALFACE.toString())).findFirst().isPresent();
				boolean temBacon = this.ingredientes.stream().filter(i->i.getNome().equals(ItemCardapio.BACON.toString())).findFirst().isPresent();
				
				if(temAlface && !temBacon) 
					this.valor = this.valor.multiply(new BigDecimal(0.90));										
								
				break;
				
			case MUITA_CARNE:
				long totalCarne = this.ingredientes.stream().filter(i->i.getNome().equals(ItemCardapio.HAMBURGUER_CARNE.toString())).count();
				long carneFree = totalCarne/3;
				this.valor = this.valor.subtract(new BigDecimal(carneFree).multiply(Banco.getIngredienteCardapio(ItemCardapio.HAMBURGUER_CARNE).getValor()));
				
				break;
				
			case MUITO_QUEIJO:
				long totalQueijo = this.ingredientes.stream().filter(i->i.getNome().equals(ItemCardapio.QUEIJO.toString())).count();
				long queijoFree = totalQueijo/3;
				this.valor = this.valor.subtract((new BigDecimal(queijoFree)).multiply(Banco.getIngredienteCardapio(ItemCardapio.QUEIJO).getValor()));
				
				break;
		}		
		
		return this.valor;			
	}
	
	
	public void setPromocao(Promocao promocao) {
		calculaPrecoDoLanche(promocao);		
	}
	
	public Promocao getPromocao() {
		return this.promocao;
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
