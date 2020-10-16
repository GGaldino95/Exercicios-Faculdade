package model;

import model.enums.Cor;

public final class Circulo extends Forma{

	// Atributos
	private Double raio;
	
	// Construto default (vazio) com Herança
	public Circulo() {
		super();
	}

	// Construtor com Argumentos e Herança
	public Circulo(Cor cor, Double raio) {
		super(cor);
		this.raio = raio;
	}

	// Getters e Setters
	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}
	
	// Métodos
	@Override
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}
}
