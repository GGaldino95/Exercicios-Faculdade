package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Circulo;
import model.Forma;
import model.Retangulo;
import model.enums.Cor;

public class Interface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Forma> lista = new ArrayList<>();
		
		System.out.print("Digite o número de formas: ");
		int qtd = sc.nextInt();
		
		for (int i = 0; i < qtd; i++) {
			System.out.println();
			System.out.println("Dados da Forma "+(i+1));
			
			System.out.print("Retângulo ou Círculo (r/c)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("COR (PRETO/AZUL/VERMELHO): ");
			Cor cor = Cor.valueOf(sc.next());
			
			if (ch == 'r') {
				System.out.print("Largura: ");
				double largura = sc.nextDouble();
				System.out.print("Altura: ");
				double altura = sc.nextDouble();
				lista.add(new Retangulo(cor, largura, altura));
				
			} else if (ch == 'c') {
				System.out.print("Raio: ");
				double raio = sc.nextDouble();
				lista.add(new Circulo(cor, raio));
				
			}
		}
		
		System.out.println();
		System.out.println("ÁREAS DAS FORMAS:");
		for (Forma f : lista) {
			System.out.println(String.format("%.2f", f.area()));
		}

		sc.close();
	}

}
