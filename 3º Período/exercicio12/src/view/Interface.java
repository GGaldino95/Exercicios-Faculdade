package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Funcionario;

public class Interface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Funcionario> lista = new ArrayList<>();

		System.out.print("Quantos empregados serão cadastrados? ");
		int tamanho = sc.nextInt();

		for (int i = 0; i < tamanho; i++) {
			System.out.println("");
			System.out.println("Funcionário #" + (i+1));
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			while (temId(lista, id)) {
				System.out.println("ID já existe, favor inserir valor diferente.");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			Double salario = sc.nextDouble();
			
			//FORMA RESUMIDA: lista.add(funcionario = new Funcionario(id, nome, salario));
			Funcionario funcionario = new Funcionario(id, nome, salario);
			lista.add(funcionario);
		}

		System.out.print("Digite a ID do funcionário que receberá o aumento: ");
		int id = sc.nextInt();
		
		//1ª Forma de fazer: Através de função lambda -> .stream() (usando predicados -> .filter()).
		Funcionario funcionario = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if (funcionario == null) {
			System.out.println("Este ID não existe!");
		} else {
			System.out.print("Digite o percentual: ");
			double porcentagem = sc.nextDouble();
			funcionario.aumentarSalario(porcentagem);
		}
		
		//2ª Forma de fazer: Através de método auxiliar.
		/*
		Integer posicao = encontrarId(lista, id);
		if (posicao == null) {
			System.out.println("Este ID não existe!");
		} else {
			System.out.print("Digite o percentual: ");
			double porcentagem = sc.nextDouble();
			lista.get(posicao).aumentarSalario(porcentagem);
		}
		*/

		System.out.println("");
		System.out.println("Listagem de funcionários: ");
		for (Funcionario x : lista) {
			System.out.println(x);
		}

		sc.close();
	}

	static Integer encontrarId(List<Funcionario> lista, int id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				return i;
				// lista.get = pega o índice do parâmetro 'lista' na posição 'i'.
				// .getId() = getter do objeto 'Funcionario' pegando o atributo 'id'.
			}
		}
		return null;
	}
	
	static boolean temId(List<Funcionario> lista, int id) {
		Funcionario funcionario = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return funcionario != null;
	}
}
