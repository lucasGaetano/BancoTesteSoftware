package entidades;

public class ContaPoupanca implements Conta {
	private double saldo;
	private double limite;
	
	public ContaPoupanca(double limite) {
		this.limite = limite;
	}
	
	@Override
	public double saldo() {
		return saldo;
	}
	public double getLimite() {
		return this.limite;
	}

	@Override
	public void sacar(double valor) {
		if(valor == 0)
			throw new IllegalArgumentException("Não é premitido sacar valores iguais a zero");
		if(valor < 0)
			throw new IllegalArgumentException("Não é premitido sacar valores menores que zero");
		if(saldo <= 0)
			throw new IllegalArgumentException("Não tem saldo na conta");
		if(saldo - valor < 0)
			throw new IllegalArgumentException("Operação não permitida!");
		this.saldo = saldo - valor;
	}

	@Override
	public void depositar(double valor) {
		if(valor < 0)
			throw new IllegalArgumentException("Não é premitido depositar valores menores que zero");
		if(valor > 3000)
			throw new IllegalArgumentException("O limite do depósito é R$ 3.000,00");
		this.saldo = saldo + valor;
	}

}
