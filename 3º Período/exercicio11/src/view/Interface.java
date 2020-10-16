package view;

import java.util.ArrayList;
import java.util.List;

import model.Conta;
import model.ContaEmpresarial;
import model.ContaPoupanca;

public class Interface {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// Conta conta = new Conta(1001, "Alex", 0.0); // Erro: Não é possivel instanciar uma classe abstrata.
		ContaEmpresarial contaE = new ContaEmpresarial(1002, "Maria", 0.0, 500.0);
		ContaPoupanca contaP = new ContaPoupanca();
		
		/* === POLIMORFISMO === 
		 * Permite variáveis de um mesmo tipo genérico (Conta) possam apontar para objetos de tipos específicos 
		 * (ContaEmpresarial / ContaPoupança) diferentes, tendo assim comportamentos diferentes conforme cada tipo específico. */
		
		// UPCASTING - Conversão de um objeto da subClasse para uma superClasse.
		Conta conta2 = contaE; // Atribuição de uma 'contaE' do tipo Empresarial para uma 'conta2' do tipo Conta.
		Conta conta3 = new ContaEmpresarial(1003, "Bob", 0.0, 1200.0); // Não dá erro pois está atribuindo um objeto da subclasse 'Empresarial' para uma superClasse 'Conta'.
		Conta conta4 = new ContaPoupanca(1004, "Anna", 0.0, 0.01); // Não dá erro pois está atribuindo um objeto da subclasse 'Poupança' para uma superClasse 'Conta'.
		
		// OBS!: A variável do tipo abstrato 'Conta' pode ser instanciado com as subClasses que não são abstratas.
		// OBS!: A associação do tipo específico (ContaEmpresarial / ContaPoupança) com o tipo genérico (Conta) é feita em tempo de execução (upcasting).
		
				
		// DOWNCASTING - Conversão de um objeto da superClasse para uma subClasse.
		//ContaEmpresarial conta5 = (ContaEmpresarial)conta3; // NESTE CASO DARÁ ERRO DE EXCEÇÃO!
		
		/* OBS!: Nem sempre o downcasting dará certo da forma acima. Para isso, se faz necessário o uso do 'instanceof'. */
		if (conta3 instanceof ContaEmpresarial) {
			ContaEmpresarial conta5 = (ContaEmpresarial)conta3; // Se faz necessário o uso do typecasting (ContaEmpresarial).
			conta5.emprestimo(200);
			System.out.println("Empréstimo!");
		} else if (conta3 instanceof ContaPoupanca) {
			ContaPoupanca conta5 = (ContaPoupanca)conta3; // Se faz necessário o uso do typecasting (ContaPoupanca).
			conta5.atualizarSaldo();
			System.out.println("Atualização de Saldo!");
		}
		
		// OVERRIDE - Sobreposição de métodos entre subClasses e superClasses.
		//Conta conta6 = new Conta(1010, "Alex", 1000.0);
		//conta6.sacar(200);
		//System.out.println(conta6.getSaldo()); // Dará 795 pois o objeto 'conta6' é da superClasse Conta, então o método de saque tem 5 reais de taxa.
		
		Conta conta7 = new ContaPoupanca(1011, "Maria", 1000.0, 0.01);
		conta7.sacar(200);
		System.out.println(conta7.getSaldo()); // Dará 800 pois o objeto 'conta7' é da subClasse Poupança, então o método de saque não tem taxa.
		
		Conta conta8 = new ContaEmpresarial(1012, "Carlos", 1000.0, 500.0);
		conta8.sacar(200);
		System.out.println(conta8.getSaldo()); // Dará 793 pois o objeto 'conta7' é da subClasse Empresarial, então o método de saque tem 5 reais de taxa, mais 2 reais.
		
		// OBS!: O compilador não sabe para qual tipo específico a chamada do método 'sacar' está sendo feita (ele só sabe que são variáveis do tipo 'Conta').
		
		// === ABSTRAÇÃO ===
		List<Conta> lista = new ArrayList<>();
		
		lista.add(new ContaPoupanca(2000, "Gabriel", 500.0, 0.01));
		lista.add(new ContaEmpresarial(2001, "Bean", 1000.0, 400.0));
		lista.add(new ContaPoupanca(2002, "Monicke", 300.0, 0.01));
		lista.add(new ContaEmpresarial(2003, "Black", 500.0, 500.0));
		
		double soma = 0;
		for (Conta conta : lista) { 
			soma += conta.getSaldo();
		} // Somando todos os saldos de todas as contas existentes na lista (tanto Poupança quanto Empresarial).
		
		System.out.printf("Saldo total existente: %.2f%n", soma);
		
		for (Conta conta : lista) { 
			conta.depositar(10.0);
		} // Depositando 10 reais em todas as contas existentes na lista.
		
		for (Conta conta : lista) { 
			System.out.printf("Saldo atualizado da conta Nº%d: %.2f%n", conta.getNumero(), conta.getSaldo());
		} // Exibindo o saldo atualizado de todas as contas existentes na lista.
	}
}
