package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entidades.ContaCorrente;

public class TesteContaCorrente {
	
	@Test
	public void saqueMaiorQueZeroMenorQueSaldoAtual() {
		ContaCorrente de = new ContaCorrente (100.00);
		de.sacar(10.0);
		assertEquals(89.0,de.saldo(),0.0001);
	}

}
