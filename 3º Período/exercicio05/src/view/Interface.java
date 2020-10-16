package view;

import java.util.Scanner;

import model.Aluguel;

public class Interface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Aluguel quartos[] = new Aluguel[10];

		System.out.print("Quantos quartos serão alugados? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("");
			System.out.println("Aluguel #" + i);

			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();

			System.out.print("Email: ");
			String email = sc.nextLine();

			System.out.print("Quarto: ");
			int quarto = sc.nextInt();

			quartos[quarto] = new Aluguel(nome, email);
		}

		System.out.println("");
		System.out.println("Quartos ocupados: ");
		for (int i = 0; i < 10; i++) {
			if (quartos[i] != null) {
				System.out.println(i + ": " + quartos[i]);
			}
		}

		sc.close();
	}

}
