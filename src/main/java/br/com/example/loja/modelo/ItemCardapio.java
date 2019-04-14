package br.com.example.loja.modelo;

public enum ItemCardapio {
	ALFACE("Alface"),
	BACON("Bacon"),
	HAMBURGUER_CARNE("Hamburguer de Carne"),
	OVO("Ovo"),
	QUEIJO("Queijo"),
	XBACON("X-Bacon"),
	XBURGER("X-Burger"),
	XEGG("X-Egg"),
	XEGG_BACON("X-EggBacon")
	;
		
	private final String text;
	
	ItemCardapio(final String text){
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
	
}
