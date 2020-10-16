package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Comentario;
import model.Postagem;

public class Interface {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comentario c1 = new Comentario("Tenha uma boa viagem!");
		Comentario c2 = new Comentario("Uau, que incr�vel!");
		
		Postagem p1 = new Postagem(
				sdf.parse("21/06/2018 13:05:44"), 			// Data
				"Traveling to New Zealand", 				// T�tulo
				"Estou indo visitar esse lindo pa�s!", 		// Postagem
				12);										// Curtidas
		
		p1.adicionarComentario(c1);
		p1.adicionarComentario(c2);
		System.out.println(p1);
		System.out.println();
		
		Comentario c3 = new Comentario("Boa noite.");
		Comentario c4 = new Comentario("Que a For�a esteja com voc�.");
		
		Postagem p2 = new Postagem(
				sdf.parse("28/07/2018 23:14:19"), 			// Data 
				"Boa noite galera!", 						// T�tulo 
				"Vejo voc�s amanh�.", 						// Postagem
				5);											// Curtidas
		
		p2.adicionarComentario(c3);
		p2.adicionarComentario(c4);
		System.out.println(p2);
		System.out.println();
	}
}
