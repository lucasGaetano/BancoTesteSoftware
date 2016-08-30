package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import entidades.Conta;
import entidades.ContaBase;

public class TesteContaBase {
	private Conta contaBase;
	
	@Rule
	public ExpectedException excecao = ExpectedException.none();;
	
	@Before
	public void criaContaCorrente() {
		contaBase = new ContaBase(100.00);
	}
	
	@Test
	public void saqueMaiorQueZeroMenorQueSaldoAtual() {
		contaBase.sacar(10.0);
		assertEquals(90.0,contaBase.saldo(),0.0001);
	}
	
	@Test
	public void saqueIgualAhZero() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("Não é permitido sacar valores iguais a zero");
		contaBase.sacar(0);
	}
	
	@Test
	public void saqueMenorQueZero() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("Não é permitido sacar valores menores que zero");
		contaBase.sacar(-10.0);
	}
	
	@Test
	public void saqueValorAtualIgualAhZero() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("Não é permitido sacar valores iguais a zero");
		contaBase.sacar(0);
	}
}
