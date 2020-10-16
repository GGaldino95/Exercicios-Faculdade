package view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DominioException;

public class Interface {

	public static void main(String[] args) {
		/*
		 * 'throws': Significa que o m�todo atual (main) PODE lan�ar uma exce��o e n�o
		 * tem que necessariamente tratar essa exce��o. Ao inv�s disso, ele vai PROPAGAR
		 * a exce��o para um outro m�todo que cham�-lo, onde este outro m�todo pode
		 * tratar a exce��o ou propagar novamente para um terceiro m�todo. (Pilha de
		 * chamadas de m�todos)
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Digite o n�mero do quarto: ");
			int numQuarto = sc.nextInt();
			System.out.print("Digite a data de Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); 
			System.out.print("Digite a data de Check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next()); 

			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut); 
			System.out.println("Reserva: " + reserva); 

			System.out.println();
			System.out.println("Atualize a reserva:");
			System.out.print("Digite a data de Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Digite a data de Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next()); 

			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva); 
			
		} catch (ParseException e) {
			System.out.println("Formato de data inv�lido.");
		} catch (DominioException e) { // Exce��o personalizada sendo tratada.
			System.out.println("Erro na reserva: " + e.getMessage()); // 'getMessage()': � a mensagem passada no 'throw new' dentro do m�todo 'atualizarDatas'.
		}
		
		sc.close();
	}

}
