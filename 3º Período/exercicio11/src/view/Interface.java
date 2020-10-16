package view;

import java.util.ArrayList;
import java.util.List;

import model.Conta;
import model.ContaEmpresarial;
import model.ContaPoupanca;

public class Interface {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// Conta conta = new Conta(1001, "Alex", 0.0); // Erro: N�o � possivel instanciar uma classe abstrata.
		ContaEmpresarial contaE = new ContaEmpresarial(1002, "Maria", 0.0, 500.0);
		ContaPoupanca contaP = new ContaPoupanca();
		
		/* === POLIMORFISMO === 
		 * Permite vari�veis de um mesmo tipo gen�rico (Conta) possam apontar para objetos de tipos espec�ficos 
		 * (ContaEmpresarial / ContaPoupan�a) diferentes, tendo assim comportamentos diferentes conforme cada tipo espec�fico. */
		
		// UPCASTING - Convers�o de um objeto da subClasse para uma superClasse.
		Conta conta2 = contaE; // Atribui��o de uma 'contaE' do tipo Empresarial para uma 'conta2' do tipo Conta.
		Conta conta3 = new ContaEmpresarial(1003, "Bob", 0.0, 1200.0); // N�o d� erro pois est� atribuindo um objeto da subclasse 'Empresarial' para uma superClasse 'Conta'.
		Conta conta4 = new ContaPoupanca(1004, "Anna", 0.0, 0.01); // N�o d� erro pois est� atribuindo um objeto da subclasse 'Poupan�a' para uma superClasse 'Conta'.
		
		// OBS!: A vari�vel do tipo abstrato 'Conta' pode ser instanciado com as subClasses que n�o s�o abstratas.
		// OBS!: A associa��o do tipo espec�fico (ContaEmpresarial / ContaPoupan�a) com o tipo gen�rico (Conta) � feita em tempo de execu��o (upcasting).
		
				
		// DOWNCASTING - Convers�o de um objeto da superClasse para uma subClasse.
		//ContaEmpresarial conta5 = (ContaEmpresarial)conta3; // NESTE CASO DAR� ERRO DE EXCE��O!
		
		/* OBS!: Nem sempre o downcasting dar� certo da forma acima. Para isso, se faz necess�rio o uso do 'instanceof'. */
		if (conta3 instanceof ContaEmpresarial) {
			ContaEmpresarial conta5 = (ContaEmpresarial)conta3; // Se faz necess�rio o uso do typecasting (ContaEmpresarial).
			conta5.emprestimo(200);
			System.out.println("Empr�stimo!");
		} else if (conta3 instanceof ContaPoupanca) {
			ContaPoupanca conta5 = (ContaPoupanca)conta3; // Se faz necess�rio o uso do typecasting (ContaPoupanca).
			conta5.atualizarSaldo();
			System.out.println("Atualiza��o de Saldo!");
		}
		
		// OVERRIDE - Sobreposi��o de m�todos entre subClasses e superClasses.
		//Conta conta6 = new Conta(1010, "Alex", 1000.0);
		//conta6.sacar(200);
		//System.out.println(conta6.getSaldo()); // Dar� 795 pois o objeto 'conta6' � da superClasse Conta, ent�o o m�todo de saque tem 5 reais de taxa.
		
		Conta conta7 = new ContaPoupanca(1011, "Maria", 1000.0, 0.01);
		conta7.sacar(200);
		System.out.println(conta7.getSaldo()); // Dar� 800 pois o objeto 'conta7' � da subClasse Poupan�a, ent�o o m�todo de saque n�o tem taxa.
		
		Conta conta8 = new ContaEmpresarial(1012, "Carlos", 1000.0, 500.0);
		conta8.sacar(200);
		System.out.println(conta8.getSaldo()); // Dar� 793 pois o objeto 'conta7' � da subClasse Empresarial, ent�o o m�todo de saque tem 5 reais de taxa, mais 2 reais.
		
		// OBS!: O compilador n�o sabe para qual tipo espec�fico a chamada do m�todo 'sacar' est� sendo feita (ele s� sabe que s�o vari�veis do tipo 'Conta').
		
		// === ABSTRA��O ===
		List<Conta> lista = new ArrayList<>();
		
		lista.add(new ContaPoupanca(2000, "Gabriel", 500.0, 0.01));
		lista.add(new ContaEmpresarial(2001, "Bean", 1000.0, 400.0));
		lista.add(new ContaPoupanca(2002, "Monicke", 300.0, 0.01));
		lista.add(new ContaEmpresarial(2003, "Black", 500.0, 500.0));
		
		double soma = 0;
		for (Conta conta : lista) { 
			soma += conta.getSaldo();
		} // Somando todos os saldos de todas as contas existentes na lista (tanto Poupan�a quanto Empresarial).
		
		System.out.printf("Saldo total existente: %.2f%n", soma);
		
		for (Conta conta : lista) { 
			conta.depositar(10.0);
		} // Depositando 10 reais em todas as contas existentes na lista.
		
		for (Conta conta : lista) { 
			System.out.printf("Saldo atualizado da conta N�%d: %.2f%n", conta.getNumero(), conta.getSaldo());
		} // Exibindo o saldo atualizado de todas as contas existentes na lista.
	}
}
