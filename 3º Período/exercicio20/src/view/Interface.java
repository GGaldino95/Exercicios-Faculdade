package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Interface {

	public static void main(String[] args) {

		File arquivo = new File("DIRECTORY_PATH\\in.txt");
		Scanner sc = null;

		// Instanciar o Scanner a partir do arquivo:
		try { // Deve-se usar o bloco 'try' pois ao tentar abrir o arquivo, pode ser gerada uma exceção do tipo IOException
			sc = new Scanner(arquivo);
			while (sc.hasNextLine()) { // hasNextLine(): Testa se ainda existe uma nova linha no arquivo
				System.out.println(sc.nextLine()); // Impressão da linha no arquivo
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally { // bloco para fechamento do recurso independente se der certo i 'try' ou não
			if (sc != null) 
				sc.close();
		}
	}
}
