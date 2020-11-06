package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Interface {

	public static void main(String[] args) {

		String caminho = "DIRECTORY_PATH\\in.txt";
		FileReader fr = null; // Stream de leitura de caracteres a partir de arquivos
		BufferedReader br = null; // � instanciado a partir do FileReader al�m de implementar algumas otimiza��es utilizando buffer de mem�ria (mais r�pido)

		try { // Tentativa de abrir o arquivo
			fr = new FileReader(caminho);
			br = new BufferedReader(fr); // Instancia��o a partir do FileReader, que � instanciado pela String 'caminho'

			// Outra forma de implementa��o:
			// br = new BufferedReader(new FileReader(caminho));

			String linha = br.readLine(); // Ir� ler uma linha do arquivo, se estiver na linha final retornar� nulo

			while (linha != null) {
				System.out.println(linha); // Ir� imprimir a linha atual
				linha = br.readLine(); // Ir� ler a pr�xima linha do arquivo
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally { // Nas linhas onde h� '.close()', tamb�m existe a possibilidade de gerar uma
					// exce��o, ent�o deve-se colocar um 'try'
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
