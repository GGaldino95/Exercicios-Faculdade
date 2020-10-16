package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DominioException;

public class Reserva {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	// 'static' pra que n�o seja instanciado um novo sdf pra cada objeto 'Reserva' que a aplica��o tiver.
	
	// Atributos
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	// Construtor default (vazio)
	public Reserva() {
	}

	// Construtor com Argumentos
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) throws DominioException {
		if (!checkOut.after(checkIn)) // Programa��o Defensiva: Lan�ar Exce��es dentro de um Construtor.
			throw new DominioException("A data de check-out deve ser posterior � data de check-in.");
		
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
	
	/* N�o ir� existir o setCheckIn() pois n�o iremos permitir a mudan�a dessas datas arbitrariamente. */

	public Date getCheckOut() {
		return checkOut;
	}

	/* N�o ir� existir o setCheckOut() pois n�o iremos permitir a mudan�a dessas datas arbitrariamente. */
	
	// M�todos
	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime(); // getTime(): Retorna a quantidade de milisegundos da data.
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); // Convers�o de milisegundos para dias.
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut) throws DominioException { 
		// 'throws': Necess�rio pois o m�todo n�o ir� tratar a exce��o, e sim apenas lan�ar a exce��o para que o m�todo 'main' trate-a.
		
		Date agora = new Date(); // Data atual.
		
		if (checkIn.before(agora) || checkOut.before(agora)) { // 'before': Testa se uma data � anterior � outra.
			// LAN�AMENTO DE EXCE��O J� EXISTENTE
			// throw new IllegalArgumentException("As datas de atualiza��o da reserva precisam ser posteriores �s datas originais.");
			// Lan�amento de exce��o do tipo IllegalArgumentException com uma mensagem de erro.
			
			// LAN�AMENTO DE EXCE��O PERSONALIZADA
			throw new DominioException("As datas de atualiza��o da reserva precisam ser posteriores �s datas originais.");
		} 
		
		if (!checkOut.after(checkIn)) {
			// LAN�AMENTO DE EXCE��O J� EXISTENTE
			// throw new IllegalArgumentException("A data de check-out deve ser posterior � data de check-in.");
			// Lan�amento de exce��o do tipo IllegalArgumentException com uma mensagem de erro.
			
			// LAN�AMENTO DE EXCE��O PERSONALIZADA
			throw new DominioException("A data de check-out deve ser posterior � data de check-in.");
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
