/*
 ============================================================================
 Name        : ListaSimplesmenteEncadeada.c
 Author      : Gabriel Galdino
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

#include "MinhaBiblioteca.h"

int main(void) {
	setbuf(stdout, NULL);
	cadastro *lista = NULL,
			 *ultimo = NULL,
			 *penultimo = NULL;
	int i;

	for (i = 1; i <= 5; i++) {
//		lista = inserirInicio(lista);
		lista = inserirFim(lista);
//		lista = inserirFimUltimo(lista, &ultimo);

		//Armazena o �ltimo registro sem ponteiro para ponteiro.
//		penultimo = ultimo;
//		ultimo = inserirFimUltimoRegistro(lista);
//		if (lista == NULL) {
//			lista = ultimo;
//		} else {
//			penultimo->proximo = ultimo;
//		}
//		printf("\nO �ltimo endere�o inserido � %p\n", ultimo);
	}
	printf("\nIn�cio da lista\n");
	imprimir(lista);

	lista = excluirElemento(lista, 41);
	printf("\nIn�cio da lista\n");
	imprimir(lista);

	lista = excluirElemento(lista, 6334);
	printf("\nIn�cio da lista\n");
	imprimir(lista);

	lista = excluirElemento(lista, 19169);
	printf("\nIn�cio da lista\n");
	imprimir(lista);

	lista = excluirElemento(lista, 18467);
	printf("\nIn�cio da lista\n");
	imprimir(lista);
	lista = excluirElemento(lista, 26500);
	printf("\nIn�cio da lista\n");
	imprimir(lista);


	return EXIT_SUCCESS;
}
