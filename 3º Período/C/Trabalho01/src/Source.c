/*
 * Source.c
 *
 *  Created on: 21 de out de 2019
 *      Author: Gabriel Galdino
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Utilitarios.h"

void menu() {
	char opcao;
	int qtd; //variavel pra armazenar o retorno da funcao produtosParaCadastrar();
	infoProdutos *produtos;

	do {
		printf("\n======= MENU ======="
				"\nA - Criar estrutura para preenchimento"
				"\nB - Preencher dados"
				"\nC - Exibir produtos com estoque zerado"
				"\nD - Exibir produtos em estoque"
				"\nE - Finalizar"
				"\nSelecione uma opção: ");
		fflush(stdin);
		scanf("%c", &opcao);

		switch (opcao) {
		case 'A':
			qtd = funcao04();
			produtos = (infoProdutos*) malloc(sizeof(infoProdutos) * qtd);
			break;
		case 'B':
			funcao09(produtos, qtd);
			break;
		case 'C':
			funcao10(produtos);
			break;
		case 'D':
			funcao11(produtos);
			break;
		case 'E':
			printf("\nPrograma finalizado!");
			break;
		default:
			printf("\nOpção inválida!");
		}

	} while (opcao != 'E');
}

int funcao04() { //int produtosParaCadastrar();
	int quantidade;

	do {
		printf("\nDigite a quantidade de produtos a serem cadastrados: ");
		scanf("%d", &quantidade);

		if (quantidade < 1)
			printf("\nErro! Digite um valor positivo.");

	} while (quantidade < 1);

	return quantidade;
}

int funcao05() { //int cadastrarCodigo();
	int codigo;

	while (codigo < 0 || codigo > 50) {
		printf("\nDigite o codigo do produto a ser cadastrado: ");
		scanf("%d", &codigo);

		if (codigo < 0 || codigo > 50)
			printf("\nErro! Digite um valor entre 0 e 50.");

	}

	return codigo;
}

void funcao06(infoProdutos *produtos) { //void cadastrarNome(<novo tipo> *Produtos);

	do {
		printf("\nDigite o nome do produto de código %d: ", produtos->codigo);
		fflush(stdin);
		gets(produtos->nome);

		if (strlen(produtos->nome) == 0)
			printf("\nErro! Campo não pode ser nulo!");

	} while (strlen(produtos->nome) == 0);
}

void funcao07(float *valor) { //void cadastrarPreco(float *valor);

	do {
		printf("\nDigite o preço do produto: ");
		scanf("%f", valor);

		if (*valor < 0)
			printf("\nErro! Digite um valor positivo.");

	} while (*valor < 0);
}

void funcao08(infoProdutos *produtos) { //void cadastrarQuantidade(<novo tipo> *Produtos);

	do {
		printf("\nDigite a quantidade do produto de código %d: ", produtos->codigo);
		scanf("%d", &produtos->quantidade);

		if (produtos->quantidade < 0)
			printf("\nErro! Digite um valor positivo ou nulo!");

	} while (produtos->quantidade < 0);
}

void funcao09(infoProdutos *produtos, int qtd) { //void cadastrarProduto();
	int i;

	for (i = 1; i < qtd; i++) {
		produtos->codigo = funcao05();
		funcao06(produtos);
		funcao07(&produtos->preco);
		funcao08(produtos);
		produtos++;
	}
}

void funcao10(infoProdutos *produtos, int qtd) { //void exibirProdutosZerados(Produto *produtos);
	int i;

	//Índice de Vetor
	for (i=0 ; i<qtd ; i++) {
		printf("Produto %d\t Código %d\t Nome %s\t Preço Unit%f\t Quantidade %d", i+1, produtos[i].codigo, produtos[i].nome, produtos[i].preco, produtos[i].quantidade );
	}


	/*do {
		if (produtos->quantidade == 0) {
			printf("Código: %d", produtos->codigo);
			printf("Nome: %s", produtos->nome);
			printf("Preço: %f", produtos->preco);
			printf("Quantidade: %d", produtos->quantidade);
		}


	} while (produtos->proximo != NULL);
	*/
}

void funcao11(infoProdutos *produtos, int qtd) { //void exibirProdutos();
int i;
	for (i=0 ; i<qtd ; i++) {
		if (produtos[i].quantidade == 0)
			printf("Produto %d\t Código %d\t Nome %s\t Preço Unit%f\t Quantidade %d", i+1, produtos[i].codigo, produtos[i].nome, produtos[i].preco, produtos[i].quantidade );
		}

	/*
	do {
		printf("Código: %d", produtos->codigo);
		printf("Nome: %s", produtos->nome);
		printf("Preço: %f", produtos->preco);
		printf("Quantidade: %d", produtos->quantidade);

	} while (produtos->proximo != NULL);
	*/
}
