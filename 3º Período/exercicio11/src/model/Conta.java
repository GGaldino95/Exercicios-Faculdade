package model;

public abstract class Conta { // 'abstract': Significa que essa Classe N�O pode ser instanciada. Apenas suas subClasses n�o-abstratas que podem ser instanciadas.

	// Atributos
	private Integer numero;
	private String titular;
	protected Double saldo; // Protected para que apenas subclasses (ContaEmpresarial) possam ver esse atributo.
	
	// Construtor Default
	public Conta() {
	}

	// Construtor com Argumentos
	public Conta(Integer numero, String titular, Double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	// Getters e Setters
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	// M�todos
	public void depositar(double quantia) {
		saldo += quantia;
	}
	public void sacar(double quantia) {
		saldo -= quantia + 5;
	}
	
	
	
}
