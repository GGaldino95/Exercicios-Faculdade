#include <stdio.h>
#include <stdlib.h>

#include "MinhaBiblioteca.h"


cadastro* inserirInicio(cadastro *listaSimples){
	//Alocar espa�o de mem�ria
	cadastro *novo = (cadastro*) malloc (sizeof(cadastro));

	//Preencher campos b�sicos
	novo->codigo = RANDOMICO;
	//Preencher apontamento
	novo->proximo = listaSimples;

	return novo;
}

void imprimir(cadastro *listaSimples){
	if (listaSimples != NULL) {
		printf("\nEndere�o %p - C�digo %d - Pr�ximo %p.\n",
				listaSimples, listaSimples->codigo, listaSimples->proximo);
		imprimir(listaSimples->proximo);
	}
}

cadastro* inserirFim(cadastro *listaSimples){
	//Alocar espa�o de mem�ria
	cadastro *novo = (cadastro*) malloc (sizeof(cadastro));

	//Preencher campos b�sicos
	novo->codigo = RANDOMICO;
	novo->proximo = NULL;

	//Conectar a lista
	if (listaSimples == NULL) {
		return novo;
	} else {
		cadastro *tmp = listaSimples;
		while (tmp->proximo != NULL){
			tmp = tmp->proximo;
		}
		tmp->proximo = novo; //encontrei o elemento que aponta para NULL

		return listaSimples;
	}
}

cadastro* inserirFimUltimo(cadastro *listaSimples, cadastro **ultimo){
	//Alocar espa�o de mem�ria
	cadastro *novo = (cadastro*) malloc (sizeof(cadastro));

	//Preencher campos b�sicos
	novo->codigo = RANDOMICO;
	novo->proximo = NULL;

	if ((*ultimo) != NULL) { //Verifica se existe informa��o do �ltimo registro.
		(*ultimo)->proximo = novo; //Fa�o o �ltimo apontar para o novo
	}

	(*ultimo) = novo; //O novo passar� a ser o �ltimo elemento.

	if (listaSimples == NULL) {
		return novo;
	} else {
		return listaSimples;
	}
}

cadastro* inserirFimUltimoRegistro(cadastro *listaSimples){
	//Alocar espa�o de mem�ria
	cadastro *novo = (cadastro*) malloc (sizeof(cadastro));

	//Preencher campos b�sicos
	novo->codigo = RANDOMICO;
	novo->proximo = NULL;

	return novo;
}

cadastro* excluirElemento(cadastro* listaSimples, int cod){
	cadastro *tmp = listaSimples,
			 *anterior = NULL;

	while (tmp != NULL){
		if (tmp->codigo == cod) {
			//Encontrei
			if (anterior == NULL) {
				//Se for o primeiro registro.
				listaSimples = listaSimples->proximo;
			} else {
				//Se for o registro do meio ou o ultimo.
				anterior->proximo = tmp->proximo;
			}
			free(tmp); //Apago o registro
			break;
		} else {
			//N�o encontrei procura no pr�ximo
			anterior = tmp;
			tmp = tmp->proximo;
		}
	}
	return listaSimples;
}






