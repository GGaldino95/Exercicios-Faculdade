package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Comentario;
import model.Postagem;

public class Interface {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comentario c1 = new Comentario("Tenha uma boa viagem!");
		Comentario c2 = new Comentario("Uau, que incrível!");
		
		Postagem p1 = new Postagem(
				sdf.parse("21/06/2018 13:05:44"), 			// Data
				"Traveling to New Zealand", 				// Título
				"Estou indo visitar esse lindo país!", 		// Postagem
				12);										// Curtidas
		
		p1.adicionarComentario(c1);
		p1.adicionarComentario(c2);
		System.out.println(p1);
		System.out.println();
		
		Comentario c3 = new Comentario("Boa noite.");
		Comentario c4 = new Comentario("Que a Força esteja com você.");
		
		Postagem p2 = new Postagem(
				sdf.parse("28/07/2018 23:14:19"), 			// Data 
				"Boa noite galera!", 						// Título 
				"Vejo vocês amanhã.", 						// Postagem
				5);											// Curtidas
		
		p2.adicionarComentario(c3);
		p2.adicionarComentario(c4);
		System.out.println(p2);
		System.out.println();
	}
}
