package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import model.enums.StatusPedido;

public class Interface {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Data de Nascimento (DD/MM/AAAA): ");
		Date nascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, nascimento); // Instanciação do Cliente.

		System.out.println();
		System.out.println("Entre com os dados do Pedido:");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next()); // Enviar por Enum
		//String status = sc.next().toUpperCase(); // Enviar por String
		System.out.print("Quantos itens serão adicionados ao pedido? ");
		int qtdItem = sc.nextInt();
		
		Pedido pedido = new Pedido(new Date(), status, cliente); // Instanciação do Pedido associado ao Cliente.
		
		for (int i = 0; i < qtdItem; i++) {
			System.out.println();
			System.out.println("Entre com os dados do Item " + (i + 1));
			System.out.print("Nome do produto: ");
			sc.nextLine(); // Buffer
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do produto: ");
			double preco = sc.nextDouble();
			System.out.print("Quantidade: ");
			int qtdProduto = sc.nextInt();

			Produto produto = new Produto(nomeProduto, preco); // Instanciação do Produto.
			ItemPedido item = new ItemPedido(qtdProduto, preco, produto); // Instanciação dos Itens associado ao Produto.
			
			pedido.adicionarItem(item);
		}

		System.out.println();
		System.out.println("SUMÁRIO DO PEDIDO:");
		System.out.println(pedido);
		
		sc.close();
	}

}
