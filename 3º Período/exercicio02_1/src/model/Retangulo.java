package model;


public class Retangulo {

	public double base;
	public double altura;
	
	public double area() {
		return this.base * this.altura;
	}
	
	public double perimetro() {
		return 2 * (this.base + this.altura);
	}
	
	public double diagonal() {		
		return Math.sqrt(Math.pow(this.base, 2) + Math.pow(this.base, 2));
	}

	@Override
	public String toString() {
		return "Retangulo: base " + base + "cm , altura " + altura + "cm.";
	}
}
