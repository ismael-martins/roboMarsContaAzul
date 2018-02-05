package br.com.contaazul.controller;

import br.com.contaazul.exception.ExceededAreaException;
import br.com.contaazul.model.Posicao;

public interface IRoboController {

	public Posicao moverRobo(String movimento) throws IllegalArgumentException, ExceededAreaException;
}
