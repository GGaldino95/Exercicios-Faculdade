package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.enums.NivelTrabalhador;

public class Trabalhador {
	
	// Atributos
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	// Associações
	private Departamento departamento;
	private List<Contrato> contratos = new ArrayList<>(); // Precisa ser inicializada.
	
	// Construtor Default
	public Trabalhador() {
	}

	// Construtor
	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) { // Não incluir listas no construtor.
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}
	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

		
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}
	/*OBS: Não existe a função setContratos pois a lista já foi instanciada como vazia, 
	 *e você só poderá acrescentar contratos na lista pelos métodos de adicionar e remover contratos.
	 *Caso o setContratos existisse, ele faria a substituição da lista vazia por uma outra lista.*/

	// Métodos
	public void AdicionarContrato(Contrato contrato) {
		contratos.add(contrato);
	}	
	public void RemoverContrato(Contrato contrato) {
		contratos.remove(contrato);
	}
	
	public Double calcularGanho(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance(); 			// Instanciação da data que fará as comparações necessárias.
		
		for (Contrato c :  contratos) { 				// "Para cada contrato 'c' existente na lista 'contratos':"
			cal.setTime(c.getData());					// Definindo a data de 'cal' como a data do contrato atual percorrido.
			int c_ano = cal.get(Calendar.YEAR);			// Definindo 'c_ano' com o ano do contrato atual.
			int c_mes = 1 + cal.get(Calendar.MONTH);	// Definindo 'c_mes' com o mês do contrato atual.
														// == OBS!: Soma-se 1 porque o Calendar conta o mês a partir de 0. ==
			
			if (ano == c_ano && mes == c_mes)			// Comparando se o ano e mês pesquisados (nos parâmetros) equivalem à data da lista.
				soma += c.valorTotal();
		}
		
		return soma;
	}
	
	// toString
	@Override
	public String toString() {
		return "Nome: " + nome + "\n Departamento: " + nivel + "\n Ganho: " + salarioBase;
	}
	
	

}
