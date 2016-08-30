package entidades;

public class ContaBase implements Conta {
	private double saldo;

	public ContaBase(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public double saldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		if(valor == 0)
			throw new IllegalArgumentException("N�o � permitido sacar valores iguais a zero");
		if(valor < 0)
			throw new IllegalArgumentException("N�o � permitido sacar valores menores que zero");
		if(saldo() <= 0)
			throw new IllegalArgumentException("N�o tem saldo suficiente para o saque desejado");
		if(saldo() - valor < 0)
			throw new IllegalArgumentException("Opera��o n�o permitida!");
		saldo = saldo - valor;
	}

	@Override
	public void depositar(double valor) {
		saldo = saldo + valor;
	}
}
