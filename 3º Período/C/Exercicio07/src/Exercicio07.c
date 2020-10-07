/*
 ============================================================================
 Name        : Exercicio07.c
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
	cadastro *lista = NULL;

	int i;

	for(i = 1; i < 5; i++) {
		lista = inclusaoInicio(lista);
		//lista = inclusaoFinal(lista);
	}

	printf("\nInício da lista\n");
		exibirLista(lista);


	return 0;
}
