package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import entidades.ContaCorrente;

public class TesteContaBase {
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
		assertEquals(90.0,contaCorrente.saldo(),0.0001);
	}
	
	@Test
	public void saqueIgualAhZero() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("Não é permitido sacar valores iguais a zero");
		contaCorrente.sacar(0);
	}
	
	@Test
	public void saqueMenorQueZero() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("Não é permitido sacar valores menores que zero");
		contaCorrente.sacar(-10.0);
	}
	
	@Test
	public void saqueValorAtualIgualAhZero() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("Não é permitido sacar valores iguais a zero");
		contaCorrente.sacar(0);
	}
	@Test
	public void depositoAcimaDeCincoMil() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("O limite do depósito é R$ 5000.0");
		contaCorrente.depositar(5000.01);
	}
	@Test
	public void saqueAcimaDeCincoMil() {
		contaCorrente = new ContaCorrente(6000.0);
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("O limite do saque é R$ 5000.0");
		contaCorrente.sacar(5000.01);
	}
}
