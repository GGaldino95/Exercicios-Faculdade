package exercicio10;

import java.util.Scanner;

public class Exercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);

		float notas = 0, somanotaAluno = 0, mediaAluno, mediaTurma = 0, contNotas;
		int contAlunos, j;
		float MediaAlunos[] = new float[30];

		for (contAlunos = 0; contAlunos < 3; contAlunos++) {
			for (contNotas = 0; contNotas < 5; contNotas++) {

				System.out.println("Insira a " + (contNotas + 1) + " do " + (contAlunos + 1) + "  Aluno :");
				notas = leia.nextFloat();
				somanotaAluno += notas;
			}

			mediaAluno = somanotaAluno / 5;
			MediaAlunos[contAlunos] += mediaAluno;
			mediaTurma += MediaAlunos[contAlunos];
			somanotaAluno = 0;
		}
		System.out.println("          ======== RELATORIO FINAL ===========        ");
		System.out.println("= Nº DO ALUNO ==== MÉDIA DO ALUNO ==== MÉDIA DA TURMA =");

		for (j = 0; j < 30; j++) {
			System.out.println(
					"        " + (j + 1) + "             " + MediaAlunos[j] + "  "
							+ "   " + mediaTurma / 3);
		}

		
		leia.close();
	}
}
