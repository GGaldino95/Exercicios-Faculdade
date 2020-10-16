 package view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reserva;

public class Interface {

	public static void main(String[] args) throws ParseException {
		/*
		 * 'throws': Significa que o método atual (main) PODE lançar uma exceção e não
		 * tem que necessariamente tratar essa exceção. Ao invés disso, ele vai PROPAGAR
		 * a exceção para um outro método que chamá-lo, onde este outro método pode
		 * tratar a exceção ou propagar novamente para um terceiro método. (Pilha de
		 * chamadas de métodos)
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Digite o número do quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Digite a data de Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); // Entrada de um texto e conversão através do sdf.parse para tipo Date.
		System.out.print("Digite a data de Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next()); // Entrada de um texto e conversão através do sdf.parse para tipo Date.

		if (!checkOut.after(checkIn)) { // 'after': Testa se uma data é posterior à outra.
			System.out.println("Erro na reserva! Data de check-out deve ser posterior à data de check-in.");

		} else {
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut); // Instanciação do objeto com argumentos.
			System.out.println("Reserva: " + reserva); // toString

			System.out.println();
			System.out.println("Atualize a reserva:");
			System.out.print("Digite a data de Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // Entrada de um texto e conversão através do sdf.parse para tipo Date.
			System.out.print("Digite a data de Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next()); // Entrada de um texto e conversão através do sdf.parse para tipo Date.
			
			String erro = reserva.atualizarDatas(checkIn, checkOut); // Atribuindo à uma variavel String pois o retorno da atualização de datas agora é uma String.
			
			if (erro != null) { 
				System.out.println("Erro: " + erro); // Exibe o erro armazenado na String.
			} else {
				System.out.println("Reserva: " + reserva); // toString
			}
		}

		sc.close();
	}

}
