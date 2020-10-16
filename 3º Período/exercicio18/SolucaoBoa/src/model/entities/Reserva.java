package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DominioException;

public class Reserva {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	// 'static' pra que não seja instanciado um novo sdf pra cada objeto 'Reserva' que a aplicação tiver.
	
	// Atributos
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	// Construtor default (vazio)
	public Reserva() {
	}

	// Construtor com Argumentos
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) throws DominioException {
		if (!checkOut.after(checkIn)) // Programação Defensiva: Lançar Exceções dentro de um Construtor.
			throw new DominioException("A data de check-out deve ser posterior à data de check-in.");
		
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// Getters e Setters
	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	
	/* Não irá existir o setCheckIn() pois não iremos permitir a mudança dessas datas arbitrariamente. */

	public Date getCheckOut() {
		return checkOut;
	}

	/* Não irá existir o setCheckOut() pois não iremos permitir a mudança dessas datas arbitrariamente. */
	
	// Métodos
	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime(); // getTime(): Retorna a quantidade de milisegundos da data.
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); // Conversão de milisegundos para dias.
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut) throws DominioException { 
		// 'throws': Necessário pois o método não irá tratar a exceção, e sim apenas lançar a exceção para que o método 'main' trate-a.
		
		Date agora = new Date(); // Data atual.
		
		if (checkIn.before(agora) || checkOut.before(agora)) { // 'before': Testa se uma data é anterior à outra.
			// LANÇAMENTO DE EXCEÇÃO JÁ EXISTENTE
			// throw new IllegalArgumentException("As datas de atualização da reserva precisam ser posteriores às datas originais.");
			// Lançamento de exceção do tipo IllegalArgumentException com uma mensagem de erro.
			
			// LANÇAMENTO DE EXCEÇÃO PERSONALIZADA
			throw new DominioException("As datas de atualização da reserva precisam ser posteriores às datas originais.");
		} 
		
		if (!checkOut.after(checkIn)) {
			// LANÇAMENTO DE EXCEÇÃO JÁ EXISTENTE
			// throw new IllegalArgumentException("A data de check-out deve ser posterior à data de check-in.");
			// Lançamento de exceção do tipo IllegalArgumentException com uma mensagem de erro.
			
			// LANÇAMENTO DE EXCEÇÃO PERSONALIZADA
			throw new DominioException("A data de check-out deve ser posterior à data de check-in.");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// toString
	@Override
	public String toString() {
		return "Quarto " + numQuarto 
				+ ", check-in: " + sdf.format(checkIn) 
				+ ", check-out: " + sdf.format(checkOut) 
				+ ", " + duracao() + "noites.";
	}
}
