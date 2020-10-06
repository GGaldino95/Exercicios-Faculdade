package exercicio01;
import java.util.Scanner;

public class Exercicio01_Switch {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int canal;
		
		System.out.print("Selecione o canal desejado: ");
		canal = leia.nextInt();
		
		/* 
		  if (canal == 1) {
			System.out.println("Você está assistindo o canal 1.");
		} else if  (canal == 5) {
			System.out.println("Você está assistindo o canal 5.");
		} else if  (canal == 7) {
			System.out.println("Você está assistindo o canal 7.");
		} else if  (canal == 9) {
			System.out.println("Você está assistindo o canal 9.");
		} else if  (canal == 12) {
			System.out.println("Você está assistindo o canal 12.");
		} else {
			System.out.println("Canal inválido!");
		}
		*/
			
		switch (canal) {
			case 1: System.out.println("Você está assistindo o canal 1.");
					break;
			case 5: System.out.println("Você está assistindo o canal 5.");
					break;
			case 7: System.out.println("Você está assistindo o canal 7.");
					break;
			case 9: System.out.println("Você está assistindo o canal 9.");
					break;
			case 12: System.out.println("Você está assistindo o canal 12.");
					break;
			default: System.out.println("Canal inválido!");
					break;
		}
		
		
		leia.close();
	}

}
