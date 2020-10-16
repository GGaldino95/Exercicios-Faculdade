package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Postagem {
	
	// CONSTANTES
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss"); 
	/* Declara-se como static para não haver cópias do objeto 'sdf' para cada objeto 'Postagem' da aplicação. */
	
	// Atributos
	private Date data;
	private String titulo;
	private String conteudo;
	private Integer curtidas;
	
	// Lista
	private List<Comentario> comentarios = new ArrayList<>();
	
	// Construtor default
	public Postagem() {
	}

	// Construtor
	public Postagem(Date data, String titulo, String conteudo, Integer curtidas) {
		this.data = data;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.curtidas = curtidas;
	}

	// Getters e Setters
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Integer getCurtidas() {
		return curtidas;
	}
	public void setCurtidas(Integer curtidas) {
		this.curtidas = curtidas;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}
	/*OBS: Não existe a função setComentarios pois a lista já foi instanciada como vazia, 
	 *e você só poderá acrescentar comentários na lista pelos métodos de adicionar e remover comentários.
	 *Caso o setComentarios existisse, ele faria a substituição da lista vazia por uma outra lista.*/
	
	// Métodos
	public void adicionarComentario(Comentario comentario) {
		comentarios.add(comentario);
	}
	public void removerCOmentario(Comentario comentario) {
		comentarios.remove(comentario);
	}

	@Override
	public String toString() {
		// return titulo + "\n" + curtidas + " - " + data + "\n" + conteudo + "\nComentários:\n" + comentarios + "]";
		// ^ Custa muita memória para o programa pois é necessário muitas concatenações. A forma correta de fazer seria através do StringBuilder.
		
		// StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append(titulo + "\n");				// '\n' = Quebra de linha.
		sb.append(curtidas);
		sb.append(" Curtidas - ");
		sb.append(sdf.format(data) + "\n");
		sb.append(conteudo + "\n");
		sb.append("Comentários:\n");
		for (Comentario c : comentarios) {		// "Para cada comentario 'c' na existente lista 'comentarios':"
			sb.append(c.getTexto() + "\n");		// Imprima o comentário percorrido da lista.
		}
		
		return sb.toString(); // Retorno
	}
}
