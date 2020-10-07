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

	cadastro *novo; //Declara��o
	novo = (cadastro*) malloc(sizeof(cadastro)); //Aloca��o

	//Preencher campos b�sicos
	novo->codigo = RANDOMNUMBER; //Atribuir atrav�s do ponteiro criado dentro da fun��o.

	//Preencher apontamento
	novo->proximo = lista;

	return novo;
}

void exibirLista(cadastro *lista) {

	if (lista != NULL) {
		printf("\nEndere�o %p - C�digo %d - Pr�ximo %p.", lista, lista->codigo,
				lista->proximo);
		exibirLista(lista->proximo);
	}
}

cadastro* incluirFimDaLista(cadastro *lista) {

	cadastro *novo = (cadastro*) malloc(sizeof(cadastro)); //Aloca��o Din�mica

	//Preencher campos b�sicos
	novo->codigo = RANDOMNUMBER; //Atribui��o de n�mero aleat�rio no campo codigo da estrutura cadastro
	novo->proximo = NULL;

	//Conectar a Lista
	if (lista == NULL) {
		return novo;
	} else {
		cadastro *tmp = lista; //Ponteiro tempor�rio para apontar onde o proximo elemento da lista aponta

		while (tmp->proximo != NULL) { //Enquanto o endere�o do proximo elemento n�o for NULL, ele avan�a para o elemento seguinte.
			tmp = tmp->proximo;
		}

		tmp->proximo = novo; //Elemento que aponta para NULL encontrado.
		return lista;
	}
}
