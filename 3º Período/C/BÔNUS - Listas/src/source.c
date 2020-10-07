/*
 * source.c
 *
 *  Created on: 12 de nov de 2019
 *      Author: n231017274
 */

#include <stdio.h>
#include <stdlib.h>
#include "lib.h"

void menu() {
}

cadastro* incluirComecoDaLista(cadastro *lista) {

	cadastro *novo; //Declaração
	novo = (cadastro*) malloc(sizeof(cadastro)); //Alocação

	//Preencher campos básicos
	novo->codigo = RANDOMNUMBER; //Atribuir através do ponteiro criado dentro da função.

	//Preencher apontamento
	novo->proximo = lista;

	return novo;
}

void exibirLista(cadastro *lista) {

	if (lista != NULL) {
		printf("\nEndereço %p - Código %d - Próximo %p.", lista, lista->codigo,
				lista->proximo);
		exibirLista(lista->proximo);
	}
}

cadastro* incluirFimDaLista(cadastro *lista) {

	cadastro *novo = (cadastro*) malloc(sizeof(cadastro)); //Alocação Dinâmica

	//Preencher campos básicos
	novo->codigo = RANDOMNUMBER; //Atribuição de número aleatório no campo codigo da estrutura cadastro
	novo->proximo = NULL;

	//Conectar a Lista
	if (lista == NULL) {
		return novo;
	} else {
		cadastro *tmp = lista; //Ponteiro temporário para apontar onde o proximo elemento da lista aponta

		while (tmp->proximo != NULL) { //Enquanto o endereço do proximo elemento não for NULL, ele avança para o elemento seguinte.
			tmp = tmp->proximo;
		}

		tmp->proximo = novo; //Elemento que aponta para NULL encontrado.
		return lista;
	}
}
