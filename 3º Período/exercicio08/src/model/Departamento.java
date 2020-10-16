package model;

public class Departamento {

	// Atributos
	private String nome;
	
	// Construtor default
	public Departamento() {
	}

	// Construtor
	public Departamento(String nome) {
		this.nome = nome;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
