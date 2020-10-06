package exercicio07;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio07 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat percdf = new DecimalFormat("0.00'%'");

		int qtdAlunos = 0, alunosAbaixo = 0, alunosObesos = 0;
		float IMC, peso, altura, somaIMC = 0, percentual = 0, mediaIMC, maiorIMC = Float.MIN_VALUE;
		String nome, situacao, nomeMaiorIMC = "";

		System.out.println("|===========================================|");
		System.out.println("|========== ACADEMIA EMAGREÇA BEM ==========|");
		System.out.println("|==============   Bem vindo!  ==============|");
		System.out.println("|===========================================|");
		System.out.println("(Pressione 0 para sair)");
		System.out.println("");

		for (qtdAlunos = 0;; qtdAlunos++) {

			do {
				System.out.println("Informe a ALTURA: ");
				altura = leia.nextFloat();
				if (altura < 0 || altura >= 3) {
					System.out.println("Informe alturas positivas e abaixo de 3 metros!");
				}
			} while (altura < 0 || altura >= 3);

			// FLAG
			if (altura == 0) {
				break;
			}

			// ENTRADA DE DADOS
			do {
				System.out.println("Informe o PESO: ");
				peso = leia.nextFloat();
				if (peso < 0) {
					System.out.println("O peso deve ser positivo.");
				}
			} while (peso < 0);

			// LIMPEZA DO BUFFER
			leia.nextLine();

			System.out.println("Informe o NOME: ");
			nome = leia.nextLine();

			// CÁLCULO IMC
			IMC = peso / (altura * altura);

			if (IMC <= 18.4) {
				situacao = "Abaixo do peso";
				alunosAbaixo++;
			} else if (IMC <= 24.9) {
				situacao = "Peso normal";
			} else if (IMC <= 29.9) {
				situacao = "Sobrepeso";
			} else {
				situacao = "Obesidade";
				alunosObesos++;
			}

			// RELATÓRIO INTERMEDIÁRIO
			System.out.println("=================================");
			System.out.println("Nome do Aluno: " + nome);
			System.out.println("IMC do Aluno: " + IMC);
			System.out.println("Situação: " + situacao);
			System.out.println("=================================");

			// CÁLCULOS
			somaIMC += IMC;
			if (IMC > maiorIMC) {
				maiorIMC = IMC;
				nomeMaiorIMC = nome;
			}

		}

		mediaIMC = somaIMC / qtdAlunos;
		percentual = alunosObesos / (float) qtdAlunos * 100;

		// RELATÓRIO FINAL
		System.out.println("=================================");
		System.out.println("          RELATÓRIO FINAL        ");

		if (qtdAlunos > 0) {
			System.out.println("Média de IMC: " + mediaIMC);
			System.out.println(alunosAbaixo + " Aluno(s) Abaixo do peso.");
			System.out.println(percdf.format(percentual) + " do(s) aluno(s) estão obesos.");
			System.out.println("O Aluno(a) " + nomeMaiorIMC.toUpperCase() + " está com o maior IMC de " + maiorIMC);
		} else {
			System.out.println("Sem entrada de dados!");
		}

		leia.close();
	}

}
