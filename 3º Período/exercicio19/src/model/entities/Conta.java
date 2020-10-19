package model.entities;

import model.exceptions.SaqueException;

public class Conta {

	// Atributos
	private Integer conta;
	private String titular;
	private Double saldo;
	private Double limite;
	
	// Construtor default (vazio)
	public Conta() {
	}

	// Construtor com Argumentos
	public Conta(Integer conta, String titular, Double saldo, Double limite) {
		this.conta = conta;
		this.titular = titular;
		this.saldo = saldo;
		this.limite = limite;
	}

	// Getters e Setters
	public Integer getConta() {
		return conta;
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
	
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	// Métodos
	public Double sacar(double quantia) throws SaqueException {
		if (quantia > limite) 
			throw new SaqueException("Quantia informada excede o limite disponível.");
		
		if (quantia > saldo)
			throw new SaqueException("Quantia informada excede o saldo disponível.");
		
		return saldo -= quantia;
	}
	
	public Double depositar(double quantia) {
		return saldo += quantia;
	}
}
