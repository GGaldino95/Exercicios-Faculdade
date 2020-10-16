package model;

import model.enums.Cor;

public abstract class Forma {

	// Atributos
	private Cor cor;
	
	// Construtor default(vazio)
	public Forma() {
	}

	// Construtor com Argumentos
	public Forma(Cor cor) {
		this.cor = cor;
	}

	// Getters e Setters
	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	// Métodos
	public abstract double area();
}
