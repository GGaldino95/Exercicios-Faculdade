package exercicio01;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio01_1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.#");
		
		String nomeAluno, desempenho;
		byte nota[] = new byte [3];
		int contador, somaNotas = 0;
		float mediaNotas = 0;
		
		
		System.out.print("Por favor, entre o nome do Aluno:");
		nomeAluno = leia.nextLine();
		
		for (contador = 0; contador < 3; contador++) {
		System.out.print("Por favor, entre a "+(contador+1)+"ª Nota: ");
		nota[contador] = leia.nextByte();
		somaNotas += nota[contador];
		}
		
		mediaNotas = (float)somaNotas / contador;
		
		if (mediaNotas <= 4) {
			desempenho = "Aluno Reprovado";
		} else if (mediaNotas <= 6.9) {
			desempenho = "Aluno em Recuperação";
		} else {
			desempenho = "Aluno Aprovado";
		}
		
		// RELATÓRIO FINAL
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("Nome do Aluno: "+nomeAluno);
		System.out.println("Média das Notas: "+df.format(mediaNotas));
		System.out.println("Desempenho: "+desempenho);
		
		
		leia.close();
	}
}
