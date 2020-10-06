package exercicio04;
import java.text.DecimalFormat;
import java.util.*;
public class Exercicio04_2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		String nome[] = new String[100];
		int codigo[] = new int[100];
		float salario[] = new float[100];
		int numPecas;
		byte cont;
		float mediaSalario = 0, totalSalarios = 0;
		
		System.out.println("(FIM para sair)");
		
		for (cont = 0; cont < 100; cont++) {
			do {
				System.out.print("Digite o nome do "+(cont+1)+"º funcionario: ");
				nome[cont] = leia.nextLine();
				
				if (nome[cont].equalsIgnoreCase("")) {
					System.out.println("ERRO! O nome e obrigatorio!");
					System.out.println("");
				}	
			} while(nome[cont].equalsIgnoreCase(""));
			
			if (nome[cont].equalsIgnoreCase("FIM")) {
				break;
			}
			
			do {
				System.out.print("Digite o codigo do funcionario: ");
				codigo[cont] = leia.nextInt();
				
				if (codigo[cont] < 1 || codigo[cont] > 999) {
					System.out.println("ERRO! O codigo deve ser entre 1 e 999!");
					System.out.println("");
				}
			} while(codigo[cont] < 1 || codigo[cont] > 999);
			
			do {
				System.out.print("Digite a quantidade de pecas fabricadas: ");
				numPecas = leia.nextInt();
				
				if (numPecas <= 0) {
					System.out.println("ERRO! A quantidade deve ser maior que zero!");
					System.out.println("");
				}
			} while(numPecas <= 0);
			
			//calculo do salario
			salario[cont] = calcularSalario(numPecas);
			totalSalarios += salario[cont];
			
			leia.nextLine();
		}
		
		mediaSalario = totalSalarios / cont;
		
		// relatorio final
		System.out.println("");
		System.out.println("Nome                 Salario    Média Salários");
		System.out.println("================     ========   ==============");
		for (int i = 0; i < cont; i++) {
		System.out.println(nome[i]+"\t\t      "+df.format(salario[i])+"       "+df.format(mediaSalario));	
		}
		System.out.println("");
		System.out.println("Total pago com salarios: "+df.format(totalSalarios));
		
		leia.close();
	}

	public static float calcularSalario (int pecas) {
		float salario = 0;
		
		if (pecas <= 200) {
			salario = pecas * 2;
		} else if (pecas <= 400) {
			salario = pecas * 2.3f;
		} else { 
			salario = pecas * 2.5f;
		}
		
		return salario;
	}
}
