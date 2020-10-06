package exercicio03;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio03 {

	public static void main(String[] args) {
		Scanner leia     = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");

		int broas, paes;
		
		float vendaPaes, vendaBroas, valorArrecadado, poupan�a;
		
		System.out.print("Informe o n�mero de P�ES vendidos: ");
		paes = leia.nextInt();
		
		System.out.print("Informe o n�mero de BROAS vendidas: ");
		broas = leia.nextInt();
		
		vendaPaes = paes * (float)0.62; /* Voc� pode escrever tanto o '(variavel)' antes do   */
		vendaBroas = broas * 2.90f;		/* valor que precisa de typecasting quanto a letra da */
										/* variavel no final do valor.                        */
		
		valorArrecadado = vendaPaes + vendaBroas;
		
		poupan�a = valorArrecadado / 0.3f;
		
		System.out.println("=====================================");
		System.out.println("N�mero de P�es vendidos: "+paes);
		System.out.println("N�mero de Broas vendidas: "+broas);
		System.out.println("=====================================");
		System.out.println("Total de vendas de P�es: "+df.format(vendaPaes));
		System.out.println("Total de vendas de Broas: "+df.format(vendaBroas));
		System.out.println("Total Arrecadado: "+df.format(valorArrecadado));
		System.out.println("Valor para Poupan�a: "+df.format(poupan�a));
		System.out.println("====================================");
		
		
		leia.close();		
	}

}
