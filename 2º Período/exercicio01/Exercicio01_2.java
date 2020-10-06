package exercicio01;
import java.util.Scanner;

public class Exercicio01_2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		float lado[] = new float [3];
		
		for (int i = 0; i < 3; i++) {
			System.out.print("Entre a medida do "+(i+1)+"º lado: ");
			lado[i] = leia.nextFloat();
		}
		
		if ((lado[0] + lado[1]) > lado[2] && (lado[1] + lado[2]) > lado[0] && (lado[0] + lado[2]) > lado[1]) {
			if (lado[0] == lado[1] && lado[0] == lado[2]) {
				System.out.println("Tipo do Triângulo: Equilátero");
			} else if ((lado[0] == lado[1] && lado[0] != lado[2]) || (lado[0] == lado[2] && lado[0] != lado[1])) {
				System.out.println("Tipo do Triângulo: Isósceles");
			} else {
				System.out.println("Tipo do Triângulo: Escaleno");
			}
		} else {
			System.out.println("Não é um triângulo!");
		}		
		
		leia.close();
	}

}
