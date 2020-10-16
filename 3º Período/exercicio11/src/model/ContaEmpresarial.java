package model;

public final class ContaEmpresarial extends Conta { // 'final': Imposibilita criar subClasses de ContaEmpresarial.

	// Atributos
	private Double limiteEmprestimo;
	
	// Construtor Default com Herança
	public ContaEmpresarial() {
		super();
	}

	// Construtor com Argumentos e Herança
	public ContaEmpresarial(Integer numero, String titular, Double saldo, Double limiteEmprestimo) {
		super(numero, titular, saldo);
		this.limiteEmprestimo = limiteEmprestimo;
	}

	// Getters e Setters
	public Double getLimiteEmprestimo() {
		return limiteEmprestimo;
	}
	public void setLimiteEmprestimo(Double limiteEmprestimo) {
		this.limiteEmprestimo = limiteEmprestimo;
	}
	
	// Métodos
	public void emprestimo(double quantia) {
		if (quantia <= limiteEmprestimo) {
			saldo += quantia - 10;
		}
	}
	
	@Override // Significa que existe o mesmo método na superClasse, mas este aqui possui comandos diferentes.
	public void sacar(double quantia) { // Esse método consiste em realizar o saque normalmente como se fosse do tipo Conta, e descontar mais 2 reais de taxa.
		super.sacar(quantia); // 'super': usado pra chamar o método da superClasse.
		saldo -= 2;
	}
}
