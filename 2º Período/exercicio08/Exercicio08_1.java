package exercicio08;
import java.util.Scanner;

public class Exercicio08_1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		
		String nome;
		float salario;
		float novoSalario;
		float somaSalario = 0;
		byte numDependentes;
		byte salarioAcima1700 = 0;
		byte x;
		
		for (x = 0; x < 10; x++) {
	
		System.out.println("Digite o nome do funcionario: ");
		nome = leia.nextLine();
		nome += nome; // desconsiderar essa linha, ela existe só pra sumir a notificação do eclipse.
		
		System.out.println("Digite o salario do funcionario"); 
		salario = leia.nextFloat();
		
		System.out.println("Digite o numero de dependentes: ");
		numDependentes = leia.nextByte();
		
		if (salario < 1000) {
			novoSalario = salario * 1.3f;
		} else if (salario < 2000) {
			novoSalario = salario * 1.2f;
		} else {
			novoSalario = salario * 1.1f;
		}
		
		novoSalario  = novoSalario + 50 * numDependentes;
		somaSalario += novoSalario;
		if (novoSalario > 1700) {
			salarioAcima1700++;
		}
		
		leia.nextLine();
		}
		
		System.out.println("Somatoria de todos os salarios: " +somaSalario);
		System.out.println("Media dos novos salarios: " +(somaSalario/10));
		System.out.println("Funcionarios que passarao a receber 1700: "+salarioAcima1700);
		
		leia.close();
		
	}

}
