package model;

import model.enums.Cor;

public final class Circulo extends Forma{

	// Atributos
	private Double raio;
	
	// Construto default (vazio) com Heran�a
	public Circulo() {
		super();
	}

	// Construtor com Argumentos e Heran�a
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
	
	// M�todos
	@Override
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}
}
