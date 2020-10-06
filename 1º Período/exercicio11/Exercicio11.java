package exercicio11;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio11 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("R$ #,##0.00");

		int totalVendidaSul = 0, contPassageiro, idaEVolta = 0;
		float totalFaturado = 0;

		// Armazenar todos os dados em vetores para mostrar no resultado final
		String nome[] = new String[100];
		int totalPassagens[] = new int[100];
		int destino[] = new int[100];
		int tipoPassagem[] = new int[100];
		float valorVenda[] = new float[100];
		
		System.out.println("|========================================================|");
		System.out.println("|================== AGÊNCIA DE VIAGENS ==================|");
		System.out.println("|=====================   Bem vindo!  ====================|");
		System.out.println("|========================================================|");
		System.out.println("|====== Região ======|==== Ida ====|==== Ida e Volta ====|");
		System.out.println("|Região Norte:          R$ 500,00         R$ 900,00  ====|");
		System.out.println("|Região Nordeste:       R$ 500,00         R$ 900,00  ====|");
		System.out.println("|Região Centro-Oeste:   R$ 500,00         R$ 900,00  ====|");
		System.out.println("|Região Sul:            R$ 500,00         R$ 900,00  ====|");
		System.out.println("|========================================================|");
		System.out.println("(Pressione N para Sair.)");
		System.out.println("");

		for (contPassageiro = 0; contPassageiro < 100; contPassageiro++) {
			System.out.print("\nNome do passageiro (Digite N para sair): ");
			nome[contPassageiro] = leia.nextLine().toUpperCase();

			if (nome[contPassageiro].equals("N")) {
				break;
			}
			
			do {
				System.out.println("1 – Região Norte \n2 – Região Nordeste \n3 – Região Centro-Oeste \n4 – Região Sul");
				System.out.print("Código Destino: ");
				destino[contPassageiro] = leia.nextInt();
				if(destino[contPassageiro] < 1 || destino[contPassageiro] > 4) {
					System.err.println("Valor Inválido!");
				}
			} while (destino[contPassageiro] < 1 || destino[contPassageiro] > 4);
			

			do {
				System.out.println("1 – Ida \n2 – Ida e Volta");
				System.out.print("Código Tipo Passagem: ");
				tipoPassagem[contPassageiro] = leia.nextInt();
				if(tipoPassagem[contPassageiro] < 1 || tipoPassagem[contPassageiro] > 2) {
					System.err.println("Valor Inválido!");
				}
			} while (tipoPassagem[contPassageiro] < 1 || tipoPassagem[contPassageiro] > 2);
		
			do {
				System.out.print("Quantidade Passageiros: ");
				totalPassagens[contPassageiro] = leia.nextInt();
				if(totalPassagens[contPassageiro]<=0) {
					System.err.println("O numero de passagens deve ser maior que Zero");
				}
			} while (totalPassagens[contPassageiro]<=0);
			

			// Calculo do valor da venda
			switch (destino[contPassageiro]) {
			case 1:
				// Verificar o tipo de passagem se é somente ida ou ida e volta
				if (tipoPassagem[contPassageiro] == 1) {
					valorVenda[contPassageiro] = 500;
				} else {
					idaEVolta++;
					valorVenda[contPassageiro] = 900;
				}
				break;
			case 2:
				if (tipoPassagem[contPassageiro] == 1) {
					valorVenda[contPassageiro] = 350;
				} else {
					idaEVolta++;
					valorVenda[contPassageiro] = 650;
				}
				break;
			case 3:
				if (tipoPassagem[contPassageiro] == 1) {
					valorVenda[contPassageiro] = 350;
				} else {
					idaEVolta++;
					valorVenda[contPassageiro] = 600;
				}
				break;
			case 4:
				totalVendidaSul++;
				if (tipoPassagem[contPassageiro] == 1) {
					valorVenda[contPassageiro] = 300;
				} else {
					idaEVolta++;
					valorVenda[contPassageiro] = 550;
				}
				break;
			}

			// Multiplicar o valor pela quantidade de passageiros
			valorVenda[contPassageiro] = valorVenda[contPassageiro] * totalPassagens[contPassageiro];

			// Inserir o desconto de 3.5%
			if (totalPassagens[contPassageiro] > 1) {
				valorVenda[contPassageiro] *= 0.965;
			}

			totalFaturado += valorVenda[contPassageiro];
			System.out.println("\nVendido " + totalPassagens[contPassageiro] + " passagen(s) para " + nome[contPassageiro]
					+ " por " + df.format(valorVenda[contPassageiro]));

			//Limpeza do buffer
			leia.nextLine();
			
		}

		System.out.println("====================================================");
		System.out.println("                  RESULTADO FINAL");
		System.out.println("====================================================");

		// Para não ter divisão por ZERO
		if (contPassageiro > 0) {
			System.out.println("A quantidade de passagens vendidas para a região Sul é: " + totalVendidaSul);
			System.out.println("A média dos valores faturados por todas as passagens é: "
					+ df.format(totalFaturado / contPassageiro));
			System.out
					.println("A porcentagem de passagens de ida e volta vendida é   : " + (idaEVolta / (float)contPassageiro*100));

			System.out.println("\n============================================");
			for (int i = 0; i < contPassageiro; i++) {
				System.out.println("Nome do passageiro: " + nome[i]);
				System.out.println("Total de passagens: " + totalPassagens[i]);
				System.out.print("Destino ");
				// Para imprimir o nome do destino e não o número inserido
				switch (destino[i]) {
				case 1:
					System.out.println("Região Norte");
					break;
				case 2:
					System.out.println("Região Norteste");
					break;
				case 3:
					System.out.println("Região Centro-Oeste");
					break;
				case 4:
					System.out.println("Região Sul");
					break;
				}

				System.out.print("Passagem de ");
				// Para imprimir se a passagem é ida ou ida e volta e não o número
				switch (tipoPassagem[i]) {
				case 1:
					System.out.println("Ida");
					break;
				case 2:
					System.out.println("Ida e Volta");
					break;
				}                   
				System.out.println("Valor total       : "+df.format(valorVenda[i]));
				System.out.println("============================================");
			}
		} else {
			System.out.println("Nenhuma passagem vendida!");
		}

		
		leia.close();
	}

}
