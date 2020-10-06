package exercicio04;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio04_4 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");

		int codigo, quantidade;
		float total, desconto;

	do {
		System.out.println("=================================");
		System.out.print  ("Digite o código do produto: ");
		codigo = leia.nextInt();
		
			
		if (codigo <= 10) {
			System.out.println("Preço: R$10,00");
		} else if (codigo <= 20) {
			System.out.println("Preço: R$15,00");
		} else if (codigo <= 30) {
			System.out.println("Preço: R$20,00");
		} else if (codigo <= 40) {
			System.out.println("Preço: R$30,00");
		} else {
			System.out.println("Código Inválido!");
		}
		
	   }  while (codigo > 40);
	
	
		System.out.print("Digite a quantidade comprada: ");
		quantidade = leia.nextInt();
		System.out.println("=================================");
		
		if (codigo <= 10) {
			System.out.println("Valor inicial: " +df.format(total = quantidade * 10));						
		} else if (codigo <= 20) {
			System.out.println("Valor inicial: " +df.format(total = quantidade * 15));
		} else if (codigo <= 30) {
			System.out.println("Valor inicial: " +df.format(total = quantidade * 20));	
		} else {
			System.out.println("Valor inicial: " +df.format(total = quantidade * 30));
		}
		
		if (total <= 250) {
			System.out.println("Desconto de 5%!");
			desconto = total * 0.05f;
			System.out.println("Total a pagar: " +df.format(total - desconto));
		} else if (total <= 500) {
			System.out.println("Desconto de 10%!");
			desconto = total * 0.1f;
			System.out.println("Total a pagar: " +df.format(total - desconto));
		} else {
			System.out.println("Desconto de 15%!");
			desconto = total * 0.15f;
			System.out.println("Total a pagar: " +df.format(total - desconto));
		}
		
		
		 
		
		leia.close();
	}

}
