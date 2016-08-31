package testes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import entidades.ContaPoupanca;

public class TesteContaPoupanca {
	private ContaPoupanca contaPoupanca;
	
	@Rule
	public ExpectedException excecao = ExpectedException.none();;
	
	@Before
	public void criaContaPoupanca() {
		contaPoupanca = new ContaPoupanca(100.00);
	}
	@Test
	public void depositoAcimaDeDoisMil() {
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("O limite do depósito é R$ 2000.0");
		contaPoupanca.depositar(2000.01);
	}
	@Test
	public void saqueAcimaDeDoisMil() {
		contaPoupanca = new ContaPoupanca(3000.0);
		excecao.expect(IllegalArgumentException.class);
		excecao.expectMessage("O limite do saque é R$ 2000.0");
		contaPoupanca.sacar(2000.01);
	}
}
