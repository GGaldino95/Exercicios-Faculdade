package exercicio01;
import java.util.Scanner;

public class Exercicio01_1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		float notaA, notaB, notaC;

		System.out.print("Escreva a Nota da Prova A: ");
		notaA = leia.nextFloat();
		
		if (notaA  > 59) {
			System.out.println("Aprovado!");
		} else if (notaA  < 25) {
			System.out.println("Reprovado!");
		} else {
			System.out.println("Prova Especial!");
		}

		System.out.print("Escreva a Nota da Prova B: ");
		notaB = leia.nextFloat();
		
		if (notaB  > 59) {
			System.out.println("Aprovado!");
		} else if (notaB  < 25) {
			System.out.println("Reprovado!");
		} else {
			System.out.println("Prova Especial!");
		}
		
		System.out.print("Escreva a Nota da Prova C: ");
		notaC = leia.nextFloat();

		if (notaC  > 59) {
			System.out.println("Aprovado!");
		} else if (notaC  < 25) {
			System.out.println("Reprovado!");
		} else {
			System.out.println("Prova Especial!");
		}
		
		
		
		leia.close();
	}
}
