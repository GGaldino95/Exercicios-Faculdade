package exercicio05;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio05 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat ("R$#,###.00");
		
		System.out.println("|===================================|");
		System.out.println("|========== CARANGO VELHO ==========|");
		System.out.println("|==========   Bem vindo!  ==========|");
		System.out.println("|===================================|");
		System.out.println("");
		
		int idadeComprador, anoCarro;
		float valorCarro, valorCarro1, valorCarro2, desconto1  = 0, desconto2 = 0; 
		
		do {
		System.out.print("Por favor, informe o ANO do carro: ");
		anoCarro = leia.nextInt();
			if (anoCarro <= 1989) {
				System.out.println("ERRO! Carro muito Antigo!");
				System.out.println("|===================================|");
			} else if (anoCarro >= 2015) {
				System.out.println("ERRO! Carro muito Novo!");
				System.out.println("|===================================|");
			}
		} while (anoCarro <= 1989 || anoCarro >= 2014);
		
		System.out.print("Por favor, informe o VALOR ATUAL do carro: R$");
		valorCarro = leia.nextFloat();
		System.out.print("Por favor, informe a IDADE do Comprador: ");
		idadeComprador = leia.nextInt();
		
		if (anoCarro <= 2000) {
			desconto1 = valorCarro * 0.12f;
		} else if (anoCarro <= 2010) {
			desconto1 = valorCarro * 0.07f;
		} else if (anoCarro <= 2014) {
			desconto1 = valorCarro * 0.03f;
		}
		
		valorCarro1 = valorCarro - desconto1;
		
		if (idadeComprador <= 40) {
			desconto2 = valorCarro1 * 0.005f;
		} else if (idadeComprador <= 60) {
			desconto2 = valorCarro1 * 0.01f;
		} else {
			desconto2 = valorCarro1 * 0.02f;
		}
		
		valorCarro2 = valorCarro1 - desconto2;
		
		System.out.println("");
		System.out.println("|===================================|");
		System.out.println("O Valor atual do veículo é de:           "+df.format(valorCarro));
		System.out.println("O Desconto pelo ano do veículo é de:     "+df.format(desconto1));
		System.out.println("O Desconto pela idade do comprador é de: "+df.format(desconto2));
		System.out.println("O Valor final do veículo é de:           "+df.format(valorCarro2));
			
		leia.close();
	}

}
