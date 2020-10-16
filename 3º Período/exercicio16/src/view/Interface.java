package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Fisica;
import model.Juridica;
import model.Pessoa;

public class Interface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Pessoa> lista = new ArrayList<>();
		
		System.out.print("Digite o número de contribuintes: ");
		int qtd = sc.nextInt();
		
		for (int i = 0; i < qtd; i++) {
			System.out.println();
			System.out.println("Dados do Contribuinte " + (i+1));
			System.out.print("Pessoa Física ou Jurídica (f/j)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Renda anual: R$");
			double rendaAnual = sc.nextDouble();
			
			if (ch == 'f') {
				System.out.print("Despesas de saúde: R$");
				double despesaSaude = sc.nextDouble();
				lista.add(new Fisica(nome, rendaAnual, despesaSaude));
			} else if (ch == 'j') {
				System.out.print("Número de funcionários: ");
				int numFuncionarios = sc.nextInt();
				lista.add(new Juridica(nome, rendaAnual, numFuncionarios));
			}
		}
		
		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");
		double soma = 0.0;
		for (Pessoa p : lista) {
			System.out.println(p.getNome() + ": R$" + String.format("%.2f", p.imposto()));
		}
		
		for (Pessoa p : lista) {
			soma += p.imposto();
		}
		
		System.out.println();
		System.out.println("TOTAL DE IMPOSTO PAGO: R$" + String.format("%.2f", soma));
		sc.close();
	}
}
