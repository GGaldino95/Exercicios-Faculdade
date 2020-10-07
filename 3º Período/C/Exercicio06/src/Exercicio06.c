/*
 ============================================================================
 Name        : Exercicio06.c
 Author      : Gabriel Galdino
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "lib.h"

int main(void) {
	setbuf(stdout, NULL);
//	printf("\n 7 * 5 = %d\n", somaIterativo(7, 5));
//	printf("\n 7 * 5 = %d\n", somaRecursivo(7, 5));
//	printf("\n 7 * 5 = %d\n", somaRecursivoCauda(7, 5, 0));

//	printf("\n3 termos da série %.2f\n", serieIterativo(3));
//	printf("\n3 termos da série %.2f\n", serieRecursivo(3));
//	printf("\n3 termos da série %.2f\n", serieRecursivoCauda(3, 0));

//	float vetor[3];
//	preencherVetor(3, vetor);
//	preencherVetorCauda(3, vetor);

//	printf("\nRaiz quadrada de 144: %d", raizQuadradaIterativo(144));
	printf("\nRaiz quadrada de 144: %d", raizQuadradaRecursivaCauda(144, 0));

	return EXIT_SUCCESS;
}
