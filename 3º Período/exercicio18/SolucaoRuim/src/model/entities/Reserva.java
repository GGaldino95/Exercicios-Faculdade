package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
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
	
	public String atualizarDatas(Date checkIn, Date checkOut) {
		
		Date agora = new Date(); // Data atual.
		
		if (checkIn.before(agora) || checkOut.before(agora)) { // 'before': Testa se uma data é anterior à outra.
			return "Datas da reserva atualizadas devem ser futuras às datas originais.";

		} 
		
		if (!checkOut.after(checkIn)) {
			return "Data de check-out deve ser posterior à data de check-in.";

		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; // Se chegar aqui, quer dizer que não deu nenhum erro, logo, não precisa retornar nenhuma mensagem.
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
