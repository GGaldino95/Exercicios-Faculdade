package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Funcionario;
import model.FuncionarioTerceirizado;

public class Interface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Funcionario> lista = new ArrayList<>();

		System.out.print("Digite a quantidade de funcionários: ");
		int qtd = sc.nextInt();

		for (int i = 0; i < qtd; i++) {
			System.out.println();
			System.out.println("Digite os dados do funcionário " + (i + 1));
			System.out.print("Terceirizado (S/N)?");
			char terceirizado = sc.next().charAt(0);

			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas: ");
			int horas = sc.nextInt();
			System.out.print("Valor por Hora: ");
			double valorHora = sc.nextDouble();

			if (terceirizado == 's' || terceirizado == 'S') {
				System.out.print("Despesa Adicional: ");
				double despesaAdicional = sc.nextDouble();

				Funcionario funcionario = new FuncionarioTerceirizado(nome, horas, valorHora, despesaAdicional);
				lista.add(funcionario);
			} else {
				lista.add(new Funcionario(nome, horas, valorHora)); // Pode-se instanciar o objeto dessa forma também.
			}
		}

		System.out.println();
		System.out.println("PAGAMENTOS:");
		for (Funcionario funcionario : lista) {
			System.out.println(funcionario.getNome() + " - R$" + String.format("%.2f", funcionario.pagamento()));
		}

		sc.close();
	}
}
