package model.exceptions;

public class DominioException extends Exception { // Caso use o RuntimeException, voc� n�o � obrigado a tratar as exce��es ('throws').
	private static final long serialVersionUID = 1L;
	
	public DominioException(String mensagem) {
		super(mensagem); // Permite instanciar a Exce��o Personalizada passando uma mensagem.
	}

}
