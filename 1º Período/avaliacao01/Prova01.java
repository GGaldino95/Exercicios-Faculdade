package prova01;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Prova01 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");
		
		String nome;
		float peso, altura, larguraTorax, tamanho = 0, orçamento = 0;
		boolean val;
		
		System.out.println("===================");
		System.out.println("IMPLANTE DE SILICONE");
		System.out.println("===================");
		System.out.print("Escreva o NOME da paciente: ");
		nome = leia.nextLine();
		System.out.print("Escreva o PESO da paciente: ");
		peso = leia.nextFloat();
		System.out.print("Escreva a ALTURA (cm) da paciente: ");
		altura = leia.nextFloat();
		System.out.print("Escreva a LARGURA DO TORAX da paciente: ");
		larguraTorax = leia.nextFloat();
		System.out.println("");
		
		if (peso <= 50 && altura <= 150 && larguraTorax <= 65) {
			System.out.println("A quantidade ideal para a "+(nome)+" é 250mg.");
			tamanho = 250;
			val = true;
		} else if (peso <=60 && altura <= 150 && larguraTorax <= 65) {
			System.out.println("A quantidade ideal para a "+(nome)+" é 300mg.");
			tamanho = 300;
			val = true;
		} else if (peso > 60 && altura > 160 && larguraTorax <= 75) {
			System.out.println("A quantidade ideal para a "+(nome)+" é 360mg.");
			tamanho = 360;
			val = true;
		} else if (peso <= 70 && altura <= 170 && larguraTorax <= 75) {
			System.out.println("A quantidade ideal para a "+(nome)+" é 380mg.");
			tamanho = 380;
			val = true;
		} else if (peso > 70 && altura > 170 && larguraTorax > 75) {
			System.out.println("A quantidade ideal para a "+(nome)+"é 425mg.");
			tamanho = 425;
			val = true;
		} else {
			System.out.println("Não foi possivel calcular o mg estimado.");
			val = false;
		}
		
		if (tamanho <= 320 && val == true) {
			orçamento = 5500;
			System.out.println("Orçamento: "+df.format(orçamento));
		} else if (tamanho <= 365 && val == true) {
			orçamento = 7200;
			System.out.println("Orçamento: "+df.format(orçamento));
		} else if (tamanho > 400 && val == true) {
			orçamento = 8300;
			System.out.println("Orçamento: "+df.format(orçamento));	
		}
		
		leia.close();
	}
		

}
