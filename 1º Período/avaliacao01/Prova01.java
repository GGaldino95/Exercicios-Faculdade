package prova01;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Prova01 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");
		
		String nome;
		float peso, altura, larguraTorax, tamanho = 0, or�amento = 0;
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
			System.out.println("A quantidade ideal para a "+(nome)+" � 250mg.");
			tamanho = 250;
			val = true;
		} else if (peso <=60 && altura <= 150 && larguraTorax <= 65) {
			System.out.println("A quantidade ideal para a "+(nome)+" � 300mg.");
			tamanho = 300;
			val = true;
		} else if (peso > 60 && altura > 160 && larguraTorax <= 75) {
			System.out.println("A quantidade ideal para a "+(nome)+" � 360mg.");
			tamanho = 360;
			val = true;
		} else if (peso <= 70 && altura <= 170 && larguraTorax <= 75) {
			System.out.println("A quantidade ideal para a "+(nome)+" � 380mg.");
			tamanho = 380;
			val = true;
		} else if (peso > 70 && altura > 170 && larguraTorax > 75) {
			System.out.println("A quantidade ideal para a "+(nome)+"� 425mg.");
			tamanho = 425;
			val = true;
		} else {
			System.out.println("N�o foi possivel calcular o mg estimado.");
			val = false;
		}
		
		if (tamanho <= 320 && val == true) {
			or�amento = 5500;
			System.out.println("Or�amento: "+df.format(or�amento));
		} else if (tamanho <= 365 && val == true) {
			or�amento = 7200;
			System.out.println("Or�amento: "+df.format(or�amento));
		} else if (tamanho > 400 && val == true) {
			or�amento = 8300;
			System.out.println("Or�amento: "+df.format(or�amento));	
		}
		
		leia.close();
	}
		

}
