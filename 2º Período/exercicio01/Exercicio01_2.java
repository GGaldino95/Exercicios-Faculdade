package exercicio01;
import java.util.Scanner;

public class Exercicio01_2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		float lado[] = new float [3];
		
		for (int i = 0; i < 3; i++) {
			System.out.print("Entre a medida do "+(i+1)+"� lado: ");
			lado[i] = leia.nextFloat();
		}
		
		if ((lado[0] + lado[1]) > lado[2] && (lado[1] + lado[2]) > lado[0] && (lado[0] + lado[2]) > lado[1]) {
			if (lado[0] == lado[1] && lado[0] == lado[2]) {
				System.out.println("Tipo do Tri�ngulo: Equil�tero");
			} else if ((lado[0] == lado[1] && lado[0] != lado[2]) || (lado[0] == lado[2] && lado[0] != lado[1])) {
				System.out.println("Tipo do Tri�ngulo: Is�sceles");
			} else {
				System.out.println("Tipo do Tri�ngulo: Escaleno");
			}
		} else {
			System.out.println("N�o � um tri�ngulo!");
		}		
		
		leia.close();
	}

}
