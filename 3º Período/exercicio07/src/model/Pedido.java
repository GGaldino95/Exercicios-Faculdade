package model;

import java.util.Date;
import model.enums.StatusPedido;

public class Pedido {

	private Integer id;
	private Date data;
	private StatusPedido status;
	
	// Construtor default
	public Pedido () {
	}

	// Construtor
	public Pedido(Integer id, Date data, StatusPedido status) {
		this.id = id;
		this.data = data;
		this.status = status;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

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

	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", status=" + status + "]";
	}
}
