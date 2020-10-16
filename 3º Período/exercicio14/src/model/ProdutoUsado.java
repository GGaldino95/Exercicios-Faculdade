package model;

import java.util.Date;

public final class ProdutoUsado extends Produto {

	// Atributos
	private Date dataFabricacao;
	
	// Construtor default (vazio) com Herança
	public ProdutoUsado() {
		super();
	}
	
	// Construtor com Argumentos e Herança
	public ProdutoUsado(String nome, Double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}


	// Getters e Setters
	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	// Métodos
	@Override
	public String etiquetaPreco() {
		return super.getNome() + " (Usado) - R$" + String.format("%.2f", super.getPreco()) + " (Data de fabricação: " + getDataFabricacao() + ")";
	}	
}
