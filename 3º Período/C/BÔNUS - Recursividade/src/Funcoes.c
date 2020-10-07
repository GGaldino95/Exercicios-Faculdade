/*
 * Funcoes.c
 *
 *  Created on: 29 de out de 2019
 *      Author: n231017274
 */

#include <stdio.h>
#include <stdlib.h>
#include "Utilities.h"

int fatorial_1(int n) { //Iterativo

	int fat = 1;

	while (n > 1) {
		fat *= n--;
	}

	return fat;
}

int fatorialRecursivo(int n) { //Recursividade

	/* 	if (n <= 1) { //caso base
	 * 		return 1;
	 *	} else { //caso recursivo
	 *		return n * fatorialRecursivo(n - 1);
	 *	}
	 */

	return n <= 1 ? 1 : n * fatorialRecursivo(n - 1);
}
