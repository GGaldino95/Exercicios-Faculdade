package exercicio06;
import java.util.*;
public class Exercicio06_2 {

	public static void main(String[] args) {
		String nome;
		Scanner leia = new Scanner(System.in);
		boolean valido;
		
		for (byte x = 1; x <= 30 ; x++) {
			
			do {
				System.out.println("Digite o nome (FIM p/ encerrar): ");
				nome = leia.nextLine().toUpperCase();
				if (nome.equalsIgnoreCase("fim")) {
					break;
				}
				valido = true;
				if (nome.length() < 15) {
					System.out.println("Nome invalido, digite 15 ou mais caracteres no nome");
					valido = false;
				} else if (nome.charAt(0) == ' ' || nome.charAt( nome.length()-1 ) == ' ') {
					System.out.println("Nome invalido, nao pode ter espaco antes do nome");
					valido = false;
				} else if ( ! nome.contains(" ")) {
					System.out.println("Nome invalido, digite o nome com pelo menos um sobrenome");
					valido = false;
				} else if ( nome.contains("  ")) {
					System.out.println("Nome invalido, digite apenas um espaco entre os nomes");
					valido = false;
				} else {
					for (int z = 0 ; z < nome.length() ; z++) {
						if ( (nome.charAt(z) < 'A' || nome.charAt(z) > 'Z') && nome.charAt(z) != ' ') {
							System.out.println("Nome invalido, digite o nome com apenas letras");
							valido = false;
							break;
						}
					}
				}
			}while( ! valido );
			
			// gerar login e senha
			String login = gerarLogin(nome);
			System.out.println("Login: " + login );
			System.out.println("Senha: " + gerarSenha(login));
			
			leia.close();
		}

	}
	public static String gerarLogin (String pNome) {
		String login;
		login = pNome.substring(0,1);
		for (int x = 1; x < pNome.length() ; x++) {
			if (pNome.charAt(x) == ' ') {
				login = login + pNome.charAt(x+1);
			}
		}
		return login;
	}

	public static String gerarSenha (String pLogin) {
		String senha = "";
		for (int x = 0; x < pLogin.length(); x++) {
			senha = senha + ( (int)pLogin.charAt(x) ) / 10;
		}
		return senha;
	}
}
