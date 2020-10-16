package model;

public class Produto {

	// Atributos
	private String nome;
	private Double preco;
	
	// Construtor default
	public Produto() {
	}

	// Construtor
	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}	
}
