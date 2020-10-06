package exercicio03;
import java.util.*;

public class Exercicio03_1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		String nomeCidades[] = new String[20];
		String pesquisaCidades;
		float distanciaCidades[] = new float[20];
		float precoPassagem = 0;
		float tempoVoo = 0;
		boolean encontrou;
		int contEscalas = 0;
		int i;

		for (i = 0; i < 50; i++) {
			do {
				System.out.print("Digite o nome da " + (i + 1) + "a Cidade (Digite FIM para sair): ");
				nomeCidades[i] = leia.nextLine();

				if (nomeCidades[i].equals("")) {
					System.out.println("Preenchimento Obrigatorio!");
				}
			} while (nomeCidades[i].equals(""));
			if (nomeCidades[i].equalsIgnoreCase("FIM")) {
				break;
			}

			do {
				System.out.println("Digite a distancia da "+(i + 1)+"a cidade: ");
				distanciaCidades[i] = leia.nextFloat();
				
				if (distanciaCidades[i] < 500) {
					System.out.println("A distancia precisa ser de no minimo 500km!");
				}
			} while (distanciaCidades[i] < 500);
			
			// LIMPEZA DE BUFFER
			leia.nextLine();
		}
		
		System.out.println("(FIM para sair.)");
		do {
			System.out.println("Pesquise o nome da cidade desejada: ");
			pesquisaCidades = leia.nextLine();
			
			if (pesquisaCidades.equalsIgnoreCase("FIM")) {
				break;
			}
			
			encontrou = false;
			for (i = 0; i < 20; i++) {
				if (pesquisaCidades.equalsIgnoreCase(nomeCidades[i])) {
					encontrou = true;
					precoPassagem = distanciaCidades[i] * 0.25f;
					tempoVoo = distanciaCidades[i] / 800 * 60;
					if (tempoVoo > 180) {
						contEscalas++;
					} else if (tempoVoo > 360) {
						contEscalas+=2;
					} else {
						contEscalas+=3;
					}
					break;
				}
			}
			
			if (encontrou) {
				System.out.println("Cidade encontrada!");
				System.out.println("Cidade: "+nomeCidades[i]);
				System.out.println("Preço da Passagem: " +precoPassagem);
				System.out.println("Tempo de voo estimado em minutos: " +tempoVoo);
				System.out.println("Numero de escalas durante voo: " +contEscalas);
			} else {
				System.out.println("Cidade não encontrada!");
			}
		} while(!pesquisaCidades.equalsIgnoreCase("FIM"));
		
		leia.close();
	}

}
