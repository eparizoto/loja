package br.com.example.loja.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ingrediente {
	
	private int id;
	private String nome;
	private BigDecimal valor;
	
	public Ingrediente(String nomeIngrediente, double valorIngrediente) {
		this.nome = nomeIngrediente;
		this.valor = new BigDecimal(valorIngrediente);
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

		
	
}
