package exercicio02;
import java.util.*;

public class Exercicio02_3 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		int codOperario;
		char classe;
		int numPecas;
		float salario;
		float somaSalarios = 0;
		float somaNumPecas = 0;
		int menorNumPecas = 999;
		int codOpMenorNumPecas = 0;
		int somaNumPecasClasseB = 0;
		int contOperarioClasseB = 0;

		do {
			System.out.print("Digite o codigo do operario: ");
			codOperario = leia.nextInt();

			if (codOperario == 0) {
				break;
			}

			do {
				System.out.print("Digite a classe do operario: ");
				classe = leia.next().charAt(0);
				if (classe == 'A' && classe == 'B' && classe == 'C') {
					System.out.println("Classe invalida, digite A, B ou C");
				}
			} while (classe == 'A' && classe == 'B' && classe == 'C');

			do {
				System.out.print("Digite o numero de pecas: ");
				numPecas = leia.nextInt();
				if (numPecas <= 0) {
					System.out.println("Numero de pecas invalido, digite acima de zero");
				}
			} while (numPecas <= 0);
			
			if (classe == 'A') {
				if (numPecas <= 30) {
					salario = 500 + 2 * numPecas;
				} else if (numPecas <= 40) {
					salario = 500 + 2.3f * numPecas;
				} else {
					salario = 500 + 2.8f * numPecas;
				}
			} else if (classe == 'B') {
				salario = 1200;
			} else {
				if (numPecas <= 50) {
				salario = 40 * numPecas;
				} else {
					salario = 45 * numPecas;
				}
			}	
			
			somaSalarios += salario;
			somaNumPecas += numPecas;
			if (numPecas < menorNumPecas) {
				menorNumPecas = numPecas;
				codOpMenorNumPecas = codOperario;
			}
			if (classe == 'B') {
				somaNumPecasClasseB += numPecas;
				contOperarioClasseB++;
			}
			
			System.out.println("Salario: " +salario);
			
		} while (codOperario != 0);

		System.out.println("Soma dos salarios: " +somaSalarios);
		System.out.println("Total do numero de pecas fabricadas: " +somaNumPecas);
		System.out.println("Cod. operario que fabricou menor num pecas: " +codOpMenorNumPecas);
		if (contOperarioClasseB > 0) {
			System.out.println("Media num pecas classe B: " +somaNumPecasClasseB);
		}
		
		leia.close();
	}

}
