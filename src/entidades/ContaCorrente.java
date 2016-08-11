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
		if(valor < 0)
			throw new IllegalArgumentException("N�o � premitido sacar valores menores que zero");
		if(saldo <= 0)
			throw new IllegalArgumentException("N�o tem saldo na conta");
		if(saldo - valor < 0)
			throw new IllegalArgumentException("Opera��o n�o permitida!");
		this.saldo = saldo - valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo = saldo + valor;
		
	}

}
