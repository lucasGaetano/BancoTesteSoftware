package entidades;

public class Transferencia implements Transacao {
	private Conta de;
	private Conta para;
	private double valor;
	
	public Transferencia(Conta de, Conta para, double valor) {
		this.de = de;
		this.para = para;
		this.valor = valor;
	}

	@Override
	public void executa() {
		de.sacar(valor);
		para.depositar(valor);
	}
}