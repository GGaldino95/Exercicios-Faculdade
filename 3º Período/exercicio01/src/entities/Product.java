package entities;

public class Product {

	public String nome;
	public double price;
	public int quantity;
	
	public double totalValueInStock() {
		return price * quantity;
	}
	
	public void addProducts(int quantity) {
		this.quantity += quantity;
	}

	public void removeProduct(int quantity) {
		this.quantity -= quantity;
	}

	@Override
	public String toString() {
		return "\nDados do produto:\n" 
				+ nome 
				+ ": R$" + String.format("%.2f", price)
				+ ", " 
				+ quantity
				+ " unidades.\nValor total em estoque: R$"
				+ String.format("%.2f", totalValueInStock())
							 + ".";
	}
}
