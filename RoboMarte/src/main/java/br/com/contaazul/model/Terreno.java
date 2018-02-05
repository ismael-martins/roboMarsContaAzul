package br.com.contaazul.model;

public class Terreno {

	private int largura;
	private int comprimento;
	
	public Terreno(int largura, int comprimento) {
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public int getLargura() {
		return largura;
	}
	
	public void setLargura(int largura) {
		this.largura = largura;
	}
	
	public int getComprimento() {
		return comprimento;
	}
	
	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}
		
}
