package model;

public final class ContaPoupanca extends Conta { // 'final': Imposibilita criar subClasses de ContaPoupanca.

	// Atributos
	private double taxaJuros;
	
	// Construtor Default com Heran�a
	public ContaPoupanca() {
		super();
	}

	// Construtor com Argumentos e Heran�a
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
	
	// M�todos
	public void atualizarSaldo() {
		saldo += saldo * taxaJuros;
	}
	
	@Override // Significa que existe o mesmo m�todo na superClasse, mas este aqui possui comandos diferentes.
	public final void sacar(double quantia) { // 'final': Impossibilita criar sobreposi��es (@Override) deste m�todo.
		saldo -= quantia;
	}
	
	/* OBS!: Se n�o for declarado o Override antes do m�todo, caso haja algum erro no nome, o Eclipse n�o ir� detectar. 
	 * ex:
	 * 
	 * @Override
	 * public void sacr(double quantia) {
	 * } 
	 * 
	 * O Eclipse dar� o alerta de erro pois ele n�o ir� encontrar na superClasse um m�todo chamado 'sacr'. */
}
