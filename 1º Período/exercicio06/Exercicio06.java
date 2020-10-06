package exercicio06;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio06 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat ("R$#,###.00");
		
		System.out.println("|===================================|");
		System.out.println("|========== CARANGO VELHO ==========|");
		System.out.println("|==========   Bem vindo!  ==========|");
		System.out.println("|===================================|");
		System.out.println("");
		
		char flag;
		int idadeComprador, anoCarro;
		float valorCarro, valorCarro1, valorCarro2, desconto1  = 0, desconto2 = 0,
				totalVendas = 0, totalDesconto = 0, descontos,
				maiorDesconto = Float.MIN_VALUE, menorDesconto = Float.MAX_VALUE; 
		
		//ANO CARRO
		do{
			do {
		System.out.print("Por favor, informe o ANO do carro: ");
		anoCarro = leia.nextInt();
			if (anoCarro < 1990 || anoCarro > 2014) {
				System.out.println("O ano deve ser entre 1990 e 2014.");
				System.out.println("=====================================");
				System.out.println("");
			}
		} while (anoCarro < 1990 || anoCarro > 2014);
		
		//VALOR
		do {
			System.out.print("Por favor, informe o VALOR ATUAL do carro: R$");
			valorCarro = leia.nextFloat();
			if (valorCarro < 0) {
				System.out.println("O valor deve ser maior que zero.");
				System.out.println("=====================================");
				System.out.println("");
			}
		} while (valorCarro < 0);

		//DESCONTO ANO
		if (anoCarro <= 2000) {
			System.out.println("O cliente receberá um desconto de 12%!");
			desconto1 = valorCarro * 0.12f;
			totalDesconto += desconto1;
		} else if (anoCarro <= 2010) {
			System.out.println("O cliente receberá um desconto de 7%!");
			desconto1 = valorCarro * 0.07f;
			totalDesconto += desconto1;
		} else if (anoCarro <= 2014) {
			System.out.println("O cliente receberá um desconto de 3%!");
			desconto1 = valorCarro * 0.03f;
			totalDesconto += desconto1;
		}
		
		valorCarro1 = valorCarro - desconto1;
		
		//IDADE
		do {
			System.out.print("Por favor, informe a IDADE do Comprador: ");
			idadeComprador = leia.nextInt();
			if (idadeComprador < 18) {
				System.out.println("O comprador deve ter mais que 18 anos.");
				System.out.println("=====================================");
				System.out.println("");
			}
		} while (idadeComprador < 18);
		
		//DESCONTO IDADE
		if (idadeComprador <= 40) {
			System.out.println("O cliente receberá mais um desconto de 0,5%!");
			desconto2 = valorCarro1 * 0.005f;
			totalDesconto += desconto2;
		} else if (idadeComprador <= 60) {
			System.out.println("O cliente receberá mais um desconto de 1%!");
			desconto2 = valorCarro1 * 0.01f;
			totalDesconto += desconto2;
		} else {
			System.out.println("O cliente receberá mais um desconto de 2%!");
			desconto2 = valorCarro1 * 0.02f;
			totalDesconto += desconto2;
		}
		
		valorCarro2 = valorCarro1 - desconto2;
		totalVendas += valorCarro2;
		descontos = desconto1 + desconto2;
		
		//MAIOR/MENOR DESCONTOS
		if (descontos > maiorDesconto) {
			maiorDesconto = descontos;
		}
		if (descontos < menorDesconto) {
			menorDesconto = descontos;
		}
		
		//RELATÓRIO
		System.out.println("");
		System.out.println("|===================================|");
		System.out.println("O Valor atual do veículo é de:           "+df.format(valorCarro));
		System.out.println("O Desconto pelo ano do veículo é de:     "+df.format(desconto1));
		System.out.println("O Desconto pela idade do comprador é de: "+df.format(desconto2));
		System.out.println("O Valor final do veículo é de:           "+df.format(valorCarro2));
		System.out.println("|===================================|");
		System.out.println("");
		
		//FLAG
		do {
			System.out.println("Deseja continuar? (S/N)");
			flag = leia.next().toUpperCase().charAt(0);
			System.out.println("");
			
		} while (flag != 'S' && flag != 'N');

		if (flag == 'N') {
			break;
		}
		} while(true);
		
		//RELATÓRIO FINAL
		System.out.println("");
		System.out.println("");
		System.out.println("=================================");
		System.out.println("       RELATÓRIO DE VENDAS       ");
		System.out.println("Total de Vendas: " +df.format(totalVendas));
		System.out.println("Total de Descontos: " +df.format(totalDesconto));
		System.out.println("Maior Desconto: " +df.format(maiorDesconto));
		System.out.println("Menor Desconto: " +df.format(menorDesconto));
		
	
		
	leia.close();
		
	}
}
