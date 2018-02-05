package br.com.contaazul.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.contaazul.controller.impl.RoboController;
import br.com.contaazul.exception.ExceededAreaException;
import br.com.contaazul.model.Orientacao;
import br.com.contaazul.model.Posicao;

public class RoboTest {

	@Test(expected = ExceededAreaException.class)
	public void testExcederLimiteAreaNorte() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		controller.moverRobo("MMMMMM");
	}
	
	@Test(expected = ExceededAreaException.class)
	public void testExcederLimiteAreaSul() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		controller.moverRobo("RRMMMMMM");
	}
	
	@Test(expected = ExceededAreaException.class)
	public void testExcederLimiteAreaOeste() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		controller.moverRobo("LM");
	}
	
	@Test(expected = ExceededAreaException.class)
	public void testExcederLimiteAreaLeste() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		controller.moverRobo("RMMMMMM");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgument() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		controller.moverRobo("MME");
	}
	
	@Test
	public void testUmMovimentoNorte() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		Posicao posicao = controller.moverRobo("MM");
		Assert.assertEquals(2, posicao.getPosicaoY());
		Assert.assertEquals(0, posicao.getPosicaoX());
		Assert.assertEquals(Orientacao.NORTE, posicao.getDirecao());
	}
	
	@Test
	public void testUmMovimentoLeste() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		Posicao posicao = controller.moverRobo("MMR");
		Assert.assertEquals(2, posicao.getPosicaoY());
		Assert.assertEquals(0, posicao.getPosicaoX());
		Assert.assertEquals(Orientacao.LESTE, posicao.getDirecao());
	}
	
	@Test
	public void testUmMovimentoSul() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		Posicao posicao = controller.moverRobo("MMRR");
		Assert.assertEquals(2, posicao.getPosicaoY());
		Assert.assertEquals(0, posicao.getPosicaoX());
		Assert.assertEquals(Orientacao.SUL, posicao.getDirecao());
	}
	
	@Test
	public void testUmMovimentoOeste() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		Posicao posicao = controller.moverRobo("MML");
		Assert.assertEquals(2, posicao.getPosicaoY());
		Assert.assertEquals(0, posicao.getPosicaoX());
		Assert.assertEquals(Orientacao.OESTE, posicao.getDirecao());
	}
	
	@Test
	public void testUmMovimentoNorteLeste() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		Posicao posicao = controller.moverRobo("MMMRMM");
		Assert.assertEquals(3, posicao.getPosicaoY());
		Assert.assertEquals(2, posicao.getPosicaoX());
		Assert.assertEquals(Orientacao.LESTE, posicao.getDirecao());
	}
	
	@Test
	public void testUmMovimentoNorteLesteSul() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		Posicao posicao = controller.moverRobo("MMRMRM");
		Assert.assertEquals(1, posicao.getPosicaoY());
		Assert.assertEquals(1, posicao.getPosicaoX());
		Assert.assertEquals(Orientacao.SUL, posicao.getDirecao());
	}
	
	@Test
	public void testUmMovimentoNorteLesteSulOeste() throws IllegalArgumentException, ExceededAreaException {
		RoboController controller = new RoboController();
		Posicao posicao = controller.moverRobo("MMMRMMRMRM");
		Assert.assertEquals(2, posicao.getPosicaoY());
		Assert.assertEquals(1, posicao.getPosicaoX());
		Assert.assertEquals(Orientacao.OESTE, posicao.getDirecao());
	}
}
