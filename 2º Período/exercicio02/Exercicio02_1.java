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
			System.out.print("Entre o nome do "+(i+1)+"º funcionário: ");
			nome[i] = leia.nextLine();
			System.out.print("Entre o salário do "+(i+1)+"º funcionário: ");
			salario[i] = leia.nextFloat();
			System.out.print("Entre o Nº de dependentes do "+(i+1)+"º funcionário: ");
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
		
		//RELATÓRIO FINAL
		System.out.println("");
		System.out.println("========================================================");
		System.out.println("Somatória dos Salários: " +df.format(somaSalarios));
		System.out.println("Média dos Salários: " +df.format(mediaSalarios));
		System.out.println("Nº de empregados recebendo mais que R$1700,00: " +empregadosSalarioAcima);
		
		
		leia.close();
	}

}
