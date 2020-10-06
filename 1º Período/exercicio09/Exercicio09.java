package exercicio09;
import java.util.Scanner;

public class Exercicio09 {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		int notas, frequencia[] = new int[11];
		int soma = 0;
		int i;
		// A VARIAVEL 'i' É REFERENTE AO NUMERO DE ALUNOS (CONTADOR DO FOR)
		for (i = 0; i < 15; i++) {
			do {
				System.out.print("Informe a NOTA (-1 para sair): ");
				notas = leia.nextInt();
				if (notas < -1 || notas > 10) {
					System.out.println("Apenas notas entre 1 e 10.");
				}
			} while (notas < -1 || notas > 10);

			if (notas == -1) {
				break;
			}

			soma += notas;
			frequencia[notas]++;
		}

		System.out.println("RELATÓRIO DE ALUNOS POR NOTA");
		System.out.println("     NOTA       FREQUÊNCIA");
		for (int j = 0; j < frequencia.length; j++) {
			System.out.println("     " + j + "         " + frequencia[j]);
		}
		System.out.println("============================");
		System.out.println("Média: " + ((float) soma / i));

		leia.close();
	}
}
