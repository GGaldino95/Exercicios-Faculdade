package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Produto;
import model.ProdutoImportado;
import model.ProdutoUsado;

public class Interface {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Produto> lista = new ArrayList<>();

		System.out.print("Quantos produtos serão cadastrados: ");
		int qtd = sc.nextInt();

		for (int i = 0; i < qtd; i++) {
			System.out.println();
			System.out.println("Dados do Produto " + (i + 1));
			System.out.print("O Produto é Comum, Importado ou Usado (c/i/u)? ");
			char tipoProduto = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine(); // Buffer
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();

			if (tipoProduto == 'i' || tipoProduto == 'I') {
				System.out.print("Taxa alfandegária: ");
				double taxaAlfandega = sc.nextDouble();
				lista.add(new ProdutoImportado(nome, preco, taxaAlfandega));
				
			} else if (tipoProduto == 'u' || tipoProduto == 'U') {
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				sc.nextLine();
				String dataFabricacao = sc.nextLine();
				lista.add(new ProdutoUsado(nome, preco, sdf.parse(dataFabricacao)));
				
			} else if (tipoProduto == 'c' || tipoProduto == 'c') {
				lista.add(new Produto(nome, preco));
				
			}
		}

		System.out.println();
		System.out.println("ETIQUETAS DE PRODUTOS:");
		for (Produto p : lista) {
			System.out.println(p.etiquetaPreco());
		}

		sc.close();
	}
}
