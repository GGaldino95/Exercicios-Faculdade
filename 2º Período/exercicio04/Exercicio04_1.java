package exercicio04;
import java.util.*;

public class Exercicio04_1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		int numA, numB, numC;
		int valorCalculado;
		float percentual;

		System.out.print("Digite o valor do numero A: ");
		numA = leia.nextInt();
		System.out.print("Digite o valor do numero B: ");
		numB = leia.nextInt();
		System.out.print("Digite o valor do numero C: ");
		numC = leia.nextInt();

		valorCalculado = somarIntEntreAeB(numA, numB);
		System.out.println("A soma dos inteiros entre A e B é: " +valorCalculado);
		
		exibirNumEntreAeBdivisiveisPorC(numA, numB, numC);
		
		percentual = retornarPercentualDeCsobreA(numA, numC);
		System.out.println("O percentual de C em relação a A é de: " +percentual);
		
		
		
		leia.close();
	}

	public static int somarIntEntreAeB(int a, int b) {
		int soma = 0;
		
		for (int x = a+1; x <= b-1; x++) { //(x <= b-1) pode ser escrito também como (x < b)
			soma = soma + x; // ou soma += x;
		}
		return soma;
	}
	
	public static void exibirNumEntreAeBdivisiveisPorC(int a,int b,int c) {
		for (int x = a+1; x < b; x++) {
			if (x % c == 0) {
				System.out.println(x +" e divisivel por C");
			}
		}	
	}
	
	public static float retornarPercentualDeCsobreA (float a, float c) {
		float percent;
		percent = c * 100 / a;
		return percent;
	}
}
