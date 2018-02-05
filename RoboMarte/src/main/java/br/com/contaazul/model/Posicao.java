package br.com.contaazul.model;

public class Posicao {
	
	private int posicaoY;
	private int posicaoX;
	private Orientacao orientacao;
		
	public Posicao(int posicaoY, int posicaoX, Orientacao orientacao) {
		this.posicaoY = posicaoY;
		this.posicaoX = posicaoX;
		this.orientacao = orientacao;
	}
	
	public int getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(int posicaoY) {
		this.posicaoY += posicaoY;
	}
	public int getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(int posicaoX) {
		this.posicaoX += posicaoX;
	}
	public Orientacao getDirecao() {
		return orientacao;
	}
	public void setDirecao(Orientacao direcao) {
		this.orientacao = direcao;
	}
	
	@Override
	public String toString() {
		
		return "(" + this.posicaoX + ", " + this.posicaoY + ", " + this.orientacao.getSigla() + ")";
	}
	
}
