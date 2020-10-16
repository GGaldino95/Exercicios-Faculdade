package model;

public class Cliente {

	private String titular;
	private int conta;
	private double saldo;
	
	public Cliente(int conta, String nome) {
		this.conta = conta;
		this.titular = nome;
	}

	public Cliente(int conta, String nome, double saldoInicial) {
		this.conta = conta;
		this.titular = nome;
		depositar(saldoInicial);
	}

	public String getNome() {
		return titular;
	}
	public void setNome(String nome) {
		this.titular = nome;
	}

	public int getConta() {
		return conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public double depositar(double deposito) {
		return saldo += deposito;
	}
	
	public double sacar(double saque) {
		return saldo -= (saque + 5);
	}

	@Override
	public String toString() {
		return "Conta "+conta+", Titular: " + titular +", Saldo atual: R$"+String.format("%.2f", saldo);
	}
}
