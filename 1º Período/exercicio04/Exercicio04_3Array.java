package exercicio04;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio04_3Array {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");

		int qtdCodigo[] = new int[6], codigo, quantidade = 0, qtdTotal = 0;

		float valorqtdCodigo[] = new float[6], valorConta = 0, somatoria = 0;

		System.out.println("=================================");
		System.out.println("            CARDÁPIO            ");
		System.out.println(""); 
		System.out.println("Produto          Cod    Preço");
		System.out.println("Cachorro Quente  100    R$1,20");
		System.out.println("Bauru Simples    101    R$1,30");
		System.out.println("Bauru com ovo    102    R$1,50");
		System.out.println("Hambúrguer       103    R$1,20");
		System.out.println("Cheeseburguer    104    R$1,30");
		System.out.println("Refrigerante     105    R$1,00");
		System.out.println("=================================");
		System.out.println("(Para finalizar a compra, digite 99)");

		do {
			do {
				System.out.println("");
				System.out.print("Escreva o código do produto: ");
				codigo = leia.nextInt();

				if (codigo < 99 || codigo > 105) {
					System.out.println("Código Inválido!");
				}
			} while (codigo < 99 || codigo > 105);

			// FLAG
			if (codigo == 99) {
				break;
			}

			System.out.print("Escreva a quantidade do produto: ");
			quantidade = leia.nextInt();
			System.out.println("");
			System.out.println("Produto Selecionado: ");

			switch (codigo) {
			case 100:
				System.out.println("Cachorro Quente (R$1,20) x" + (quantidade));
				valorConta = quantidade * 1.2f;
				qtdCodigo[0] += quantidade;
				valorqtdCodigo[0] += valorConta;
				break;
			case 101:
				System.out.println("Bauru Simples (R$1,30) x" + (quantidade));
				valorConta = quantidade * 1.3f;
				qtdCodigo[1] += quantidade;
				valorqtdCodigo[1] += valorConta;
				break;
			case 102:
				System.out.println("Bauru com Ovo (R$1,50) x" + (quantidade));
				valorConta = quantidade * 1.5f;
				qtdCodigo[2] += quantidade;
				valorqtdCodigo[2] += valorConta;
				break;
			case 103:
				System.out.println("Hambúrguer (R$1,20) x" + (quantidade));
				valorConta = quantidade * 1.2f;
				qtdCodigo[3] += quantidade;
				valorqtdCodigo[3] += valorConta;
				break;
			case 104:
				System.out.println("Cheeseburguer (R$1,30) x" + (quantidade));
				valorConta = quantidade * 1.3f;
				qtdCodigo[4] += quantidade;
				valorqtdCodigo[4] += valorConta;
				break;
			case 105:
				System.out.println("Refrigerante (R$1,00) x" + (quantidade));
				valorConta = quantidade * 1f;
				qtdCodigo[5] += quantidade;
				valorqtdCodigo[5] += valorConta;
				break;
			}

			qtdTotal += quantidade;
			somatoria += valorConta;
		} while (true);

		
		  if (codigo == 100) {
		  System.out.println("Cachorro Quente (R$1,20) x"+(quantidade)); valorConta =
		  quantidade * 1.2f; } else if (codigo == 101) {
		  System.out.println("Bauru Simples (R$1,30) x"+(quantidade)); valorConta =
		  quantidade * 1.3f; } else if (codigo == 102) {
		  System.out.println("Bauru com Ovo (R$1,50) x"+(quantidade)); valorConta =
		  quantidade * 1.5f; } else if (codigo == 103) {
		  System.out.println("Hambúrguer (R$1,20) x"+(quantidade)); valorConta =
		  quantidade * 1.2f; } else if (codigo == 104) {
		  System.out.println("Cheeseburguer (R$1,30) x"+(quantidade)); valorConta =
		  quantidade * 1.3f; } else if (codigo == 105) {
		  System.out.println("Refrigerante (R$1,00) x"+(quantidade)); valorConta =
		  quantidade * 1f; } else { System.out.println("Código Inválido!"); }
		 

		System.out.println("=================================");
		System.out.println("            RELATÓRIO            ");
		System.out.println("x" + (qtdCodigo[0]) + " Cachorros Quentes: " + df.format(valorqtdCodigo[0]));
		System.out.println("x" + (qtdCodigo[1]) + " Baurus Simples: " + df.format(valorqtdCodigo[1]));
		System.out.println("x" + (qtdCodigo[2]) + " Baurus com Ovos: " + df.format(valorqtdCodigo[2]));
		System.out.println("x" + (qtdCodigo[3]) + " Hambúrgueres: " + df.format(valorqtdCodigo[3]));
		System.out.println("x" + (qtdCodigo[4]) + " Cheeseburguers: " + df.format(valorqtdCodigo[4]));
		System.out.println("x" + (qtdCodigo[5]) + " Refrigerantes: " + df.format(valorqtdCodigo[5]));
		System.out.println("=================================");
		System.out.println("Total de Itens vendidos: " + (qtdTotal));
		System.out.println("Total Vendido: " + df.format(somatoria));

		leia.close();
	}

}
