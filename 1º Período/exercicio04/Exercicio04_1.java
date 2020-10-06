package exercicio04;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio04_1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");
		
		int horasTrabalhadas, salMin = 880;
		float hrtrab, salBruto, imposto, salReceber;
		
		System.out.print("Digite o número de horas trabalhadas: ");
		horasTrabalhadas = leia.nextInt();
		
		System.out.println("Hora trabalhada: "+df.format(hrtrab = salMin * 0.3f));
		System.out.println("Salário Bruto: "+df.format(salBruto = horasTrabalhadas * hrtrab));
		System.out.println("Imposto: "+df.format(imposto = salBruto * 0.03f));
		
		salReceber = salBruto - imposto;
		
		System.out.println("Salário a Receber: "+df.format(salReceber));
		
				
		leia.close();
	}

}
