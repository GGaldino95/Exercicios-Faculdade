/*
 ============================================================================
 Name        : Listas.c
 Author      : Gabriel Galdino
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "lib.h"

int main(void) {
	setbuf(stdout, NULL);
	cadastro *lista = NULL; //declaração da lista
	int i;

	for (i = 1; i <= 5; i++)
		//lista = incluirComecoDaLista(lista);
		lista = incluirFimDaLista(lista);


	exibirLista(lista);

	return 0;
}
