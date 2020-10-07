#include <stdio.h>
#include <stdlib.h>

#include "MinhaBiblioteca.h"


cadastro* inserirInicio(cadastro *listaSimples){
	//Alocar espaço de memória
	cadastro *novo = (cadastro*) malloc (sizeof(cadastro));

	//Preencher campos básicos
	novo->codigo = RANDOMICO;
	//Preencher apontamento
	novo->proximo = listaSimples;

	return novo;
}

void imprimir(cadastro *listaSimples){
	if (listaSimples != NULL) {
		printf("\nEndereço %p - Código %d - Próximo %p.\n",
				listaSimples, listaSimples->codigo, listaSimples->proximo);
		imprimir(listaSimples->proximo);
	}
}

cadastro* inserirFim(cadastro *listaSimples){
	//Alocar espaço de memória
	cadastro *novo = (cadastro*) malloc (sizeof(cadastro));

	//Preencher campos básicos
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
	//Alocar espaço de memória
	cadastro *novo = (cadastro*) malloc (sizeof(cadastro));

	//Preencher campos básicos
	novo->codigo = RANDOMICO;
	novo->proximo = NULL;

	if ((*ultimo) != NULL) { //Verifica se existe informação do último registro.
		(*ultimo)->proximo = novo; //Faço o último apontar para o novo
	}

	(*ultimo) = novo; //O novo passará a ser o último elemento.

	if (listaSimples == NULL) {
		return novo;
	} else {
		return listaSimples;
	}
}

cadastro* inserirFimUltimoRegistro(cadastro *listaSimples){
	//Alocar espaço de memória
	cadastro *novo = (cadastro*) malloc (sizeof(cadastro));

	//Preencher campos básicos
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
			//Não encontrei procura no próximo
			anterior = tmp;
			tmp = tmp->proximo;
		}
	}
	return listaSimples;
}






