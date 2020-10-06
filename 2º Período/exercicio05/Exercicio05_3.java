package exercicio05;
import java.util.Scanner;
public class Exercicio05_3 {

	public static void main(String[] args) {
		String horarioInicio;
		String horarioFinal;
		float vlrChamada;
		float vlrConta = 0;
		float vlrMinuto;
		int duracao;
		Scanner leia = new Scanner(System.in);
		int horaIni,minIni,horaFim,minFim; 
		boolean valido;
		
		// entrada de dados
		do {
			do {
				System.out.println("Digite o horario de inicio (HH:MM - SAIR p finalizar): ");
				horarioInicio = leia.next();
				if (horarioInicio.equalsIgnoreCase("sair")) {
					break;
				}
				valido = horaEhValida(horarioInicio);
				if ( ! valido ) {
					System.out.println("Horario invalido, digite entre 00:00 e 23:59");
				}
			}while( ! valido );
			
			if (horarioInicio.equalsIgnoreCase("sair")) {
				break;
			}
			
			do {
				System.out.println("Digite o horario de final (HH:MM): ");
				horarioFinal = leia.next();
				valido = horaEhValida(horarioFinal);
				if ( ! valido ) {
					System.out.println("Horario invalido, digite entre 00:00 e 23:59");
				}
			}while( ! valido );
			
			horaIni = Integer.parseInt( horarioInicio.substring(0,2) );
			minIni  = Integer.parseInt( horarioInicio.substring(3) );
			horaFim = Integer.parseInt( horarioFinal.substring(0,2) );
			minFim  = Integer.parseInt( horarioFinal.substring(3) );
			if (horaFim < horaIni || horaFim == horaIni && minFim <= minIni) {
				System.out.println("Faixa invalida, horario final deve ser maior que Inicial");		
			} else {
				// calculos 
				if (horaIni < 6) {
					vlrMinuto = 0.10f;
				}else if (horaIni < 8) {
					vlrMinuto = 0.15f;
				}else if (horaIni < 18) {
					vlrMinuto = 0.20f;
				}else {
					vlrMinuto = 0.15f;
				}
				
				duracao = (horaFim - horaIni)*60 + minFim - minIni;
				vlrChamada = duracao * vlrMinuto;
				vlrConta = vlrConta + vlrChamada;
				System.out.println("Valor da chamada: " + vlrChamada);
			}
		}while( ! horarioInicio.equalsIgnoreCase("sair") );

		System.out.println("Valor da conta: " + vlrConta);
		
		leia.close();
	}

	public static boolean horaEhValida (String horario) {
		if (horario.length() != 5 || horario.charAt(2) != ':') {
			return false;
		}
		int hora, minuto;
			
		try {
			hora = Integer.parseInt( horario.substring(0,2) );
			minuto = Integer.parseInt( horario.substring(3) );
		}catch (NumberFormatException e) {
			return false;
		}		
		if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59) {
			return false;
		}
			
		return true;		
	}

}
