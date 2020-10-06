package exercicio01;
import java.util.Scanner;

public class Exercicio01_Array {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int tamanho = 5;
		
		String nomes[] = new String[tamanho];
		float notas[] = new float[tamanho];
		int i;
		
		for (i = 0; i < nomes.length; i++) {
			System.out.println("==================================================");
			System.out.println("Informe o NOME do(a) "+(i+1)+"º(ª) aluno(a): ");
			nomes[i] = leia.nextLine();
			
			System.out.println("Informe a NOTA do(a) "+(i+1)+"º(ª) aluno(a): ");
			notas[i] = leia.nextFloat();
			
			//Limpeza Buffer
			leia.nextLine();
		}
		
		System.out.println("==================================================");
		for (i = 0; i < nomes.length; i++) {			
			System.out.println("O aluno(a) "+nomes[i].toUpperCase()+" teve a nota "+notas[i]);
		}
		
		
		leia.close();
	}

}
