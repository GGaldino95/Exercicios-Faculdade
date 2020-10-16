package view;

import java.util.Scanner;

import model.Cliente;

public class Interface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Cliente cliente;
		
		System.out.print("Digite o n�mero da conta: ");
		int conta = sc.nextInt();
		System.out.print("Digite o nome do propriet�rio da conta: ");
		sc.nextLine();
		String nome = sc.nextLine();
		
		System.out.println("");
		System.out.print("H� um dep�sito inicial (s/n)? ");
		char op = sc.next().charAt(0);
		op = Character.toUpperCase(op);
		
		double saldo;
		if (op == 'S') {
			System.out.print("Entre o valor de dep�sito inicial: R$");
			saldo = sc.nextDouble();
			cliente = new Cliente(conta, nome, saldo);
			cliente.depositar(saldo);
		} else {
			cliente = new Cliente(conta, nome);
		}
		
		System.out.println("");
		System.out.println("Dados da conta:");
		System.out.println(cliente);
		
		System.out.println("");
		System.out.print("Entre com um valor de dep�sito: R$");
		saldo = sc.nextDouble();
		cliente.depositar(saldo);
		
		System.out.println("");
		System.out.println("Dados atualizados da conta:");
		System.out.println(cliente);
		
		System.out.println("");
		System.out.print("Entre com um valor de saque: R$");
		saldo = sc.nextDouble();
		cliente.sacar(saldo);
		
		System.out.println("");
		System.out.println("Dados atualizados da conta:");
		System.out.println(cliente);
		sc.close();
	}

}
