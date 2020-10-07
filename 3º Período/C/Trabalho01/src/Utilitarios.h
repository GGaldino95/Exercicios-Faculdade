/*
 ===========================================================================================================================
 Name         : Utilitarios.h
 Autor        : Gabriel Galdino Nogueira
 Versão       : 1.0
 Data Criação : 11/11/2019
 Descrição    : Biblioteca responsável por realizar a comunicação entre as Classes necessárias para funcionamento do AAI.
 ===========================================================================================================================
 */

#ifndef LIB_H_
#define LIB_H_

//Macros
#define RNG (rand())
#define MAXDEP 2


//Estruturas
typedef struct dadosDependentes dadosDependente;
struct dadosDependentes {
	char nome[51];
	char codigo[15];
	char dataNasc[10];			   //Formato DD/MM/AAAA.
	char tipoDependente;
	dadosDependente *proximo;
	dadosDependente *anterior;
};

typedef struct dadosClientes dadosCliente;
struct dadosClientes {
	char nome[51];
	char codigo[15];
	char dataNasc[10];			   //Formato DD/MM/AAAA.
	float limite;
	char tipoCartao;
	dadosDependente dependentes[2]; //Conversão da estrutura para um vetor, permitindo armazenamento de até [2] Dependentes para cada Cliente.
	dadosCliente *proximo;
};


//Protótipos
void menu();
void submenu1();
void submenu2();
void submenu3();

dadosCliente* cadastrarCliente();
dadosCliente* pesquisarCliente();
dadosCliente* excluirCliente();
void cadastrarNome();
void cadastrarLimite();
char cadastrarTipo();

dadosDependente* cadastrarDependente();
dadosDependente* pesquisarDependente();
dadosDependente* excluirDependente();
void cadastrarQtdeDependentes();
void cadastrarTipoDependente();

void exibirLista();

int anoBissexto();

#endif /* LIB_H_ */
