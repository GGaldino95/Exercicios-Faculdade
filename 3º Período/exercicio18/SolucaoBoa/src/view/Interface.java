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
		 * 'throws': Significa que o método atual (main) PODE lançar uma exceção e não
		 * tem que necessariamente tratar essa exceção. Ao invés disso, ele vai PROPAGAR
		 * a exceção para um outro método que chamá-lo, onde este outro método pode
		 * tratar a exceção ou propagar novamente para um terceiro método. (Pilha de
		 * chamadas de métodos)
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Digite o número do quarto: ");
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
			System.out.println("Formato de data inválido.");
		} catch (DominioException e) { // Exceção personalizada sendo tratada.
			System.out.println("Erro na reserva: " + e.getMessage()); // 'getMessage()': É a mensagem passada no 'throw new' dentro do método 'atualizarDatas'.
		}
		
		sc.close();
	}

}
