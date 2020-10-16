package view;

import java.util.Scanner;

public class Interface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite a quantidade de linhas M e colunas N da matriz desejada: ");
		int m = sc.nextInt();
		int n = sc.nextInt();

		int matriz[][] = new int[m][n];

		for (int i = 0; i < matriz.length; i++) {
			System.out.println("Preencha a linha " + (i + 1) + " da matriz: ");
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}

		System.out.print("Digite o número a ser pesquisado na matriz: ");
		int x = sc.nextInt();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == x) {
					System.out.println("Posição: " + i + ", " + j);
					if (j > 0) {
						System.out.println("Esquerda: " + matriz[i][j-1]);
					}
					if (j <  matriz[i].length-1) {
						System.out.println("Direita: " + matriz[i][j+1]);
					}
					if (i < matriz.length-1) {
						System.out.println("Abaixo: " + matriz [i+1][j]);
					}
					if (i > 0) {
						System.out.println("Acima: " + matriz [i-1][j]);
					}
				}
			}
		}
		
		sc.close();
	}
}
