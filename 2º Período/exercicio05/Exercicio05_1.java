package exercicio05;
import java.util.Scanner;

public class Exercicio05_1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		String dtNasc;
		String dtHj;

		System.out.print("Digite a data de Nascimento (DD/MM/AAAA): ");
		dtNasc = leia.nextLine();

		System.out.print("Digite a data de hoje (DD/MM/AAAA): ");
		dtHj = leia.nextLine();
		
		System.out.println("A idade e "+calcularIdade(dtNasc, dtHj));
		
		
		leia.close();
	}

	public static int calcularIdade (String dataNasc, String dataHj) {
		
		//String diaNasc;
		String mesNasc, anoNasc;
		String diaHj, mesHj, anoHj;
		int idade = 0;
		int anoN, mesN, diaN;
		int anoA, mesA, diaA;
		
		//diaNasc = dataNasc.substring(0, 2);
		mesNasc = dataNasc.substring(3, 5);
		anoNasc = dataNasc.substring(6);

		diaHj = dataHj.substring(0, 2);
		mesHj = dataHj.substring(3, 5);
		anoHj = dataHj.substring(6);

		//conversao de String em numero
		
		anoN = Integer.parseInt(anoNasc);
		mesN = Integer.parseInt(mesNasc);
		diaN = Integer.parseInt(dataNasc.substring(0, 2)); // e uma forma mais resumida de fazer o comando usando dois metodos na mesma linha
		
		anoA = Integer.parseInt(anoHj);
		mesA = Integer.parseInt(mesHj);
		diaA = Integer.parseInt(diaHj);
		
		//idade = Integer.parseInt(dataHj.substring(6)) - Integer.parseInt(dataNasc.substring(6));  outra maneira de resumir o codigo, porem de forma confusa
		
		idade = anoA - anoN;
		if (mesA < mesN || mesA == mesN && diaA < diaN) {
			idade --;
		} 
		
		return idade;
	}
	
}
