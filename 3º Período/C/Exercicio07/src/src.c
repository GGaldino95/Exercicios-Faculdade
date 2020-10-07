/*
 ============================================================================
 Name        : Exercicio07.c
 Author      : Gabriel Galdino
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "lib.h"

cadastro* inclusaoInicio(cadastro *lista) {

	cadastro *novo = (cadastro*) malloc(sizeof(cadastro)); //Alocação Dinâmica

	novo->codigo = RNG; //Atribui um número aleatório no campo 'codigo' da estrutura 'cadastro' através do ponteiro 'novo'.
	novo->anterior = NULL; //Define o apontameto do ponteiro 'anterior' para nulo, pois como é uma inserção pelo início, não deve haver endereços apontados antes do 'novo' registro criado.
	novo->proximo = lista; //Define o apontamento do ponteiro 'proximo' para o endereço de memória do ponteiro 'lista'.


	if (lista != NULL)
		lista->anterior = novo; //Se a 'lista' não estiver vazia, o ponteiro 'anterior' aponta para o 'novo' endereço criado.

	return novo; //Retorna o 'novo' endereço da lista, onde este passa a ser o primeiro registro.
}

cadastro* inclusaoFinal(cadastro *lista) {

	cadastro *novo = (cadastro*) malloc(sizeof(cadastro)); //Alocação Dinâmica

	novo->codigo = RNG; //Atribui um número aleatório no campo 'codigo' da estrutura 'cadastro' através do ponteiro 'novo'.
	novo->proximo = NULL; //Define o apontamento do ponteiro 'proximo' para nulo, por ser uma inclusão no final da 'lista'.

	if (lista == NULL) {
		novo->anterior = NULL; //Se a 'lista' estiver vazia, define o apontamento de 'anterior' para nulo, pois não existe nada antes dele.
		return novo; //Retorna o apontamento do 'novo' endereço pois este será o primeiro registro da lista.
	} else {
		cadastro *tmp = lista; //Se a 'lista' NÃO estiver vazia, define o apontamento do ponteiro temporario 'tmp' para o mesmo apontamento da 'lista'.

		while (tmp->proximo != NULL) { //Loop que verificará se o registro atual aponta para um próximo registro.
			tmp = tmp->proximo; //É realizada a verificação em todos os registros até que algum (o último registro no caso) aponte para nada (null), para que ocorra a inclusão de um 'novo' registro na 'lista'.
		}

		tmp->proximo = novo; //Assim que o último registro da 'lista' é encontrado, este terá seu campo 'proximo' apontando para o 'novo' registro a ser criado.
		novo->anterior = tmp; //Define o apontamento de 'anterior' para o último campo da lista antes da 'nova' inclusão.
		return lista; //Retorna o endereço da 'lista', pois este ainda é o primeiro endereço dos registros existentes.
	}
}

void exibirLista(cadastro *lista) {
	if (lista != NULL) {
		printf("\nCódigo %d \t- Anterior %p - Endereço %p - Próximo %p.", //Imprime o registro existente da lista.
				lista->codigo, lista->anterior, lista, lista->proximo);
		exibirLista(lista->proximo); //Imprime o 'próximo' registro existente na lista recursivamente.
	}
}
