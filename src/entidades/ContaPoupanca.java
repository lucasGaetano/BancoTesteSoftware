package entidades;

public class ContaPoupanca implements Conta {
	private ContaBase base;
	private double limite;
	
	public ContaPoupanca(double saldo) {
		this(saldo,2000.0);
	}
	
	public ContaPoupanca(double saldo, double limite) {
		this(new ContaBase(saldo),limite);
	}
	
	public ContaPoupanca(ContaBase base, double limite) {
		this.base = base;
		this.limite = limite;
	}
	
	@Override
	public double saldo() {
		return base.saldo();
	}
	public double getLimite() {
		return this.limite;
	}

	@Override
	public void sacar(double valor) {
		if(valor > 2000)
			throw new IllegalArgumentException("O limite do saque é R$ " + limite);
		base.sacar(valor);
	}

	@Override
	public void depositar(double valor) {
		if(valor < 0)
			throw new IllegalArgumentException("Não é premitido depositar valores menores que zero");
		if(valor > 2000)
			throw new IllegalArgumentException("O limite do depósito é R$ " + limite);
		base.depositar(valor);
	}

}
