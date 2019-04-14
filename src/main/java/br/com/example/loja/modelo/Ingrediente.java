package br.com.example.loja.modelo;

public class Ingrediente {
	
	private static int lastId = 0;
	private int id;
	private String nome;
	private double valor;
	
	public Ingrediente(String nomeIngrediente, double valorIngrediente) {
		Ingrediente.lastId++;
		this.id = lastId;
		this.nome = nomeIngrediente;
		this.valor = valorIngrediente;
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

}
