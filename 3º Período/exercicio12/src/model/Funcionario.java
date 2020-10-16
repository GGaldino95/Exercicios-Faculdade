package model;

public class Funcionario {

	private Integer id;
	private String nome;
	private Double salario;
	
	public Funcionario() {
	}

	public Funcionario(int id, String nome, double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}
	
	public void aumentarSalario(double porcentagem) {
		salario += salario * porcentagem / 100;
	}

	@Override
	public String toString() {
		return id + ", " + nome + ", R$" + String.format("%.2f", salario);
	}
	
	
}
