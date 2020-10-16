package model;

public class Produto {

	// Atributos
	private String nome;
	private Double preco;
	
	// Construtor default (vazio)
	public Produto() {
	}

	// Construtor com Argumentos
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
	
	// Métodos
	public String etiquetaPreco() { 
		return nome + " - R$" + String.format("%.2f", preco);
	}	
}
