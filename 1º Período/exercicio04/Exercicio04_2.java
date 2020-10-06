package exercicio04;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio04_2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");

		float salario, vendas, salarioFinal;

		System.out.print("Informe seu salário: ");
		salario = leia.nextFloat();
		
		System.out.print("Informe o total de vendas no mês: ");
		vendas = leia.nextFloat();

		if (vendas <= salario) {
			salarioFinal = salario * 0.15f + salario;
		} else {
			salarioFinal = salario * 0.2f + salario;
		}

		System.out.println("Salário Fixo: " + df.format(salario));
		System.out.println("Salário Final: " + df.format(salarioFinal));

		leia.close();
	}

}
