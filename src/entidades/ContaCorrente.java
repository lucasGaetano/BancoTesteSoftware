package entidades;

public class ContaCorrente implements Conta {
	private ContaBase base;
	private double limite;

	public ContaCorrente(double saldo) {
		this(saldo,5000.0);
	}
	
	public ContaCorrente(double saldo, double limite) {
		this(new ContaBase(saldo),limite);
	}
	
	public ContaCorrente(ContaBase base, double limite) {
		this.base = base;
		this.limite = limite;
	}

	@Override
	public double saldo() {
		return base.saldo();
	}

	@Override
	public void sacar(double valor) {
		
		if(valor > limite)
			throw new IllegalArgumentException("O limite do saque � R$ " + limite);
		base.sacar(valor);
	}

	@Override
	public void depositar(double valor) {
		if(valor < 0)
			throw new IllegalArgumentException("N�o � permitido depositar valores menores que zero");
		if(valor > limite)
			throw new IllegalArgumentException("O limite do dep�sito � R$ " + limite);
		base.depositar(valor);
	}

}
