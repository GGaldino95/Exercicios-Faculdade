/*
 ============================================================================
 Name        : Recursividade.c
 Author      : Gabriel Galdino
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "Utilities.h"

int main(void) {
	setbuf(stdout, NULL);

	int num;
	printf("\nDigite um número para calcular o fatorial: ");
	scanf("%d", &num);

	printf("O fatorial de %d é: %d", num, fatorialRecursivo(num));

	return 0;
}


