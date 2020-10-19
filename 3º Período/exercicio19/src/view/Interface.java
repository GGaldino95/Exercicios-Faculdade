package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.SaqueException;

public class Interface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Informe os dados da conta:");
			System.out.print("Número: ");
			int numConta = sc.nextInt();
			System.out.print("Titular: ");
			sc.nextLine();
			String titular = sc.nextLine();
			System.out.print("Saldo inicial: R$");
			double saldoInicial = sc.nextDouble();
			System.out.print("Limite de saque: R$");
			double limite = sc.nextDouble();

			Conta conta = new Conta(numConta, titular, saldoInicial, limite);

			System.out.println();
			System.out.print("Informe a quantia para saque: R$");
			conta.sacar(sc.nextDouble());

			System.out.println();
			System.out.println("Saldo atualizado: R$" + String.format("%.2f", conta.getSaldo()));
		} catch (InputMismatchException e) {
			System.out.println("Erro: Valor inserido inválido.");
		} catch (SaqueException e) {
			System.out.println("Erro de operação: " + e.getMessage());
		}
		
		sc.close();
	}

}
