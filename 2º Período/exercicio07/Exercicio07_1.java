package exercicio07;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exercicio07_1 {
	public static class Cliente {
		public char ativo;
		public int codCliente;
		public String nomeCliente;
		public float vlrCompra;
		public int anoPrimeiraCompra;
		public boolean emDia;
	}

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		Cliente cliente = new Cliente();
		RandomAccessFile arquivo;
		
		int codClienteChave;
		boolean encontrou;
		char confirmacao;
		
		do {
			do {
				System.out.println("========== INCLUSAO DE CLIENTES ==========");
				System.out.println("Digite o codigo do Cliente: ");
				codClienteChave = leia.nextInt();
					if (codClienteChave == 0) {
						break;
					}
					encontrou = false;
					try {
						arquivo = new RandomAccessFile ("CLIENTES.DAT", "rw");
						while (true) {
							cliente.ativo = 				arquivo.readChar();
							cliente.codCliente = 			arquivo.readInt();
							cliente.nomeCliente = 			arquivo.readUTF();
							cliente.vlrCompra = 			arquivo.readFloat();
							cliente.anoPrimeiraCompra = 	arquivo.readInt();
							cliente.emDia = 				arquivo.readBoolean();
							if (codClienteChave == cliente.codCliente && cliente.ativo == 'S') {
								System.out.println("Codigo ja cadastrado, digite outro valor\n");
								encontrou = true;
								break;
							}
						}
						arquivo.close();
					} catch (EOFException e) {
		    			encontrou = false;
		    		} catch (IOException e) { 
		    			System.out.println("Erro na abertura do arquivo - programa sera' finalizado");
		    			System.exit(0);
		    		}			
			} while(encontrou);
			
			if (codClienteChave == 0) {
				System.out.println("===== PROGRAMA ENCERRADO =====");
				break;
			}
			
			cliente.ativo = 'S';
			cliente.codCliente = codClienteChave;
			leia.nextLine(); //buffer
			System.out.println("Digite o nome do cliente: ");
			cliente.nomeCliente = leia.nextLine();
			System.out.println("Digite o valor da compra: ");
			cliente.vlrCompra = leia.nextFloat();
			System.out.println("Digite o ano da primeira compra: ");
			cliente.anoPrimeiraCompra = leia.nextInt();
			System.out.println("O cliente esta em dia? ");
			cliente.emDia = leia.nextBoolean();
			
			do {
				System.out.println("\n Confirma gravacao dos dados? (S/N)");
				confirmacao = leia.next().charAt(0);
					if (Character.toUpperCase(confirmacao) == 'S') {
						try {
							arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
							arquivo.seek(arquivo.length());
							arquivo.writeChar(cliente.ativo);
							arquivo.writeInt(cliente.codCliente);
							arquivo.writeUTF(cliente.nomeCliente);
							arquivo.writeFloat(cliente.vlrCompra);
							arquivo.writeInt(cliente.anoPrimeiraCompra);
							arquivo.writeBoolean(cliente.emDia);
							arquivo.close();
							System.out.println("Dados gravados com sucesso!");
						} catch (IOException e) { 
		    		    	System.out.println("Erro na gravacao do registro - programa sera finalizado");
		    		    	System.exit(0);
						}
					}
			} while(confirmacao != 'S' && confirmacao != 'N');
			leia.nextLine();
		} while(cliente.codCliente != 0);
		
		leia.close();
	}

}
