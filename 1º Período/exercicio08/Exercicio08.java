package exercicio08;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio08 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");

		int codf, qtdf, horaExtra, horaFaltante, funcH = 0;
		float gratificacao = 0, somaGratificacao = 0, H, maiorH = Float.MIN_VALUE;

		// LOOP
		for (qtdf = 0; qtdf < 100; qtdf++) {

			// ENTRADA DE DADOS
			System.out.println("Digite o c�digo do Funcion�rio: ");
			codf = leia.nextInt();

			// FLAG
			if (codf == 0) {
				break;
			}

			// ENTRADA DE DADOS COM CONSIST�NCIA
			do {
				System.out.println("Digite o n�mero de horas extras trabalhadas: ");
				horaExtra = leia.nextInt();

				if (horaExtra < 0) {
					System.out.println("Entre apenas horas positivas.");
				}
			} while (horaExtra < 0);

			do {
				System.out.println("Digite o n�mero de horas faltantes: ");
				horaFaltante = leia.nextInt();

				if (horaFaltante < 0) {
					System.out.println("Entre apenas horas positivas.");
				}
			} while (horaFaltante < 0);

			// C�LCULOS
			H = horaExtra - 2 / 3f * horaFaltante;

			// CONSIST�NCIA DE DADOS
			if (H < 600) {
				gratificacao = 100;
			} else if (H <= 1200) {
				gratificacao = 200;
			} else if (H <= 1800) {
				gratificacao = 300;
			} else if (H <= 2400) {
				gratificacao = 400;
			} else {
				gratificacao = 500;
			}

			// C�LCULOS
			somaGratificacao += gratificacao;
			if (H > maiorH) {
				maiorH = H;
			}
			if (H >= 1500) {
			funcH++;
			}
			
			// RELAT�RIO INTERMEDI�RIO
			System.out.println("============================");
			System.out.println("C�digo do Funcion�rio: " + codf);
			System.out.println("Fator H: " + H);
			System.out.println("Gratifica��o: " + df.format(gratificacao));
			System.out.println("============================");
			System.out.println("");

		}


		// RELAT�RIO FINAL
		System.out.println("=================================");
		System.out.println("          RELAT�RIO FINAL        ");
		System.out.println("M�dia de gratifica��es: " + (somaGratificacao / qtdf));
		System.out.println("Qtd de Funcion�rios com Fator H maior que 1500: " +funcH);
		System.out.println("Funcion�rio com maior Fator H: " +maiorH);

		leia.close();
	}

}
