package model;

public final class Juridica extends Pessoa {

	// Atributos
	private Integer numFuncionarios;
	
	// Construtor default (vazio) com Heran�a
	public Juridica() {
		super();
	}
	
	// Construtor com Argumentos e Heran�a
	public Juridica(String nome, Double rendaAnual, Integer numFuncionarios) {
		super(nome, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}
	
	// Getters e Setters
	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	// M�todos
	@Override
	public Double imposto() {
		return (numFuncionarios >= 10) ? getRendaAnual() * 0.14 : getRendaAnual() * 0.16;
		
		/*if (numFuncionarios >= 10) {
			return getRendaAnual() * 0.14;
		} else {
			return getRendaAnual() * 0.16;
		}*/
	}
}
