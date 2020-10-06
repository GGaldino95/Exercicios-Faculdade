package prova02;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Prova02 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		DecimalFormat perc = new DecimalFormat("00'%'");
		
		int contFuncionario, i, salarioAbaixo = 0;
		
		String nome[] = new String [100];
		float salario[] = new float [100];
		float salarioFinal[] = new float [100];
		float FGTS = 0, INSS = 0, CSA = 0, fundoFGTS = 0, media = 0;
		
		System.out.println("==================== PEC Funcionários ====================");
		System.out.println("");
		
		for (contFuncionario = 0; contFuncionario < 100; contFuncionario++) {
			System.out.print("Informe NOME do "+(contFuncionario + 1)+"º Funcionário: ");
			nome[contFuncionario] = leia.nextLine().toUpperCase();
			
			// FLAG
			if (nome[contFuncionario].equals("FIM")) {
				break;
			}
			
			do {
				System.out.print("Informe SALÁRIO do "+(contFuncionario + 1)+"º Funcionário: ");
				salario[contFuncionario] = leia.nextFloat();
				
				if (salario[contFuncionario] <= 0) {
					System.err.println("Não é possivel informar salario MENOR ou IGUAL a zero.");
				}
				
			} while (salario[contFuncionario] <= 0);
			
			// CÁLCULOS
			FGTS = salario[contFuncionario] * (float)0.08;
			INSS = salario[contFuncionario] * (float)0.08;
			CSA = salario[contFuncionario] * (float)0.032;
			fundoFGTS = salario[contFuncionario] * (float)0.008;
			salarioFinal[contFuncionario] = salario[contFuncionario] + (INSS + FGTS + CSA + fundoFGTS);
			media += salarioFinal[contFuncionario];
			
			if (salarioFinal[contFuncionario] < 1908.93) {
				salarioAbaixo++;
			}
			
			System.out.println("=================================================================");
			System.out.println("O boleto gerado será no valor de "+df.format(salarioFinal[contFuncionario]));
			System.out.println("=================================================================");
			
			// LIMPEZA DO BUFFER
			leia.nextLine();
		}
		
		System.out.println("RELATÓRIO FINAL =================================================");
		System.out.println("=================================================================");
		for (i = 0; i < contFuncionario; i++) {
			System.out.println("  Nome \t \t \t : "+nome[i]);
			System.out.println("  Salário \t \t : "+df.format(salario[i]));
			System.out.println("+");
			System.out.println("  INSS \t \t \t : "+df.format(INSS));
			System.out.println("  FGTS \t \t \t : "+df.format(FGTS));
			System.out.println("  Seguro Contra Acidentes   : "+df.format(CSA));
			System.out.println("  Fundo FGTS \t \t : "+df.format(fundoFGTS));
			System.out.println("=================================================================");
		}
			System.out.println("A media de todos os boletos pagos é de "+df.format(media / i));
			System.out.println("A quantidade de salarios abaixo de R$1908,93 é de "+perc.format(salarioAbaixo / (float)contFuncionario*100));
		
		
		
		leia.close();
	}

}
