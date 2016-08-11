package entidades;

public interface Conta {
	public double saldo();
	
	public void sacar(double valor);
	
	public void depositar(double valor);
}
