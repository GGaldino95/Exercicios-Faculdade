package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try { // Vai verificar se ocorrerá alguma exceção no código.
			String[] vetor = sc.nextLine().split(" ");
			int posicao = sc.nextInt();
			System.out.println(vetor[posicao]);
		} catch (ArrayIndexOutOfBoundsException e) { // Caso a exceção no parâmetro aconteça:
			System.out.println("Posição inválida!");
		} catch (InputMismatchException e) { // Caso a exceção no parâmetro aconteça:
			System.out.println("Erro de entrada!");
		}
		
		System.out.println("Fim do Programa.");
		sc.close();
	}

}
