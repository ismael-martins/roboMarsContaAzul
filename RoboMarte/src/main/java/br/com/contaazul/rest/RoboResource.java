package br.com.contaazul.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.contaazul.controller.IRoboController;
import br.com.contaazul.controller.impl.RoboController;
import br.com.contaazul.exception.ExceededAreaException;
import br.com.contaazul.model.Posicao;

@RestController
public class RoboResource {

	private IRoboController service;

	@RequestMapping(value = "/rest/mars/{movimento}", method = RequestMethod.POST)
	public ResponseEntity<String> listar(@PathVariable(value = "movimento") String movimento) {

		try {
			service = new RoboController();
			Posicao posicao = service.moverRobo(movimento);
			return new ResponseEntity<String>(posicao.toString(), HttpStatus.OK);
		} catch (IllegalArgumentException | ExceededAreaException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
