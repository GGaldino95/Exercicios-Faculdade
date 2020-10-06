package exercicio02;
import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.println("Exercício 1:");
		int a, b;
		
		System.out.print("Escreva o valor de A: ");
		a = leia.nextInt();
		System.out.print("Escreva o valor de B: ");
		b = leia.nextInt();
		System.out.println("Soma: " +(a+b));
				
		
		System.out.println();
		System.out.println("Exerício 2:");
		float a2, b2;
		
		System.out.print("Digite o 1º Número: ");
		a2 = leia.nextFloat();
		System.out.print("Digite o 2º Número: ");
		b2 = leia.nextFloat();
		
		System.out.println("Soma         : "+(a2+b2));
		System.out.println("Subtração    : "+(a2-b2));
		System.out.println("Multiplicação: "+(a2*b2));
		System.out.println("Divisão      : "+(a2/b2));
		
		
		System.out.println();
		System.out.println("Exercício 3:");
		String nome	;
		int i;
		
		System.out.print("Escreva o nome: ");
		nome = leia.next();
		System.out.print("Escreva a idade: ");
		i = leia.nextInt();
		
		System.out.println("Nome: "+(nome));
		System.out.println("Idade: "+(i*365)+" dias.");
		
		
		System.out.println();
		System.out.println("Exercício 4:");
		int a4, b4;
		
		System.out.print("Digite o 1º Número: ");
		a4 = leia.nextInt();
		System.out.print("Digite o 2º Número: ");
		b4 = leia.nextInt();
		System.out.println("Nota A: "+(a4)+", Nota B: "+(b4)+"");
		System.out.println("Média aritmética: "+(a4+b4)/2d); 
		/* Ou você pode explicitar o cálculo usando uma variável, por exemplo: 
		 * media = (x+y)/2; */
		
		
				
	
		leia.close();
	

	}

}
