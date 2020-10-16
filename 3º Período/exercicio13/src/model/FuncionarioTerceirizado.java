package model;

public final class FuncionarioTerceirizado extends Funcionario {

	// Atributos
	private Double despesaAdicional;
	
	// Construtor default (vazio) com Herança
	public FuncionarioTerceirizado() {
		super();
	}

	// Construtor com Argumentos e Herança
	public FuncionarioTerceirizado(String nome, Integer horas, Double valorHora, Double despesaAdicional) {
		super(nome, horas, valorHora);
		this.despesaAdicional = despesaAdicional;
	}

	// Getters e Setters
	public Double getDespesaAdicional() {
		return despesaAdicional;
	}
	public void setDespesaAdicional(Double despesaAdicional) {
		this.despesaAdicional = despesaAdicional;
	}
	
	// Métodos
	@Override
	public Double pagamento() {
		return super.pagamento() + despesaAdicional * 1.1;
	}
}
