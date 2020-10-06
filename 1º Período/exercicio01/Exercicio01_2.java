package exercicio01;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio01_2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");
		
		float precoAntigo, precoNovo;
		
		System.out.print("Escreva o preço antigo: ");
		precoAntigo = leia.nextFloat();
		
		if (precoAntigo < 50) {
			precoNovo = precoAntigo * 1.05f;
		} else if (precoAntigo >= 50 && precoAntigo <= 100) {
			precoNovo = precoAntigo * 1.10f;	
		} else {
			precoNovo = precoAntigo * 1.15f;
		}
		System.out.println("Preço Novo: "+df.format(precoNovo));
		
		if (precoNovo < 80) {
			System.out.println("Barato.");
		} else if (precoNovo <= 120) {
			System.out.println("Normal.");
		} else if (precoNovo >=120 && precoNovo <= 200) {
			System.out.println("Caro.");
		} else {
			System.out.println("Muito caro.");
		}
		
		leia.close();
	}

}
