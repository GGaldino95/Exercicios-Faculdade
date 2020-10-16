package model;

public final class Fisica extends Pessoa {

	// Atributos
	private Double despesaSaude;
	
	// Construtor default (vazio) com Herança
	public Fisica() {
		super();
	}
	
	// Construtor com Argumentos e Herança
	public Fisica(String nome, Double rendaAnual, Double despesaSaude) {
		super(nome, rendaAnual);
		this.despesaSaude = despesaSaude;
	}

	// Getters e Setters
	public Double getDespesaSaude() {
		return despesaSaude;
	}

	public void setDespesaSaude(Double despesaSaude) {
		this.despesaSaude = despesaSaude;
	}

	// Métodos
	@Override
	public Double imposto() {
		return (getRendaAnual() < 20000) ? getRendaAnual() * 0.15 - despesaSaude * 0.5 : getRendaAnual() * 0.25 - despesaSaude * 0.5;
		
		/*if (getRendaAnual() < 20000) {
			return (getRendaAnual() * 0.15) - (despesaSaude * 0.5);
		} else {
			return (getRendaAnual() * 0.25) - (despesaSaude * 0.5);
		} */
	}
}
