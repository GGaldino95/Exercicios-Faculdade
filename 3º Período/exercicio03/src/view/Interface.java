package view;

import java.util.Scanner;

import controller.ConversorMoeda;

public class Interface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double cotacao;
		double dolar;

		System.out.print("Qual o valor do dolar? ");
		cotacao = sc.nextDouble();
		System.out.print("Quantos dolares serao comprados? ");
		dolar = sc.nextDouble();

		System.out.println("Total a ser pago em reais: R$" 
				+ String.format("%.2f", ConversorMoeda.calcularValor(dolar, cotacao)));
		sc.close();
	}

}
