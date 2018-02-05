package br.com.contaazul.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import br.com.contaazul.controller.IRoboController;
import br.com.contaazul.exception.ExceededAreaException;
import br.com.contaazul.model.MovimentoEnum;
import br.com.contaazul.model.Orientacao;
import br.com.contaazul.model.Posicao;
import br.com.contaazul.model.Terreno;

@Service
public class RoboController implements IRoboController {

	private Posicao posicao;
	private Terreno terreno;

	public RoboController() {
		posicao = new Posicao(0, 0, Orientacao.NORTE);
		terreno = new Terreno(5, 5);
	}

	public Posicao moverRobo(String movimento) throws IllegalArgumentException, ExceededAreaException {

		validaComandos(movimento);

		List<MovimentoEnum> movimentos = obterMovimentos(movimento);
		for (MovimentoEnum mov : movimentos) {
			executarMovimento(mov);
			validaPosicaoTerreno();
		}

		return posicao;
	}

	private void validaPosicaoTerreno() throws ExceededAreaException {
		
		if (posicao.getPosicaoX() > terreno.getLargura() || posicao.getPosicaoY() > terreno.getComprimento() ||
				posicao.getPosicaoX() < 0 || posicao.getPosicaoY() < 0) {
			System.out.println(posicao.getPosicaoX() + " - " + posicao.getPosicaoY());
			throw new ExceededAreaException("400 Bad Request");
		}
	}

	private void validaComandos(String movimento) throws IllegalArgumentException {
		Pattern pattern = Pattern.compile("[MLR]*");
		Matcher matcher = pattern.matcher(movimento);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("400 Bad Request");
		}
	}

	private void executarMovimento(MovimentoEnum mov) {

		switch (mov) {
		case FRENTE:
			avancaRobo();
			break;
		case DIREITA:
			girarRoboDireita();
			break;
		case ESQUERDA:
			girarRoboEsquerda();
		default:
			break;
		}

	}

	private void girarRoboEsquerda() {

		switch (posicao.getDirecao()) {
		case NORTE:
			posicao.setDirecao(Orientacao.OESTE);
			break;
		case SUL:
			posicao.setDirecao(Orientacao.LESTE);
			break;
		case OESTE:
			posicao.setDirecao(Orientacao.SUL);
			break;
		case LESTE:
			posicao.setDirecao(Orientacao.NORTE);

		default:
			break;
		}
	}

	private void girarRoboDireita() {

		switch (posicao.getDirecao()) {
		case NORTE:
			posicao.setDirecao(Orientacao.LESTE);
			break;
		case SUL:
			posicao.setDirecao(Orientacao.OESTE);
			break;
		case OESTE:
			posicao.setDirecao(Orientacao.NORTE);
			break;
		case LESTE:
			posicao.setDirecao(Orientacao.SUL);

		default:
			break;
		}
	}

	private void avancaRobo() {

		switch (posicao.getDirecao()) {
		case NORTE:
			posicao.setPosicaoY(+1);
			break;
		case SUL:
			posicao.setPosicaoY(-1);
			break;
		case LESTE:
			posicao.setPosicaoX(+1);
			break;
		case OESTE:
			posicao.setPosicaoX(-1);

		default:
			break;
		}

	}

	private List<MovimentoEnum> obterMovimentos(String movimento) {

		List<MovimentoEnum> movimentos = new ArrayList<MovimentoEnum>();
		char[] charArray = movimento.toCharArray();

		for (char c : charArray) {
			switch (c) {
			case 'M':
				movimentos.add(MovimentoEnum.FRENTE);
				break;
			case 'R':
				movimentos.add(MovimentoEnum.DIREITA);
				break;
			case 'L':
				movimentos.add(MovimentoEnum.ESQUERDA);
				break;

			default:
				break;
			}
		}
		return movimentos;
	}

}
