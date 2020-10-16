package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try { // Vai verificar se ocorrer� alguma exce��o no c�digo.
			String[] vetor = sc.nextLine().split(" ");
			int posicao = sc.nextInt();
			System.out.println(vetor[posicao]);
		} catch (ArrayIndexOutOfBoundsException e) { // Caso a exce��o no par�metro aconte�a:
			System.out.println("Posi��o inv�lida!");
		} catch (InputMismatchException e) { // Caso a exce��o no par�metro aconte�a:
			System.out.println("Erro de entrada!");
		}
		
		System.out.println("Fim do Programa.");
		sc.close();
	}

}
