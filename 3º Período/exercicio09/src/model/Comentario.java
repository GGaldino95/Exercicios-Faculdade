package model;

public class Comentario {

	// Atributos
	private String texto;
	
	// Construtor default
	public Comentario() {
	}

	// Construtor
	public Comentario(String texto) {
		this.texto = texto;
	}

	// Getters e Setters
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
