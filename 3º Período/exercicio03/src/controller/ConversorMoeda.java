package controller;

public class ConversorMoeda {

	public static double calcularValor(double dolar, double cotacao) {
		return dolar * cotacao + (dolar * cotacao) * 0.06;
	}
}
