/*
 ============================================================================
 Name        : AlocacaoDinamica.c
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

	printf("Alocação Int: ");
	int *x;
	x  = (int*) malloc(sizeof(int));	//Significa que estou alocando um espaço de memoria equivalente ao espaço que um tipo Int consome.
	printf("\nEndereço alocado: %p - %d", x, *x);
	*x = 0;
	printf("\nEndereço alocado: %p - %d", x, *x);

	printf("\n\nAlocação Float: ");
	float *y = (float*) malloc(sizeof(float) * 5); //"* 5" significa que quero 5 espaços de memoria equivalente ao espaço que um tipo Float consome.
	int i;
	for (i = 0; i < 5; i++) { //sem o for, o ponteiro só mostrará o primeiro endereço de memória dos que você alocou.
		*y = i + 1;
		printf("\nEndereço alocado: %p - %f", y, *y);
		y++;
	}
	y -= 5; //Esta linha serve para você retornar ao endereço inicial alocado.
	printf("\nEndereço alocado: %p - %f", y, *y);

	char *c = (char*) malloc (10); //Pode-se usar o 'malloc(sizeof(char) * 10);', não usei pois o char vale apenas 1 byte e dessa forma nao precisa envolver matematica;




	free(x); //Serve para liberar os espaços de memória alocados de determinado ponteiro.
	free(y);
	free(c);



	return 0;
}
