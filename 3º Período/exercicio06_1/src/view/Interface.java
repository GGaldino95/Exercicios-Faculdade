package view;

import java.util.Scanner;

public class Interface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o tamanho da matriz desejada: ");
		int n = sc.nextInt();
		
		int[][] matriz = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("");
			for (int j = 0; j < n; j++) {
				System.out.print("Preencha a coluna "+i+", linha "+j+": ");
				matriz[i][j] = sc.nextInt();
			}
		}
		
		System.out.println();
		System.out.print("Valores localizados na diagonal da matriz: ");
		for (int k = 0; k < n; k++) 
			System.out.print(matriz[k][k] + " ");
		
		System.out.println();
		System.out.print("Quantidade de valores negativos existentes na matriz: ");
		int contador = 0;
		for (int l = 0; l < matriz.length; l++) {
			for (int m = 0; m < matriz[l].length; m++) {
				if (matriz[l][m] < 0)
					contador++;		
			}
		}
		System.out.println(contador);
		
		sc.close();
	}

}
