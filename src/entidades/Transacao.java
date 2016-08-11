package entidades;

public interface Transacao {
	public void executa(Conta conta1, Conta conta2, double valor);
}
