package exercicio02;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio02_2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		
		int qtdAtletas, atletasF = 0, atletasM = 0;
		float altura;
		float maiorAltura = Float.MIN_VALUE, menorAltura = Float.MAX_VALUE;
		float somaAltura = 0, alturaM = 0, mediaAlturaM = 0, mediaGeral = 0;
		char sexo;
		
		for (qtdAtletas = 0;; qtdAtletas++) {
			do {
				System.out.print("Digite a Altura do(a) Atleta Nº "+(qtdAtletas+1)+": ");
				altura = leia.nextFloat();
					if (altura < -1 || altura >= 2.5) {
						System.out.println("Altura inválida!");
					}
			} while(altura < -1 || altura >= 2.5);
			
			// FLAG
			if (altura == 0) {
				break;
			}
			
			do {
				System.out.print("Digite o Sexo do(a) Atleta Nº "+(qtdAtletas+1)+": ");
				sexo = leia.next().charAt(0);
					if (sexo != 'M' && sexo != 'F') {
						System.out.println("Digite apenas F ou M!");
					} else if (sexo == 'F') {
						atletasF++;
					} else {
						atletasM++;
						alturaM += altura;
					}
			} while(sexo != 'M' && sexo != 'F');
			
			// CÁLCULOS
			somaAltura += altura;
			if (altura > maiorAltura) {
				maiorAltura = altura;
			} else if (altura < menorAltura) {
				menorAltura = altura;
			}
		}
		
		mediaAlturaM = alturaM / atletasM;
		mediaGeral = somaAltura / qtdAtletas;

		System.out.println("");
		System.out.println("===============================================");
		System.out.println("Maior altura encontrada: "+maiorAltura);
		System.out.println("Menor altura encontrada: "+menorAltura);
		System.out.println("Número de atletas mulheres: "+atletasF);
		System.out.println("Média da altura masculina: "+df.format(mediaAlturaM));
		System.out.println("Média geral das alturas: "+df.format(mediaGeral));
		
		leia.close();
	}

}
