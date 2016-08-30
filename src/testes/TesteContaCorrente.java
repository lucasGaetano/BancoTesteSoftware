package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import entidades.ContaCorrente;

public class TesteContaCorrente {
	private ContaCorrente contaCorrente;
	
	@Rule
	public ExpectedException excecao = ExpectedException.none();;
	
	@Before
	public void criaContaCorrente() {
		contaCorrente = new ContaCorrente(100.00);
	}
	
	@Test
	public void saqueMaiorQueZeroMenorQueSaldoAtual() {
		contaCorrente.sacar(10.0);
		assertEquals(89.0,contaCorrente.saldo(),0.0001);
	}
	
	@Test
	public void saqueIgualAhZero() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("Não é premitido sacar valores iguais a zero");
		contaCorrente.sacar(0);
	}
	
	@Test
	public void saqueMenorQueZero() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("Não é premitido sacar valores menores que zero");
		contaCorrente.sacar(-10.0);
	}
	
	@Test
	public void saqueValorAtualIgualAhZero() {
	excecao.expect(IllegalArgumentException.class);
	excecao.expectMessage("Não é premitido sacar valores iguais a zero");
	contaCorrente.sacar(0);
}
