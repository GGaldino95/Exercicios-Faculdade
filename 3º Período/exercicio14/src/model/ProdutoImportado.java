package model;

public final class ProdutoImportado extends Produto {

	// Atributos
	private Double taxaAlfandega;
	
	// Construtor default (vazio) com Heran�a
	public ProdutoImportado() {
		super();
	}

	// Construtor com Argumentos e Heran�a
	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	// Getters e Setters
	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	// M�todos
	public Double precoTotal() {
		return super.getPreco() + getTaxaAlfandega();
	}
	
	@Override
	public String etiquetaPreco() {
		return super.getNome() + " - R$" + String.format("%.2f", precoTotal()) + " (Taxa da Alf�ndega: R$" + getTaxaAlfandega() + ")";
	}	
}
