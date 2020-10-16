package model.exceptions;

public class DominioException extends Exception { // Caso use o RuntimeException, você não é obrigado a tratar as exceções ('throws').
	private static final long serialVersionUID = 1L;
	
	public DominioException(String mensagem) {
		super(mensagem); // Permite instanciar a Exceção Personalizada passando uma mensagem.
	}

}
