package model;

public class Funcionario {

	// Atributos
	private String nome;
	private Integer horas;
	private Double valorHora;
		
	// Contrutor default (vazio)
	public Funcionario() {
	}

	// Construtor com Argumentos
	public Funcionario(String nome, Integer horas, Double valorHora) {
		this.nome = nome;
		this.horas = horas;
		this.valorHora = valorHora;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Double getValorHora() {
		return valorHora;
	}
	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	// Métodos
	public Double pagamento() {
		return horas * valorHora;
	}
	
	// toString
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", horas=" + horas + ", valorHora=" + valorHora + "]";
	}
}
