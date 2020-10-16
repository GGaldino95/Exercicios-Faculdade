package view;

import java.util.Scanner;

import model.Funcionario;

public class Interface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Funcionario funcionario = new Funcionario();

		System.out.print("Digite o nome do funcionario: ");
		funcionario.nome = sc.nextLine();
		System.out.print("Digite o salario bruto do funcionario: ");
		funcionario.salarioBruto = sc.nextDouble();
		System.out.print("Digite o valor do imposto do funcionario: ");
		funcionario.imposto = sc.nextDouble();
		
		System.out.println(funcionario);
		
		System.out.print("Aumentar o salario em que porcentagem: ");
		double porcentagem = sc.nextDouble();
		funcionario.aumentarSalario(porcentagem);
		
		System.out.println("Dados atualizados: \n" + funcionario);
		sc.close();
	}

}
