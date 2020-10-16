package view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reserva;

public class Interface {

	public static void main(String[] args) throws ParseException {
		/*
		 * 'throws': Significa que o m�todo atual (main) PODE lan�ar uma exce��o e n�o
		 * tem que necessariamente tratar essa exce��o. Ao inv�s disso, ele vai PROPAGAR
		 * a exce��o para um outro m�todo que cham�-lo, onde este outro m�todo pode
		 * tratar a exce��o ou propagar novamente para um terceiro m�todo. (Pilha de
		 * chamadas de m�todos)
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Digite o n�mero do quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Digite a data de Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); // Entrada de um texto e convers�o atrav�s do sdf.parse para tipo Date.
		System.out.print("Digite a data de Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next()); // Entrada de um texto e convers�o atrav�s do sdf.parse para tipo Date.

		if (!checkOut.after(checkIn)) { // 'after': Testa se uma data � posterior � outra.
			System.out.println("Erro na reserva! Data de check-out deve ser posterior � data de check-in.");

		} else {
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut); // Instancia��o do objeto com argumentos.
			System.out.println("Reserva: " + reserva); // toString

			System.out.println();
			System.out.println("Atualize a reserva:");
			System.out.print("Digite a data de Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // Entrada de um texto e convers�o atrav�s do sdf.parse para tipo Date.
			System.out.print("Digite a data de Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next()); // Entrada de um texto e convers�o atrav�s do sdf.parse para tipo Date.

			Date agora = new Date(); // Data atual.
			
			if (checkIn.before(agora) || checkOut.before(agora)) { // 'before': Testa se uma data � anterior � outra.
				System.out.println("Erro na reserva! Datas da reserva atualizadas devem ser futuras �s datas originais.");

			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva! Data de check-out deve ser posterior � data de check-in.");

			} else {
				reserva.atualizarDatas(checkIn, checkOut);
				System.out.println("Reserva: " + reserva); // toString
			}
		}

		sc.close();
	}

}
