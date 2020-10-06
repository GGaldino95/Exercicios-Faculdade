package exercicio01;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio01_3 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");
		
		float salario, salarioNovo;
		char sexo;
		
		System.out.print("Informe o Salário: ");
		salario = leia.nextFloat();
		
		System.out.print("Informe o Sexo (F/M): ");
		sexo = leia.next().charAt(0);
		
		if (salario <= 1500) {
			salarioNovo = salario * 1.10f;
		} else if (salario <= 5000) {
			salarioNovo = salario * 1.05f;
		} else {
			salarioNovo = salario;
		}
		
		if (sexo == 'f' || sexo == 'F') {
			salarioNovo += 150;
		}
		
		System.out.println("Salário Novo: "+df.format(salarioNovo));
		

		
		leia.close();
	}

}
