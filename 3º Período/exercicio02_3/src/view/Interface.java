package view;

import java.util.Scanner;

import model.Aluno;

public class Interface {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Aluno aluno = new Aluno();
		
		System.out.print("Digite a nota do primeiro trimestre do aluno: ");
		aluno.nota1 = sc.nextDouble();
		System.out.print("Digite a nota do segundo trimestre do aluno: ");
		aluno.nota2 = sc.nextDouble();
		System.out.print("Digite a nota do terceiro trimestre do aluno: ");
		aluno.nota3 = sc.nextDouble();
		
		System.out.println("Nota final: " +aluno.notaFinal());
		if (aluno.notaFinal() >= 60) {
			System.out.println("APROVADO!");
		} else {
			System.out.println("REPROVADO!");
			System.out.println("Faltaram "+aluno.pontuacaoFaltante()+ " pontos.");
		}
		
		sc.close();
	}
}
