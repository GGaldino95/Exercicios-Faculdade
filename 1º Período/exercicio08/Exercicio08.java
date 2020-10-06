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
			System.out.println("Digite o código do Funcionário: ");
			codf = leia.nextInt();

			// FLAG
			if (codf == 0) {
				break;
			}

			// ENTRADA DE DADOS COM CONSISTÊNCIA
			do {
				System.out.println("Digite o número de horas extras trabalhadas: ");
				horaExtra = leia.nextInt();

				if (horaExtra < 0) {
					System.out.println("Entre apenas horas positivas.");
				}
			} while (horaExtra < 0);

			do {
				System.out.println("Digite o número de horas faltantes: ");
				horaFaltante = leia.nextInt();

				if (horaFaltante < 0) {
					System.out.println("Entre apenas horas positivas.");
				}
			} while (horaFaltante < 0);

			// CÁLCULOS
			H = horaExtra - 2 / 3f * horaFaltante;

			// CONSISTÊNCIA DE DADOS
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

			// CÁLCULOS
			somaGratificacao += gratificacao;
			if (H > maiorH) {
				maiorH = H;
			}
			if (H >= 1500) {
			funcH++;
			}
			
			// RELATÓRIO INTERMEDIÁRIO
			System.out.println("============================");
			System.out.println("Código do Funcionário: " + codf);
			System.out.println("Fator H: " + H);
			System.out.println("Gratificação: " + df.format(gratificacao));
			System.out.println("============================");
			System.out.println("");

		}


		// RELATÓRIO FINAL
		System.out.println("=================================");
		System.out.println("          RELATÓRIO FINAL        ");
		System.out.println("Média de gratificações: " + (somaGratificacao / qtdf));
		System.out.println("Qtd de Funcionários com Fator H maior que 1500: " +funcH);
		System.out.println("Funcionário com maior Fator H: " +maiorH);

		leia.close();
	}

}
