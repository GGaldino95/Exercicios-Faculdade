package model;

import java.util.Date;

public class Contrato {

	// Atributos
	private Date data;
	private Double valorHora;
	private Integer horas;
	
	// Construtor default
	public Contrato() {
	}

	// Construtor
	public Contrato(Date data, Double valorHora, Integer horas) {
		this.data = data;
		this.valorHora = valorHora;
		this.horas = horas;
	}

	// Getters e Setters
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorHora() {
		return valorHora;
	}
	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	// Métodos
	public double valorTotal() { // Calcular o valor total do contrato multiplicando o valor da hora pelo total de horas.
		return valorHora * horas;
	}
}
