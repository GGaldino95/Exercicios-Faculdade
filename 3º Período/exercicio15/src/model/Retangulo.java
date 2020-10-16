package model;

import model.enums.Cor;

public final class Retangulo extends Forma {

	// Atributos
	private Double largura;
	private Double altura;
	
	// Construtor default (vazio) com Heran�a
	public Retangulo() {
		super();
	}

	// Construtor com Argumentos e Heran�a
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


	
	// M�todos
	@Override
	public double area() {
		return largura * altura;
	}
}
