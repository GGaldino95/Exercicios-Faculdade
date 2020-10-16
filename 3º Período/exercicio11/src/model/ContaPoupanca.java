package model;

public final class ContaPoupanca extends Conta { // 'final': Imposibilita criar subClasses de ContaPoupanca.

	// Atributos
	private double taxaJuros;
	
	// Construtor Default com Herança
	public ContaPoupanca() {
		super();
	}

	// Construtor com Argumentos e Herança
	public ContaPoupanca(Integer numero, String titular, Double saldo, double taxaJuros) {
		super(numero, titular, saldo);
		this.taxaJuros = taxaJuros;
	}

	// Getters e Setters
	public double getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	// Métodos
	public void atualizarSaldo() {
		saldo += saldo * taxaJuros;
	}
	
	@Override // Significa que existe o mesmo método na superClasse, mas este aqui possui comandos diferentes.
	public final void sacar(double quantia) { // 'final': Impossibilita criar sobreposições (@Override) deste método.
		saldo -= quantia;
	}
	
	/* OBS!: Se não for declarado o Override antes do método, caso haja algum erro no nome, o Eclipse não irá detectar. 
	 * ex:
	 * 
	 * @Override
	 * public void sacr(double quantia) {
	 * } 
	 * 
	 * O Eclipse dará o alerta de erro pois ele não irá encontrar na superClasse um método chamado 'sacr'. */
}
