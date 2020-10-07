/*
 ============================================================================
 Name        : Exercicio03.c
 Author      : Gabriel Galdino
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	setbuf(stdout, NULL);

	int tamanhoVetor = 0;

	do {
		printf("\nDigite um tamanho de vetor: ");
			scanf("%d", &tamanhoVetor);

			if (tamanhoVetor < 1) {
				printf("\nErro! Digite um valor positivo.\n");
			}
	} while(tamanhoVetor < 1);

	//Alocação Dinâmica
	int *px = (int*) malloc(sizeof(int) * tamanhoVetor);

	int i,
		soma = 0;

	for(i = 0; i < tamanhoVetor; i++) {
		printf("\n\nDigite um valor para a posição %d: ", i);
			scanf("%d", px);
			printf("\nValor: %d (Endereço %p)", *px, px);

			if (i % 2 == 0) {
				*px *= 2;
				printf("\nNovo valor: %d", *px);
			} else {
				*px /= 2;
				printf("\nNovo valor: %d", *px);
			}

			soma += *px;
			px++;
	}

	/*
	 * px -= tamanhoVetor;
	 *
	 * printf("\nPosição\t-\tValor\t-\tEndereço de memória");
	 * for (i = 0; i < tamanhoVetor ; i++) {
	 * 	printf("\n%dº\t-\t%d\t-\t%p", i+1, *px, px); 		!são a mesma coisa! Aritmética
	 * 	printf("\n%dº\t-\t%d\t-\t%p", i+1, px[i], &px[i]);  !são a mesma coisa! Indexação
	 * 	pontVetor++;
	 * }
	 */


	px -= i;
	printf("\n\nSomatória de todos os valores digitados: %d", soma);

	free(px);

	return 0;
}
