package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Product produto = new Product();
		
		System.out.println("=== CADASTRO ===");
		System.out.print("Informe o nome do produto: ");
		produto.nome = sc.nextLine();
		System.out.print("Informe o valor do produto: ");
		produto.price = sc.nextDouble();	
		System.out.print("Informe a quantidade em estoque: ");
		produto.quantity = sc.nextInt();
		
		System.out.println(produto);
		
		int qtd;
		
		System.out.print("Entre com o número de produtos a serem adicionados ao estoque: ");
		qtd = sc.nextInt();
		produto.addProducts(qtd);
		
		System.out.println(produto);
		
		System.out.print("Entre com o número de produtos a serem retirados do estoque: ");
		qtd = sc.nextInt();
		produto.removeProduct(qtd);
		
		System.out.println(produto);
		sc.close();
	}	
}
