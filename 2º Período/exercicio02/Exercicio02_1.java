package exercicio02;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio02_1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");

		String nome[] = new String[10];
		float salario[] = new float[10],
			  novoSalario[] = new float[10];
		byte dependentes[] = new byte[10];
		byte empregadosSalarioAcima = 0;
		float somaSalarios = 0, mediaSalarios = 0;
		int i;
		
		for (i = 0; i < 10; i++) {
			System.out.print("Entre o nome do "+(i+1)+"� funcion�rio: ");
			nome[i] = leia.nextLine();
			System.out.print("Entre o sal�rio do "+(i+1)+"� funcion�rio: ");
			salario[i] = leia.nextFloat();
			System.out.print("Entre o N� de dependentes do "+(i+1)+"� funcion�rio: ");
			dependentes[i] = leia.nextByte();
			
			if (salario[i] <= 1000) {
				novoSalario[i] = salario[i] * 0.3f + salario[i];
			} else if (salario[i] <= 2000) {
				novoSalario[i] = salario[i] * 0.2f + salario[i];
			} else {
				novoSalario[i] = salario[i] * 0.1f + salario[i];
			}
			
			novoSalario[i] += dependentes[i] * 50;
			
			if (novoSalario[i] > 1700) {
				empregadosSalarioAcima++;
			}
			
			somaSalarios += novoSalario[i];
			
			//BUFFER
			leia.nextLine();
		}
		
		mediaSalarios = somaSalarios / i;
		
		//RELAT�RIO FINAL
		System.out.println("");
		System.out.println("========================================================");
		System.out.println("Somat�ria dos Sal�rios: " +df.format(somaSalarios));
		System.out.println("M�dia dos Sal�rios: " +df.format(mediaSalarios));
		System.out.println("N� de empregados recebendo mais que R$1700,00: " +empregadosSalarioAcima);
		
		
		leia.close();
	}

}
