package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import model.Contrato;
import model.Departamento;
import model.Trabalhador;
import model.enums.NivelTrabalhador;

public class Interface {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Trabalhador trabalhador;
		
		System.out.print("Digite o departamento desejado: ");
		String departamento = sc.nextLine();
		
		System.out.println();
		System.out.println("Dados do trabalhador:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível: ");
		String nivel = sc.nextLine();
		System.out.print("Salário base: ");
		Double salarioBase = sc.nextDouble();
		
		trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase, new Departamento(departamento));
		/* Instanciação do objeto 'trabalhador'.
		 * O Nível do trabalhador é do tipo Enum, então será necessário enviar o valor (valueOf) da String 'nivel'.
		 * O departamento é um outro objeto do tipo Departamento, então é necessário instanciá-lo para fazer a associação da String com o objeto.*/
		
		System.out.print("Quantos contratos serão vinculados a esse trabalhador? ");
		int qtdContratos = sc.nextInt();
		
		for (int i = 0; i < qtdContratos; i++) {
			System.out.println();
			System.out.println("Dados do contrato "+(i+1));
			System.out.print("Data (DD/MM/AAAA): ");
			Date data = sdf.parse(sc.next()); // Entrada da String digitada e sendo convertida através do 'sdf.parse' para o tipo Date.
			System.out.print("Valor cobrado por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			Integer horas = sc.nextInt();
			
			Contrato contrato = new Contrato(data, valorHora, horas); // Instanciação do contrato.
			trabalhador.AdicionarContrato(contrato); // Adicionando o 'contrato' na lista de Contratos (List<Contrato> contratos) dentro de Trabalhador.
		}
		
		System.out.println();
		System.out.print("Digite o mês e ano para calcular o ganho (MM/YYYY): ");
		String data2 = sc.next();
		int mes = Integer.parseInt(data2.substring(0,2));
		int ano = Integer.parseInt(data2.substring(3));
		
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome()); // Objeto 'Trabalhador' acessando o objeto 'Departamento' acessando o atributo 'nome' contido em 'Departamento'.
		System.out.println("Ganho em " + data2 + ": " + String.format("%.2f", trabalhador.calcularGanho(ano, mes)));
		
		// Opção toString():
		// System.out.println(trabalhador);

		sc.close();
	}
}
