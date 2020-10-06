package exercicio04;
import java.util.*;
public class Exercicio04_3 {

	//vetor global, valido em todos os metodos e inicializado com valores (entre chaves)
	static String vetCidades[] = {"BELO HORIZONTE","SAO PAULO","RIO DE JANEIRO","SALVADOR","CURITIBA"};
	
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		// VARIAVEIS
		String nomeHospede[] = new String[100];
		byte diaEntrada;
		byte diaSaida;
		String tipoQuarto;
		String cidadeHotel;
		float vlrConta[] = new float[100];
		float vlrMedioConta;
		float somaVlrConta = 0;
		byte cont;
		boolean encontrouCidade;
		
		// ENTRADA DE DADOS
		for (cont = 0; cont < 100; cont++) {
			System.out.print("Digite o nome do hospede (Fim p/ encerrar): ");
			nomeHospede[cont] = leia.nextLine();
				if (nomeHospede[cont].equalsIgnoreCase("fim")) {
					break;
				}
			
			do {
				System.out.println("Digite o dia da entrada: ");
				diaEntrada = leia.nextByte();
				System.out.print("Digite o dia da saida: ");
				diaSaida = leia.nextByte();
					if (diaSaida <= diaEntrada || diaSaida < 1 || diaEntrada < 1) {
						System.out.println("Valor invalido, dia saida deve ser maior que dia entrada e acima de zero.");
					}
			} while (diaSaida <= diaEntrada || diaSaida < 1 || diaEntrada < 1);
				
			do {
				System.out.print("Digite o tipo de quarto: ");
				tipoQuarto = leia.next();
					if (! tipoQuarto.equalsIgnoreCase("standard") && ! tipoQuarto.equalsIgnoreCase("luxo") && ! tipoQuarto.equalsIgnoreCase("superluxo")) {
						System.out.println("Quarto invalido, digite LUXO, SUPERLUXO ou STANDARD.");
					}
					
			} while(! tipoQuarto.equalsIgnoreCase("standard") && ! tipoQuarto.equalsIgnoreCase("luxo") && ! tipoQuarto.equalsIgnoreCase("superluxo"));
				
			leia.nextLine(); //buffer
			do {
				System.out.print("Digite o nome da cidade do hotel: ");
				cidadeHotel = leia.nextLine();
				encontrouCidade = cidadeEhValida(cidadeHotel);
				if (!encontrouCidade) {
					System.out.println("Nao ha hotel nesta cidade, digite outra.");
				}				
			} while(!encontrouCidade);
				
			// CALCULOS
			vlrConta[cont] = calcularConta(diaEntrada, diaSaida, tipoQuarto);
			somaVlrConta += vlrConta[cont];
		}

		vlrMedioConta = somaVlrConta / cont;
		
		System.out.println("Relatorio de contas acima da media");
		System.out.println("NOME HOSPEDE     VLR CONTA");
		for (byte x = 0; x < cont; x++) {
			if (vlrConta[x] > vlrMedioConta) {
				System.out.println(nomeHospede[x] + "    "+ vlrConta);
			}
		}
		
		
		leia.close();
	}

	public static boolean cidadeEhValida (String nomeCidade) {
		boolean encontrou = false;
	
		for (int i = 0; i < vetCidades.length; i++) {
			if (nomeCidade.equalsIgnoreCase(vetCidades[i])) {
				encontrou = true;
				break;
			}
		}
		return encontrou;
	}
	
	public static float calcularConta (byte entrada, byte saida, String tpQuarto) {
		int valorDiaria;
		if (tpQuarto.equalsIgnoreCase("standard")) {
			valorDiaria = 120;
		} else if (tpQuarto.equalsIgnoreCase("luxo")) {
			valorDiaria = 150;
		} else {
			valorDiaria = 180;
		}
		
		return (saida - entrada) * valorDiaria;
	}
}
