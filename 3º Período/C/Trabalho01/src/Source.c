/*
 ====================================================================================================
 Name         : Source.c
 Autor        : Gabriel Galdino Nogueira
 Versão       : 1.0 (Incompleto)
 Data Criação : 11/11/2019
 Descrição    : Classe responsável por armazenar as funções necessárias para funcionamento do AAI.
 ====================================================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <time.h>
#include "lib.h"

void menu() {
	char opcao;
	dadosCliente *cliente = NULL;
	dadosDependente *dependente = NULL;

	do {
		printf("\n===================================================="
				"\n\t\tFinanceira FinCom"
				"\n===================================================="
				"\n\t\t    Bem-vindo!"
				"\n\nA - Inserir Cliente"
				"\nB - Excluir Cliente"
				"\nC - Exibir Relatórios"
				"\nD - Finalizar"
				"\n\n Selecione uma Opção: ");
		fflush(stdin);
		scanf("%c", &opcao);
		opcao = toupper(opcao);

		switch (opcao) {
		case 'A':
			submenu1(&opcao, &cliente, &dependente);
			break;
		case 'B':
			submenu2(&opcao, &cliente, &dependente);
			break;
		case 'C':
			submenu3(&opcao, cliente, dependente);
			break;
		case 'D':
			printf("\nPrograma Finalizado!");
			break;
		default:
			printf("\nOpção Inválida! Tente novamente.");
		}

	} while (opcao != 'D');
}

void submenu1(char *opcao, dadosCliente **cliente, dadosDependente **dependente) {

	do {
		printf("\n1 - Efetuar inclusão de Cliente"
				"\n2 - Efetuar inclusão de Dependente"
				"\n3 - Voltar ao menu principal"
				"\n\n Selecione uma Opção: ");
		fflush(stdin);
		scanf("%c", opcao);

		switch (*opcao) {
		case '1':
			*cliente = cadastrarCliente(*cliente);
			break;
		case '2':
			*dependente = cadastrarDependente(*dependente);
			break;
		case '3': //Retorna ao menu();
			break;
		default:
			printf("\nOpção Inválida! Tente novamente.\n");
		}
	} while (*opcao != '3');
}

void submenu2(char *opcao, dadosCliente **cliente, dadosDependente **dependente) {

	do {
		printf("\n1 - Efetuar exclusão de Cliente"
				"\n2 - Efetuar exclusão de Dependente"
				"\n3 - Voltar ao menu principal"
				"\n\n Selecione uma Opção: ");
		fflush(stdin);
		scanf("%c", opcao);

		switch (*opcao) {
		case '1':
			*cliente = excluirCliente(*cliente);
			break;
		case '2':
			*dependente = excluirDependente(*dependente);
			break;
		case '3': //Retorna ao menu();
			break;
		default:
			printf("\nOpção Inválida! Tente novamente.\n");
		}
	} while (*opcao != '3');
}

void submenu3(char *opcao, dadosCliente *cliente, dadosDependente *dependente) {

	do {
		printf(
				"\n1 - Listar todos os dados dos clientes cadastrados e exibir a média dos limites"
						"\n2 - Listar todos os dados de um cliente por código"
						"\n3 - Listar clientes por tipo de cartão"
						"\n4 - Voltar ao menu principal"
						"\n\n Selecione uma Opção: ");
		fflush(stdin);
		scanf("%c", opcao);
		switch (*opcao) {
		case '1':
			exibirLista(cliente);
			break;
		case '2':
			break;
		case '3':
			break;
		case '4': //Retorna ao menu();
			break;
		default:
			printf("\nOpção Inválida! Tente novamente.\n");
		}
	} while (*opcao != '4');
}

//FUNÇÕES DE CADASTRO DE INFORMAÇÕES
void cadastrarNome(char *nome) {
	printf("\nDigite o nome a ser cadastrado: ");
	fflush(stdin);
	gets(nome);
}

void gerarCodigo(char *cod, dadosCliente *cliente) {

	char inicialNome = toupper(cliente->nome[0]);
	char inicialSobrenome;
	int i, tam = strlen(cliente->nome);

	for (i = 0; i < tam; i++) {
		if (cliente->nome[i] == ' ') {
			inicialSobrenome = tolower(cliente->nome[i + 1]);
		}
	}

	//strcat(*cod, inicialNome);
	//strcat(*cod, inicialSobrenome);
	//strcat(cod, RNG);

}

char* cadastrarNascimento(char data[10]) {

	int DaysInMon[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	int dia, mes, ano;
	time_t ts;
	struct tm *ct;

	printf("\nDigite a data de nascimento (DD/MM/YYYY): ");
	scanf("%d/%d/%d", &dia, &mes, &ano);
	sprintf(data, "%02d/%02d/%d", dia, mes, ano);

	//Calcular idade
	ts = time(NULL);
	ct = localtime(&ts);
	dia = DaysInMon[mes - 1] - dia + 1;

	if (anoBissexto(ano, mes)) {
		dia = dia + 1;
	}

	dia = dia + ct->tm_mday;
	mes = (12 - mes) + (ct->tm_mon);
	ano = (ct->tm_year + 1900) - ano - 1;

	if (anoBissexto((ct->tm_year + 1900), (ct->tm_mon + 1))) {
		if (dia >= (DaysInMon[ct->tm_mon] + 1)) {
			dia = dia - (DaysInMon[ct->tm_mon] + 1);
			mes = mes + 1;
		}
	} else if (dia >= DaysInMon[ct->tm_mon]) {
		dia = dia - (DaysInMon[ct->tm_mon]);
		mes = mes + 1;
	}

	if (mes >= 12) {
		ano = ano + 1;
		mes = mes - 12;
	}

	printf("\nVocê tem %d anos.\n", ano);

	return data;
}

void cadastrarLimite(float *limite, char *data) {

	int idade;

	printf("\nVocê tem %d anos.\n", idade);

	if (idade < 40) {
		*limite = 10000;
		printf("Seu limite é de R$ 10.000,00");
	} else if (idade < 60) {
		*limite = 15000;
		printf("Seu limite é de R$ 15.000,00");
	} else if (idade < 75) {
		*limite = 5000;
		printf("Seu limite é de R$ 5.000,00");
	} else {
		*limite = 2500;
		printf("Seu limite é de R$ 2.500,00");
	}
}

char cadastrarTipo(float *limite) {

	char tipo;

	do {
		printf("\nSelecione o tipo de cartão desejado: ");
		fflush(stdin);
		scanf("%c", &tipo);
		tipo = toupper(tipo);

		if (tipo != 'U' && tipo != 'N' && tipo != 'I') {
			printf("\nTipo inválido! Tente novamente.");
		}
	} while (tipo != 'U' && tipo != 'N' && tipo != 'I');

	if (tipo == 'U') {
		printf("Tipo selecionado: Universitário\n");
		return tipo;
	} else if (tipo == 'N') {
		printf("Tipo selecionado: Nacional\n");
		*limite *= 1.05f;
		return tipo;
	} else {
		printf("Tipo selecionado: Internacional\n");
		*limite *= 1.2f;
		return tipo;
	}
}

void cadastrarQtdeDependentes(dadosCliente *cliente) {

	int numDependentes;

	do {
		printf("\nDigite o número de dependentes do cliente %s: ",
				cliente->nome);
		scanf("%d", numDependentes);
		if (numDependentes > MAXDEP || numDependentes < 0) {
			printf("\nNúmero de dependentes inválido");
		}
	} while (numDependentes > MAXDEP || numDependentes < 0);

	//Não sei o que fazer depois disso --- cliente->dependentes[numDependentes];
}

void cadastrarTipoDependente(char *tipoDependente) {
	printf("\nSelecione o tipo de Dependente: (Filho F, Cônjuge C, Enteado E)");
	scanf("%c", tipoDependente);
	*tipoDependente = toupper(*tipoDependente);

	if (*tipoDependente == 'C') {
		printf("Tipo selecionado: CÔNJUGE\n");
	} else if (*tipoDependente == 'F') {
		printf("Tipo selecionado: FILHO\n");
	} else if (*tipoDependente == 'E') {
		printf("DTipo selecionado: ENTEADO\n");
	}
}

/* === FUNÇÕES DE CADASTRO, PESQUISA E EXCLUSÃO DE CLIENTES E DEPENDENTES === */
dadosCliente* cadastrarCliente(dadosCliente *cliente) { //Inserção pelo Fim, simplesmente encadeada.

	//Alocação dinâmica
	dadosCliente *novo = (dadosCliente*) malloc(sizeof(dadosCliente));

	//Cadastro dos campos da estrutura
	cadastrarNome(novo->nome);
	//gerarCodigo(novo->codigo, novo);
	strcpy(novo->dataNasc, cadastrarNascimento(novo->dataNasc));
	cadastrarLimite(&novo->limite, novo->dataNasc);
	novo->tipoCartao = cadastrarTipo(&novo->limite);
	cadastrarQtdeDependentes(novo->dependentes);

	//Inserção na lista
	novo->proximo = NULL;

	if (cliente == NULL) {
		return novo;
	} else {
		dadosCliente *tmp = cliente;
		while (tmp->proximo != NULL) {
			tmp = tmp->proximo;
		}
		tmp->proximo = novo;

		return cliente;
	}
}

dadosDependente* cadastrarDependente(dadosDependente *dependente) { //Inserção pelo Início, duplamente encadeada.

//Alocação Dinâmica
	dadosDependente *novo = (dadosDependente*) malloc(sizeof(dadosDependente));

//Cadastro dos campos da estrutura
	cadastrarNome(dependente->nome);
	cadastrarNascimento(dependente->dataNasc);
	cadastrarTipoDependente(dependente->tipoDependente);

//Inserção na lista
	novo->anterior = NULL;
	novo->proximo = dependente;

	if (dependente != NULL)
		dependente->anterior = novo;

	return novo;
}

dadosCliente* pesquisarCliente(dadosCliente *cliente, char cod[15],
		dadosCliente **anterior) {

	dadosCliente *atual = cliente;
	*anterior = NULL;

	while (atual != NULL) {
		if (atual->codigo == cod)
			return atual;

		*anterior = atual;
		atual = atual->proximo;
	}

	*anterior = NULL;
	return NULL;
}

dadosCliente* excluirCliente(dadosCliente *cliente) {

	dadosCliente *anterior = NULL, *tmp = cliente;

//Código desejado para exclusão
	char cod[15];
	printf("Digite o código para exclusão: ");
	fflush(stdin);
	gets(cod);

	tmp = pesquisarCliente(cliente, cod, &anterior);
	if (tmp == NULL) {
		printf("Cliente não encontrado!");
	} else if (anterior == NULL) {
		cliente = cliente->proximo;
	} else {
		anterior->proximo = tmp->proximo;
	}
	free(tmp);
	return cliente;
}

dadosDependente* pesquisarDependente(dadosDependente *dependente, char cod[15]) {

	dadosDependente *atual = dependente;

	while (atual != NULL) {
		if (atual->codigo == cod)
			return atual;

		atual = atual->proximo;
	}
	return NULL;
}

dadosDependente* excluirDependente(dadosDependente *dependente) {

	dadosDependente *tmp = dependente;

//Código desejado para exclusão
	char cod[15];
	printf("Digite o código para exclusão: ");
	fflush(stdin);
	gets(cod);

	tmp = pesquisarDependente(dependente, cod);
	if (tmp == NULL) {
		printf("Dependente não encontrado!");
	} else if (tmp->anterior == NULL) {
		dependente = dependente->proximo;
		if (dependente != NULL) {
			dependente->anterior = NULL;
		}
	} else {
		tmp->anterior->proximo = tmp->proximo;

		if (tmp->proximo != NULL) {
			tmp->proximo->anterior = tmp->anterior;
		}
	}
	free(tmp);
	return dependente;
}

void exibirLista(dadosCliente *cliente) {

	if (cliente != NULL) {
		printf(
				"\nEndereço %p - Nome %s - Data %s - Limite - %f Tipo %c - Próximo %p.",
				cliente, cliente->nome, cliente->dataNasc, cliente->limite,
				cliente->tipoCartao, cliente->proximo);
		exibirLista(cliente->proximo);
	}
}

//Valida ano Bissexto
int anoBissexto(int ano, int mes) {
	int flag = 0;
	if (ano % 100 == 0) {
		if (ano % 400 == 0) {
			if (mes == 2) {
				flag = 1;
			}
		}
	} else if (ano % 4 == 0) {
		if (mes == 2) {
			flag = 1;
		}
	}
	return (flag);
}
