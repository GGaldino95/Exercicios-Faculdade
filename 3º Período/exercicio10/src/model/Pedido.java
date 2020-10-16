package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.enums.StatusPedido;

public class Pedido {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	// Atributos
	private Date data;
	private StatusPedido status;

	// Associações e Composições
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();

	// Construtor default
	public Pedido() {
	}

	// Construtor
	public Pedido(Date data, StatusPedido status, Cliente cliente) {
		this.data = data;
		this.status = status;
		this.cliente = cliente;
	}

	// Getters e Setters
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Métodos
	public void adicionarItem(ItemPedido item) {
		itens.add(item);
	}
	public void removerItem(ItemPedido item) {
		itens.remove(item);
	}

	public double total() {
		double soma = 0;
		
		for (ItemPedido ip : itens) {
			soma += ip.subTotal();
		}
		
		return soma;
	}

	// toString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data do pedido: ");
		sb.append(sdf.format(data) + "\n");
		sb.append("Status do pedido:");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do pedido: ");
			for (ItemPedido item : itens) {
				sb.append(item + "\n");
			}
		sb.append("Preço total: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
	
}
