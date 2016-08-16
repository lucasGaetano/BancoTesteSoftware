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
		if(valor == 0)
			throw new IllegalArgumentException("N�o � premitido sacar valores iguais a zero");
		if(valor < 0)
			throw new IllegalArgumentException("N�o � premitido sacar valores menores que zero");
		if(saldo <= 0)
			throw new IllegalArgumentException("N�o tem saldo na conta");
		if(saldo - valor < 0)
			throw new IllegalArgumentException("Opera��o n�o permitida!");
		this.saldo = saldo - valor;
		this.saldo = saldo - 1.00;
	}

	@Override
	public void depositar(double valor) {
		if(valor < 0)
			throw new IllegalArgumentException("N�o � premitido depositar valores menores que zero");
		if(valor > 3000)
			throw new IllegalArgumentException("O limite do dep�sito � R$ 3.000,00");
		this.saldo = saldo + valor;
		this.saldo = saldo - 1.00;
	}

}
