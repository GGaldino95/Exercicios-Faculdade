package model;

public class Aluno {

	public double nota1;
	public double nota2;
	public double nota3;

	public double notaFinal() {
		return nota1 + nota2 + nota3;
	}
	
	public double pontuacaoFaltante() {
		return 60 - (nota1+nota2+nota3);
	}
}
