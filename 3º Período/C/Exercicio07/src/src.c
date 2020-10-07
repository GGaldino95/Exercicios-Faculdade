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

	cadastro *novo = (cadastro*) malloc(sizeof(cadastro)); //Aloca��o Din�mica

	novo->codigo = RNG; //Atribui um n�mero aleat�rio no campo 'codigo' da estrutura 'cadastro' atrav�s do ponteiro 'novo'.
	novo->anterior = NULL; //Define o apontameto do ponteiro 'anterior' para nulo, pois como � uma inser��o pelo in�cio, n�o deve haver endere�os apontados antes do 'novo' registro criado.
	novo->proximo = lista; //Define o apontamento do ponteiro 'proximo' para o endere�o de mem�ria do ponteiro 'lista'.


	if (lista != NULL)
		lista->anterior = novo; //Se a 'lista' n�o estiver vazia, o ponteiro 'anterior' aponta para o 'novo' endere�o criado.

	return novo; //Retorna o 'novo' endere�o da lista, onde este passa a ser o primeiro registro.
}

cadastro* inclusaoFinal(cadastro *lista) {

	cadastro *novo = (cadastro*) malloc(sizeof(cadastro)); //Aloca��o Din�mica

	novo->codigo = RNG; //Atribui um n�mero aleat�rio no campo 'codigo' da estrutura 'cadastro' atrav�s do ponteiro 'novo'.
	novo->proximo = NULL; //Define o apontamento do ponteiro 'proximo' para nulo, por ser uma inclus�o no final da 'lista'.

	if (lista == NULL) {
		novo->anterior = NULL; //Se a 'lista' estiver vazia, define o apontamento de 'anterior' para nulo, pois n�o existe nada antes dele.
		return novo; //Retorna o apontamento do 'novo' endere�o pois este ser� o primeiro registro da lista.
	} else {
		cadastro *tmp = lista; //Se a 'lista' N�O estiver vazia, define o apontamento do ponteiro temporario 'tmp' para o mesmo apontamento da 'lista'.

		while (tmp->proximo != NULL) { //Loop que verificar� se o registro atual aponta para um pr�ximo registro.
			tmp = tmp->proximo; //� realizada a verifica��o em todos os registros at� que algum (o �ltimo registro no caso) aponte para nada (null), para que ocorra a inclus�o de um 'novo' registro na 'lista'.
		}

		tmp->proximo = novo; //Assim que o �ltimo registro da 'lista' � encontrado, este ter� seu campo 'proximo' apontando para o 'novo' registro a ser criado.
		novo->anterior = tmp; //Define o apontamento de 'anterior' para o �ltimo campo da lista antes da 'nova' inclus�o.
		return lista; //Retorna o endere�o da 'lista', pois este ainda � o primeiro endere�o dos registros existentes.
	}
}

void exibirLista(cadastro *lista) {
	if (lista != NULL) {
		printf("\nC�digo %d \t- Anterior %p - Endere�o %p - Pr�ximo %p.", //Imprime o registro existente da lista.
				lista->codigo, lista->anterior, lista, lista->proximo);
		exibirLista(lista->proximo); //Imprime o 'pr�ximo' registro existente na lista recursivamente.
	}
}
