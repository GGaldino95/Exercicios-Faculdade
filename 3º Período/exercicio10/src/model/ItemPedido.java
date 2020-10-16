package model;

public class ItemPedido {

	// Atributos
	private Integer quantidade;
	private Double preco;
	
	// Composições
	private Produto produto;

	// Construtor default
	public ItemPedido() {
	}
	
	// Construtor
	public ItemPedido(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
	}

	// Getters e Setters
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	// Métodos
	public double subTotal() {
		return preco * quantidade;
	}

	// toString()
	@Override
	public String toString() {
		return 	getProduto().getNome() +
				", R$" + String.format("%.2f", preco +
				", Quantidade: " + quantidade +
				", Subtotal: R$" + String.format("%.2f", subTotal()));
	}
}
