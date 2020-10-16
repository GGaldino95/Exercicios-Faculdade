package model;

import model.enums.Cor;

public final class Retangulo extends Forma {

	// Atributos
	private Double largura;
	private Double altura;
	
	// Construtor default (vazio) com Herança
	public Retangulo() {
		super();
	}

	// Construtor com Argumentos e Herança
	public Retangulo(Cor cor, Double largura, Double altura) {
		super(cor);
		this.largura = largura;
		this.altura = altura;
	}

	// Getters e Setters
	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getaltura() {
		return altura;
	}

	public void setaltura(Double altura) {
		this.altura = altura;
	}


	
	// Métodos
	@Override
	public double area() {
		return largura * altura;
	}
}
