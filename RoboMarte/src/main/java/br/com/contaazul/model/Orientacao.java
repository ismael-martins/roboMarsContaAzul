package br.com.contaazul.model;

public enum Orientacao {

	NORTE("N"),
	SUL("S"),
	LESTE("E"),
	OESTE("W");
	
	private String sigla;
	
	private Orientacao(String sigla){
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return this.sigla;
	}
}
