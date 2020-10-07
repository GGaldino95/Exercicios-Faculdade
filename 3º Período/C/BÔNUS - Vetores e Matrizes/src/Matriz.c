/*
 ============================================================================
 Name        : Matriz.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	setbuf(stdout, NULL);

	//Declaração de Vetor
	int idades[10]; //Só declaração
	float salarios[2] = {1569.89, 529.78}; //Declaração e Inicialização dimensionada ([2])
	double vetor[] = {968.98, 8596, 1259.96}; //Declaração e Inicialização não-dimensionada ([])
	int i = 25;
	char str[i];

	//Atribuir valor
	idades[0] = 29;
	for (i = 0; i < 10; ++i) {
		idades[i] = 0;
		printf("\n %d", idades[i]);
		printf("\n Digite um valor inteiro: ");
		scanf("%d", &idades[i]);
	}

	//Declaração de Matriz
	int valores[5][2]; //Só declaração
	float sal[5][2] = {{15, 96}, {9, 36}, {96, 89}, {4, 6}, {6, 96}}; //Declaração e Inicialização dimensionada ([5][2])
	//double matriz[5][] = {15, 96, 9, 36, 96, 89, 4, 6, 6, 96}; //Declaração e Inicialização não-dimensionada ([5][])
	double matriz2[][2] = {{15, 96}, {9, 36}, {96, 89}, {4, 6}, {6, 96}}; //Declaração e Inicialização não-dimensionada ([][2]) //tira as chaves internas
	//É obrigatório você dimensionar um dos elementos

	//Atribuir valor
	valores[2][1] = 15.96;
	int j;
	for (i = 0; i < 2; ++i) {
		for (j = 0; j < 5; ++j) {
			printf("\n");
			scanf("%d", &valores[j][i]);
		}
	}

	printf("%i - %f - %lf - %c - %i - %f - %lf ", idades[0], salarios[0], vetor[0], str[0], valores[0][0], sal[0][0], matriz2[1][0]);



	return 0;
}
