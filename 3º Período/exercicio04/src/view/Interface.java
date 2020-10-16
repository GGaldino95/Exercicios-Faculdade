package view;

import java.util.Scanner;

import model.Cliente;

public class Interface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Cliente cliente;
		
		System.out.print("Digite o número da conta: ");
		int conta = sc.nextInt();
		System.out.print("Digite o nome do proprietário da conta: ");
		sc.nextLine();
		String nome = sc.nextLine();
		
		System.out.println("");
		System.out.print("Há um depósito inicial (s/n)? ");
		char op = sc.next().charAt(0);
		op = Character.toUpperCase(op);
		
		double saldo;
		if (op == 'S') {
			System.out.print("Entre o valor de depósito inicial: R$");
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
		System.out.print("Entre com um valor de depósito: R$");
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
