package exercicio02;
import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.println("Exerc�cio 1:");
		int a, b;
		
		System.out.print("Escreva o valor de A: ");
		a = leia.nextInt();
		System.out.print("Escreva o valor de B: ");
		b = leia.nextInt();
		System.out.println("Soma: " +(a+b));
				
		
		System.out.println();
		System.out.println("Exer�cio 2:");
		float a2, b2;
		
		System.out.print("Digite o 1� N�mero: ");
		a2 = leia.nextFloat();
		System.out.print("Digite o 2� N�mero: ");
		b2 = leia.nextFloat();
		
		System.out.println("Soma         : "+(a2+b2));
		System.out.println("Subtra��o    : "+(a2-b2));
		System.out.println("Multiplica��o: "+(a2*b2));
		System.out.println("Divis�o      : "+(a2/b2));
		
		
		System.out.println();
		System.out.println("Exerc�cio 3:");
		String nome	;
		int i;
		
		System.out.print("Escreva o nome: ");
		nome = leia.next();
		System.out.print("Escreva a idade: ");
		i = leia.nextInt();
		
		System.out.println("Nome: "+(nome));
		System.out.println("Idade: "+(i*365)+" dias.");
		
		
		System.out.println();
		System.out.println("Exerc�cio 4:");
		int a4, b4;
		
		System.out.print("Digite o 1� N�mero: ");
		a4 = leia.nextInt();
		System.out.print("Digite o 2� N�mero: ");
		b4 = leia.nextInt();
		System.out.println("Nota A: "+(a4)+", Nota B: "+(b4)+"");
		System.out.println("M�dia aritm�tica: "+(a4+b4)/2d); 
		/* Ou voc� pode explicitar o c�lculo usando uma vari�vel, por exemplo: 
		 * media = (x+y)/2; */
		
		
				
	
		leia.close();
	

	}

}
