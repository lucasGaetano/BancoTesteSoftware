package entidades;

public class ContaCorrente implements Conta {
	private double saldo;

	public ContaCorrente(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public double saldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		this.saldo = saldo - valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo = saldo + valor;
		
	}

}
