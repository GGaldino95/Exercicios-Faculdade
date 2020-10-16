package view;

import java.util.Scanner;

import model.Retangulo;

public class Interface {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		Retangulo retangulo = new Retangulo();
		
		System.out.print("Digite a base do retangulo: ");
		retangulo.base = sc.nextDouble();
		System.out.print("Digite a altura do retangulo: ");
		retangulo.altura = sc.nextDouble();
		
		System.out.println("");
		System.out.println(retangulo);
		System.out.println("Perimetro: "+retangulo.perimetro()+"cm");
		System.out.println("Area: "+retangulo.area()+"cm²");
		System.out.println("Diagonal: "+String.format("%.2f", retangulo.diagonal())+"cm²");
		
		sc.close();
	}
}
