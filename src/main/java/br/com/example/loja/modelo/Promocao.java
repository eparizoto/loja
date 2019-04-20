package br.com.example.loja.modelo;

public enum Promocao {	
	LIGHT("Light"),
	MUITA_CARNE("Muita Carne"),
	MUITO_QUEIJO("Muito Queijo");
	
	private final String text;
	
	Promocao (final String text){
		this.text =text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	

}
