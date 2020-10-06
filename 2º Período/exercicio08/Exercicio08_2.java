package exercicio08;
import java.util.Scanner;

public class Exercicio08_2 {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		float altura;
		float maiorAltura = 0;
		float menorAltura = 3;
		float somaAlturaMasc = 0;
		float somaGeralAlturas = 0;
		char sexo;
		byte contFem = 0;
		byte contMasc = 0;
		
		
		do {
			do {
			System.out.println("Entre a altura do atleta: ");
			altura = leia.nextFloat();
				if (altura < 0 || altura > 2.5) {
					System.out.println("Erro! A altura deve ser maior que 1 ou menor que 2,5");
				}
			} while(altura < 0 || altura > 2.5); 
				
			//	flag
				if (altura == 0) {
					break;
				}
				
			do {
				System.out.println("entre o sexo do atleta: ");
				sexo = leia.next().charAt(0);
					if (sexo != 'F' && sexo != 'M') {
						System.out.println("Erro, insira apenas F ou M");
					}
			} while(sexo != 'F' && sexo != 'M');
			
			if (altura > maiorAltura) {
				maiorAltura = altura;
			}
		
			if (altura < menorAltura) {
				menorAltura = altura;
			}
			
			if (sexo == 'M') {
				contMasc++;
				somaAlturaMasc += altura;
			} else {
				contFem++;
			}
			
			somaGeralAlturas += altura;
			
		} while(altura != 99);
			
		System.out.println("Maior altura: " +maiorAltura);
		System.out.println("Menor altura: " +menorAltura);
		System.out.println("Quantidade de atletas femininas: " +contFem);
		if (contMasc > 0) {
		System.out.println("Media de altura masculina: " +somaAlturaMasc / contMasc);
		}
		System.out.println("Media geral: " +somaGeralAlturas / (contMasc + contFem));
		
		leia.close();
		
		
		
	}

}
