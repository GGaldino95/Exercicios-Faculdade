package exercicio06;
import java.util.*;
public class Exercicio06_1 {

	public static void main(String[] args) {
		String nome;
		Scanner leia = new Scanner(System.in);
		
		System.out.println("Digite o nome em letras minusculas: ");
		nome = leia.nextLine();
		
		nome = eliminarEspacosEsquerda(nome);
		System.out.println(nome + "*****");
		
		nome = eliminarEspacosDireita(nome);
		System.out.println(nome + "*****");
		
		//nome = eliminarEspacosDireita( eliminarEspacosEsquerda(nome));
		
		nome = eliminarExcessoEspacosEntreNomes(nome);
		System.out.println(nome);
		
		System.out.println( converterPrimLetraMaiusc(nome) );
		
		nome = converterPrimLetraMaiuscCadaNome(nome);
		System.out.println(nome);
		
		
		
		leia.close();
	}

	public static String converterPrimLetraMaiusc (String texto) {
		return Character.toUpperCase(texto.charAt(0)) + texto.substring(1);
		
	}
	
	public static String converterPrimLetraMaiuscCadaNome (String texto) {
		texto = converterPrimLetraMaiusc(texto);
		for (int x = 1; x < texto.length() ; x++) {
			if (texto.charAt(x) == ' ') {
				texto = texto.substring(0,x+1) + Character.toUpperCase(texto.charAt(x+1)) + 
						texto.substring(x+2);
			}
		}
		return texto;
		
	}
	
	public static String eliminarEspacosEsquerda (String texto) {
		while (texto.charAt(0) == ' ') {
			texto = texto.replaceFirst(" ","");
		}
		return texto;
	}
	
	public static String eliminarEspacosDireita (String texto) {
		while (texto.charAt( texto.length() - 1 ) == ' ') {
			texto = texto.substring( 0 , texto.length() - 1 );
		} 
		return texto;
	}
	
	public static String eliminarExcessoEspacosEntreNomes (String texto) {
		while (texto.contains("  ")) {
			texto = texto.replace("  "," ");
		}
		return texto;
	}
}
