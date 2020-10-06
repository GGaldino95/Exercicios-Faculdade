package exercicio04;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio04_3LoopEterno {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$#,###.00");

		int codigo, quantidade, qtdTotal = 0, qtdCodigo100 = 0, qtdCodigo101 = 0, qtdCodigo102 = 0, qtdCodigo103 = 0,
				qtdCodigo104 = 0, qtdCodigo105 = 0;

		float valorConta = 0, somatoria = 0, valorqtdCodigo100 = 0, valorqtdCodigo101 = 0, valorqtdCodigo102 = 0,
				valorqtdCodigo103 = 0, valorqtdCodigo104 = 0, valorqtdCodigo105 = 0;

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
				qtdCodigo100 += quantidade;
				valorqtdCodigo100 += valorConta;
				break;
			case 101:
				System.out.println("Bauru Simples (R$1,30) x" + (quantidade));
				valorConta = quantidade * 1.3f;
				qtdCodigo101 += quantidade;
				valorqtdCodigo101 += valorConta;
				break;
			case 102:
				System.out.println("Bauru com Ovo (R$1,50) x" + (quantidade));
				valorConta = quantidade * 1.5f;
				qtdCodigo102 += quantidade;
				valorqtdCodigo102 += valorConta;
				break;
			case 103:
				System.out.println("Hambúrguer (R$1,20) x" + (quantidade));
				valorConta = quantidade * 1.2f;
				qtdCodigo103 += quantidade;
				valorqtdCodigo103 += valorConta;
				break;
			case 104:
				System.out.println("Cheeseburguer (R$1,30) x" + (quantidade));
				valorConta = quantidade * 1.3f;
				qtdCodigo104 += quantidade;
				valorqtdCodigo104 += valorConta;
				break;
			case 105:
				System.out.println("Refrigerante (R$1,00) x" + (quantidade));
				valorConta = quantidade * 1f;
				qtdCodigo105 += quantidade;
				valorqtdCodigo105 += valorConta;
				break;
			}

			qtdTotal += quantidade;
			somatoria += valorConta;
		} while (true);

		/*
		 * if (codigo == 100) {
		 * System.out.println("Cachorro Quente (R$1,20) x"+(quantidade)); valorConta =
		 * quantidade * 1.2f; } else if (codigo == 101) {
		 * System.out.println("Bauru Simples (R$1,30) x"+(quantidade)); valorConta =
		 * quantidade * 1.3f; } else if (codigo == 102) {
		 * System.out.println("Bauru com Ovo (R$1,50) x"+(quantidade)); valorConta =
		 * quantidade * 1.5f; } else if (codigo == 103) {
		 * System.out.println("Hambúrguer (R$1,20) x"+(quantidade)); valorConta =
		 * quantidade * 1.2f; } else if (codigo == 104) {
		 * System.out.println("Cheeseburguer (R$1,30) x"+(quantidade)); valorConta =
		 * quantidade * 1.3f; } else if (codigo == 105) {
		 * System.out.println("Refrigerante (R$1,00) x"+(quantidade)); valorConta =
		 * quantidade * 1f; } else { System.out.println("Código Inválido!"); }
		 */

		System.out.println("=================================");
		System.out.println("            RELATÓRIO            ");
		System.out.println("x" + (qtdCodigo100) + " Cachorros Quentes: " + df.format(valorqtdCodigo100));
		System.out.println("x" + (qtdCodigo101) + " Baurus Simples: " + df.format(valorqtdCodigo101));
		System.out.println("x" + (qtdCodigo102) + " Baurus com Ovos: " + df.format(valorqtdCodigo102));
		System.out.println("x" + (qtdCodigo103) + " Hambúrgueres: " + df.format(valorqtdCodigo103));
		System.out.println("x" + (qtdCodigo104) + " Cheeseburguers: " + df.format(valorqtdCodigo104));
		System.out.println("x" + (qtdCodigo105) + " Refrigerantes: " + df.format(valorqtdCodigo105));
		System.out.println("=================================");
		System.out.println("Total de Itens vendidos: " + (qtdTotal));
		System.out.println("Total Vendido: " + df.format(somatoria));

		leia.close();
	}

}
