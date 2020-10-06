package trabalho01;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Moto {
	
	static String vetMarcas[] = {"YAMAHA" , "HONDA" , "SUZUKI" , "KAWASAKI" , "DUCATI" , "HARLEY-DAVIDSON" , "BMW" , "KTM" , "TRIUMPH" , "BUELL"},
				  vetOrigens[] = {"JAPÃO" , "JAPÃO" , "JAPÃO" , "JAPÃO" , "ITÁLIA" , "EUA" , "ALEMANHA" , "AUSTRIA" , "INGLATERRA" , "EUA"};

	char ativo;
	String codMoto;
	String marca;
	String modelo;
	String origem;
	String estilo;
	int cilindros;
	int cilindrada;
	int potencia;
	float peso;
	float preco;
	String mesAnoFab;
	
	boolean valido;

	public long pesquisarMoto(String codMotoPesq) {	
		// metodo para localizar um registro no arquivo em disco
		long posicaoCursorArquivo = 0;
		try { 
			RandomAccessFile arqMoto = new RandomAccessFile("MOTOS.DAT", "rw");
			while (true) {
				posicaoCursorArquivo  = arqMoto.getFilePointer();	// posicao do inicio do registro no arquivo
				ativo		= arqMoto.readChar();
				codMoto   	= arqMoto.readUTF();
				marca   	= arqMoto.readUTF();
				modelo      = arqMoto.readUTF();
				origem 		= arqMoto.readUTF();
				estilo      = arqMoto.readUTF();
				cilindros 	= arqMoto.readInt();
				cilindrada 	= arqMoto.readInt();
				potencia 	= arqMoto.readInt();
				peso 		= arqMoto.readFloat();
				preco 		= arqMoto.readFloat();
				mesAnoFab 	= arqMoto.readUTF();
				
				
				if ( codMotoPesq.equals(codMoto) && ativo == 'S') {
					arqMoto.close();
					return posicaoCursorArquivo;
				}
			}
		}catch (EOFException e) {
			return -1; // registro nao foi encontrado
		}catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
			System.exit(0);
			return -1;
		}
	}
	
	public void salvarMoto() {	
		// metodo para incluir um novo registro no final do arquivo em disco
		try {
			RandomAccessFile arqMoto = new RandomAccessFile("MOTOS.DAT", "rw");	
			arqMoto.seek(arqMoto.length());  // posiciona o ponteiro no final do arquivo (EOF)
			arqMoto.writeChar(ativo);
			arqMoto.writeUTF(codMoto);
			arqMoto.writeUTF(marca);
			arqMoto.writeUTF(modelo);
			arqMoto.writeUTF(origem);
			arqMoto.writeUTF(estilo);
			arqMoto.writeInt(cilindros);
			arqMoto.writeInt(cilindrada);
			arqMoto.writeInt(potencia);
			arqMoto.writeFloat(peso);
			arqMoto.writeFloat(preco);
			arqMoto.writeUTF(mesAnoFab);
			arqMoto.close();
			System.out.println("Dados gravados com sucesso !\n");
		}catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
			System.exit(0);
		}
	}

	public void desativarMoto(long posicao)	{    
		// metodo para alterar o valor do campo ATIVO para N, tornando assim o registro excluido
		try {
			RandomAccessFile arqMoto = new RandomAccessFile("MOTOS.DAT", "rw");			
			arqMoto.seek(posicao);
			arqMoto.writeChar('N');   // desativar o registro antigo
			arqMoto.close();
		}catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
			System.exit(0);
		}
	}
	
	// ***********************   INCLUSAO   *****************************
		public void incluir() {
			String codMotoChave;
			char confirmacao;
			long posicaoRegistro;

			do {
				do {
					Main.leia.nextLine();
					System.out.println("\n ***************  INCLUSAO DE MOTOS  ***************** ");
					System.out.print("Digite o codigo da Moto (FIM para encerrar)...: ");
					codMotoChave = Main.leia.nextLine();
					if (codMotoChave.equals("FIM")) {
						break;
					}
					posicaoRegistro = pesquisarMoto(codMotoChave);

					if (posicaoRegistro >= 0) {
						System.out.println("Codigo ja cadastrado, digite outro valor\n");
					}
				}while (posicaoRegistro >= 0);

				if (codMotoChave.equals("FIM")) {
					break;
				}

				ativo = 'S';
				codMoto = codMotoChave;
				System.out.print("Digite a marca da moto.........................: ");
				marca = Main.leia.nextLine();
				System.out.print("Digite o modelo da moto........................: ");
				modelo = Main.leia.nextLine();	    	
				System.out.print("Digite a origem da moto........................: ");
				origem = Main.leia.nextLine();
				System.out.print("Digite o estilo da moto........................: ");
				estilo = Main.leia.nextLine();
				System.out.print("Digite os cilindros da moto....................: ");
				cilindros = Main.leia.nextInt();
				System.out.print("Digite a cilindrada da moto....................: ");
				cilindrada = Main.leia.nextInt();
				System.out.print("Digite a potencia da moto......................: ");
				potencia = Main.leia.nextInt();
				System.out.print("Digite o peso da moto..........................: ");
				peso = Main.leia.nextFloat();
				System.out.print("Digite o preco da moto.........................: ");
				preco = Main.leia.nextFloat();
				Main.leia.nextLine(); //buffer
				
				do {
					System.out.print("Digite o ano de fabricacao da moto (MM/AAAA)...: ");
					mesAnoFab = Main.leia.nextLine();
					valido = consistirMesAnoFab(mesAnoFab);
				} while(!valido);
			
				do {
					System.out.print("\nConfirma a gravacao dos dados (S/N) ? ");
					confirmacao = Main.leia.next().charAt(0);
					if (confirmacao == 'S') {
						salvarMoto();
					}
				} while(confirmacao != 'S' && confirmacao != 'N');

			} while(!codMoto.equals("FIM"));	    
		}
		
		//************************  ALTERACAO  *****************************
				public void alterar() {
					String codMotoChave;
					char confirmacao;
					long posicaoRegistro = 0;
					byte opcao;

					do {
							Main.leia.nextLine(); //buffer
							
						do {
							System.out.println("\n ***************  ALTERACAO DE MOTOS  ***************** ");
							System.out.print("Digite o codigo da moto que deseja alterar( FIM para encerrar ): ");
							codMotoChave = Main.leia.nextLine().toUpperCase();
							if (codMotoChave.equals("FIM")) {
								break;
							}

							posicaoRegistro = pesquisarMoto(codMotoChave);
							if (posicaoRegistro == -1) {
								System.out.println("Moto nao cadastrada no arquivo, digite outro valor\n");
							}
						}while (posicaoRegistro == -1);

						if (codMotoChave.equals("FIM")) {
							break;
						}

						ativo = 'S';

						do { 
							System.out.println("[ 1 ] Marca da moto ..............: " + marca);
							System.out.println("[ 2 ] Modelo da moto .............: " + modelo);
							System.out.println("[ 3 ] Origem da moto .............: " + origem);
							System.out.println("[ 4 ] Estilo da moto .............: " + estilo);
							System.out.println("[ 5 ] Cilindros da moto ..........: " + cilindros);
							System.out.println("[ 6 ] Cilindradas da moto ........: " + cilindrada);
							System.out.println("[ 7 ] Potencia da moto ...........: " + potencia);
							System.out.println("[ 8 ] Peso da moto ...............: " + peso);
							System.out.println("[ 9 ] Preço da moto ..............: " + preco);
							System.out.println("[10 ] Data de fabricacao da moto .: " + mesAnoFab);
							System.out.println("[ 0 ] SAIR .......................: ");

							do{
								System.out.println("Digite o número do campo que deseja alterar (0 para finalizar as alterações): ");
								opcao = Main.leia.nextByte();
							} while(opcao < 0 || opcao > 10);
							
							Main.leia.nextLine(); //buffer
							
							switch (opcao) {
							case 1:
								Main.leia.nextLine();
								System.out.print  ("Atualize a marca da moto...................: ");
								marca = Main.leia.nextLine();
								break;
							case 2: 
								Main.leia.nextLine();
								System.out.print  ("Atualize o modelo da moto..................: ");
								modelo = Main.leia.nextLine();
								break;
							case 3:
								System.out.print  ("Atualize a origem da moto..................: ");
								origem = Main.leia.nextLine();
								break;
							case 4: 
								System.out.print  ("Atualize o estilo da moto..................: ");
								estilo = Main.leia.nextLine();
								break;
							case 5:
								System.out.println("Atualize os cilindros da moto...................: ");
								cilindros = Main.leia.nextInt();
								break;
							case 6:
								System.out.println("Atualize as cilindradas da moto...................: ");
								cilindrada = Main.leia.nextInt();
								break;
							case 7:
								System.out.println("Atualize a potencia da moto...................: ");
								potencia = Main.leia.nextInt();
								break;
							case 8:
								System.out.println("Atualize o peso da moto...................: ");
								peso = Main.leia.nextFloat();
								break;
							case 9:
								System.out.println("Atualize o preco da moto...................: ");
								preco = Main.leia.nextFloat();
								break;
							case 10:
								do {
									System.out.println("Atualize a data de fabricacao da moto...................: ");
									mesAnoFab = Main.leia.next();
									valido = consistirMesAnoFab(mesAnoFab);
								} while(!valido);
									break;
							}
							System.out.println();
						} while(opcao != 0);  		

						do {
							System.out.print("\nConfirma a alteracao dos dados (S/N) ? ");
							confirmacao = Main.leia.next().charAt(0);
							if (confirmacao == 'S') {
								desativarMoto(posicaoRegistro);
								salvarMoto();
								System.out.println("Dados gravados com sucesso !\n");	
							}
						} while(confirmacao != 'S' && confirmacao != 'N');

					} while(!codMoto.equals("FIM"));
				}
				
				//************************  CONSULTA  *****************************
				public void consultar() 	{
					RandomAccessFile arqMoto;
					byte opcao;
					String codMotoChave;
					long posicaoRegistro;

					do {
						do {
							System.out.println(" ***************  CONSULTA DE MOTOS  ***************** ");
							System.out.println(" [1] CONSULTAR APENAS 1 MOTO ");
							System.out.println(" [2] LISTA DE TODAS AS MOTOS ");
							System.out.println(" [0] SAIR");
							System.out.print("\nDigite a opcao desejada: ");
							opcao = Main.leia.nextByte();
							if (opcao < 0 || opcao > 2) {
								System.out.println("opcao Invalida, digite novamente.\n");
							}
						} while(opcao < 0 || opcao > 2);

						switch (opcao) {
						case 0:
							System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
							break;

						case 1:  // consulta de um unico codigo
							Main.leia.nextLine();  // limpa buffer de memoria
							System.out.print("Digite o Codigo da Moto: ");
							codMotoChave = Main.leia.nextLine();

							posicaoRegistro = pesquisarMoto(codMotoChave);
							if (posicaoRegistro == -1) {
								System.out.println("Matricula nao cadastrada no arquivo \n");
							} else {
								imprimirCabecalho();
								imprimirMoto();
								System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
								Main.leia.nextLine();
							}

							break;

						case 2:  // imprime todos os alunos
							try { 
								arqMoto = new RandomAccessFile("MOTOS.DAT" , "rw");
								imprimirCabecalho();
								while (true) {
									ativo		= arqMoto.readChar();
									codMoto   	= arqMoto.readUTF();
									marca   	= arqMoto.readUTF();
									modelo      = arqMoto.readUTF();
									origem 		= arqMoto.readUTF();
									estilo      = arqMoto.readUTF();
									cilindros 	= arqMoto.readInt();
									cilindrada 	= arqMoto.readInt();
									potencia 	= arqMoto.readInt();
									peso 		= arqMoto.readFloat();
									preco 		= arqMoto.readFloat();
									mesAnoFab 	= arqMoto.readUTF();
									if ( ativo == 'S') {
										imprimirMoto();
									}
								}
								//    arqMoto.close();
							} catch (EOFException e) {
								System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
								Main.leia.nextLine();
								codMotoChave = Main.leia.nextLine();
							} catch (IOException e) { 
								System.out.println("Erro na abertura do arquivo - programa sera finalizado");
								System.exit(0);
							}
							break;
						}	

					} while (opcao != 0);
				}
				
				//************************  EXCLUSAO  *****************************
				public void excluir() {
					String codMotoChave;
					char confirmacao;
					long posicaoRegistro = 0;

					do {
						do {
							Main.leia.nextLine();
							System.out.println(" ***************  EXCLUSAO DE MOTOS  ***************** ");
							System.out.print("Digite o codigo da Moto que deseja excluir ( FIM para encerrar ): ");
							codMotoChave = Main.leia.nextLine();
							if (codMotoChave.equals("FIM")) {
								break;
							}

							posicaoRegistro = pesquisarMoto(codMotoChave);
							if (posicaoRegistro == -1) {
								System.out.println("Codigo nao cadastrada no arquivo, digite outro valor\n");
							}
						}while (posicaoRegistro == -1);

						if (codMotoChave.equals("FIM")) {
							System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
							break;
						}
						
						System.out.println("Codigo da moto...............: " + codMoto);
						System.out.println("Marca da moto................: " + marca);
						System.out.println("Modelo da moto...............: " + modelo);
						System.out.println("Origem da moto...............: " + origem);
						System.out.println("Estilo da moto...............: " + estilo);
						System.out.println("Cilindros da moto............: " + cilindros);
						System.out.println("Cilindrada da moto...........: " + cilindrada);
						System.out.println("Potencia da moto.............: " + potencia);
						System.out.println("Peso da moto.................: " + peso);
						System.out.println("Preco da moto................: " + preco);
						System.out.println("Data de fabricacao da moto...: " + mesAnoFab);
						System.out.println();

						do {
							System.out.print("\nConfirma a exclusao desta moto (S/N) ? ");
							confirmacao = Main.leia.next().charAt(0);
							if (confirmacao == 'S') {
								desativarMoto(posicaoRegistro);
							}
						} while(confirmacao != 'S' && confirmacao != 'N');

					} while(!codMotoChave.equals("FIM"));
			}
				
				public void imprimirCabecalho() {
					System.out.println("--CODIGO MOTO--  --MARCA--  --MODELO--  --ORIGEM--  --ESTILO-- "
							+ "--CILINDROS--  --CILINDRADAS--  --POTENCIA--  --PESO--  --PRECO--  "
							+ "--DATA DE FABRICACAO--");
				}
				
				public void imprimirMoto() {
					System.out.println(formatarString(codMoto, 15) + "  " +
									   formatarString(marca, 9) + "  " + 
									   formatarString(modelo, 10) + "  " + 
									   formatarString(origem, 10) + "  " +
									   formatarString(estilo, 10) + "  " +
									   formatarString(String.valueOf(cilindros), 13) + "  " +
									   formatarString(String.valueOf(cilindrada), 15) + "  " +
									   formatarString(String.valueOf(potencia), 12) + "  " +
									   formatarString(String.valueOf(peso), 8) + "  " +
									   formatarString(String.valueOf(preco), 9) + "  " +
									   formatarString(mesAnoFab, 22)); 
				}

				public static String formatarString (String texto, int tamanho) {	
					// retorna uma string com o numero de caracteres passado como parametro em TAMANHO
					if (texto.length() > tamanho) {
						texto = texto.substring(0,tamanho);
					}else{
						while (texto.length() < tamanho) {
							texto = texto + " ";
						}
					}
					return texto;
				}
				
				//========================= METODOS DE VALIDACAO ===============================
				public static boolean consistirMesAnoFab (String data) {
					int dataMes = 0;
					int dataAno = 0;
					 
					try {
					 dataMes = Integer.parseInt(data.substring(0,2));
					 dataAno = Integer.parseInt(data.substring(3));
					} catch(NumberFormatException e) {
						System.out.println("Formato de data invalido!");
					} catch (StringIndexOutOfBoundsException siobe ) {
						System.out.println("Formato de data invalido!");
					}
					
					 if (data.length() != 7) {
					    System.out.println("A data deve conter exatos 7 caracteres!");
					    return false;
					 } else if (dataMes > 12 || dataMes < 1) { 
						 System.out.println("O mes precisa ser entre 1 e 12!");
						 return false;
					 } else if (dataAno < 1980 || dataAno > 2019) { 
						 System.out.println("O ano precisa ser entre 1980 e 2019!");
						 return false;
					 } else {
						 return true;
					 }
			}
				
				public static String consistirMarca (String marca) {
					String origem = "";
					
					
					return origem;
			}
}
