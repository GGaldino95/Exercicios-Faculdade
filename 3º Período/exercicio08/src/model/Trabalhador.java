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
	
	// Associa��es
	private Departamento departamento;
	private List<Contrato> contratos = new ArrayList<>(); // Precisa ser inicializada.
	
	// Construtor Default
	public Trabalhador() {
	}

	// Construtor
	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) { // N�o incluir listas no construtor.
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
	/*OBS: N�o existe a fun��o setContratos pois a lista j� foi instanciada como vazia, 
	 *e voc� s� poder� acrescentar contratos na lista pelos m�todos de adicionar e remover contratos.
	 *Caso o setContratos existisse, ele faria a substitui��o da lista vazia por uma outra lista.*/

	// M�todos
	public void AdicionarContrato(Contrato contrato) {
		contratos.add(contrato);
	}	
	public void RemoverContrato(Contrato contrato) {
		contratos.remove(contrato);
	}
	
	public Double calcularGanho(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance(); 			// Instancia��o da data que far� as compara��es necess�rias.
		
		for (Contrato c :  contratos) { 				// "Para cada contrato 'c' existente na lista 'contratos':"
			cal.setTime(c.getData());					// Definindo a data de 'cal' como a data do contrato atual percorrido.
			int c_ano = cal.get(Calendar.YEAR);			// Definindo 'c_ano' com o ano do contrato atual.
			int c_mes = 1 + cal.get(Calendar.MONTH);	// Definindo 'c_mes' com o m�s do contrato atual.
														// == OBS!: Soma-se 1 porque o Calendar conta o m�s a partir de 0. ==
			
			if (ano == c_ano && mes == c_mes)			// Comparando se o ano e m�s pesquisados (nos par�metros) equivalem � data da lista.
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
