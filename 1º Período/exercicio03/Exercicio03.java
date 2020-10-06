package exercicio03;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio03 {

	public static void main(String[] args) {
		Scanner leia     = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");

		int broas, paes;
		
		float vendaPaes, vendaBroas, valorArrecadado, poupança;
		
		System.out.print("Informe o número de PÃES vendidos: ");
		paes = leia.nextInt();
		
		System.out.print("Informe o número de BROAS vendidas: ");
		broas = leia.nextInt();
		
		vendaPaes = paes * (float)0.62; /* Você pode escrever tanto o '(variavel)' antes do   */
		vendaBroas = broas * 2.90f;		/* valor que precisa de typecasting quanto a letra da */
										/* variavel no final do valor.                        */
		
		valorArrecadado = vendaPaes + vendaBroas;
		
		poupança = valorArrecadado / 0.3f;
		
		System.out.println("=====================================");
		System.out.println("Número de Pães vendidos: "+paes);
		System.out.println("Número de Broas vendidas: "+broas);
		System.out.println("=====================================");
		System.out.println("Total de vendas de Pães: "+df.format(vendaPaes));
		System.out.println("Total de vendas de Broas: "+df.format(vendaBroas));
		System.out.println("Total Arrecadado: "+df.format(valorArrecadado));
		System.out.println("Valor para Poupança: "+df.format(poupança));
		System.out.println("====================================");
		
		
		leia.close();		
	}

}
