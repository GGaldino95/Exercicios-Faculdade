package exercicio05;
import java.util.Scanner;

public class Exercicio05_2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		String codigo;
		boolean valido;
		
		do {
			System.out.print("Digite o codigo de 11 digitos: ");
			codigo = leia.next();
			valido = true;
					
				if (codigo.length() != 11) {
					System.out.println("Erro! Entre 11 DIGITOS obrigatoriamente!");
					valido = false;
				} else {
					for (byte x = 0; x < 11; x++) {
						if (codigo.charAt(x) < '0' || codigo.charAt(x) > '9') {
							System.out.println("Erro! Digite APENAS digitos");
							valido = false;
							break;
						}
					}
				}
		}while(!valido);
		
		leia.close();
	}

	 @SuppressWarnings("unused")
	public static String calcularDigitos (String cod) {
		 int soma = 0;
		 int mult = 0;
		 int digitoUm;
		 int digitoDois;
		 
		 for (byte i = 0; i < 9; i++) {
			// resolução usando CHAR
			/*  char caracter = cod.charAt(i);
				int numero = Character.digit(caracter, 10);
				soma += numero;
			*/
			
			// resolução usando STRING
			/*  String str = cod.substring(i, i+1);
				int numero = Integer.parseInt(str);
				soma += numero;
			*/
			
			// resolução STRING simplificada
			soma += Integer.parseInt(cod.substring(i, i+1));
			digitoUm = soma / 10;
			
			mult *= Integer.parseInt(cod.substring(i, i+1));
			//digitoDois = 
		}
		 
		 
		 
		 return cod;
	 }
	
}
