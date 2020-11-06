package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Interface {

	public static void main(String[] args) {

		String caminho = "DIRECTORY_PATH\\in.txt";
		FileReader fr = null; // Stream de leitura de caracteres a partir de arquivos
		BufferedReader br = null; // É instanciado a partir do FileReader além de implementar algumas otimizações utilizando buffer de memória (mais rápido)

		try { // Tentativa de abrir o arquivo
			fr = new FileReader(caminho);
			br = new BufferedReader(fr); // Instanciação a partir do FileReader, que é instanciado pela String 'caminho'

			// Outra forma de implementação:
			// br = new BufferedReader(new FileReader(caminho));

			String linha = br.readLine(); // Irá ler uma linha do arquivo, se estiver na linha final retornará nulo

			while (linha != null) {
				System.out.println(linha); // Irá imprimir a linha atual
				linha = br.readLine(); // Irá ler a próxima linha do arquivo
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally { // Nas linhas onde há '.close()', também existe a possibilidade de gerar uma
					// exceção, então deve-se colocar um 'try'
			try {
				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
