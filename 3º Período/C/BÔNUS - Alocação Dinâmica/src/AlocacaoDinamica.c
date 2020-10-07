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

	printf("Aloca��o Int: ");
	int *x;
	x  = (int*) malloc(sizeof(int));	//Significa que estou alocando um espa�o de memoria equivalente ao espa�o que um tipo Int consome.
	printf("\nEndere�o alocado: %p - %d", x, *x);
	*x = 0;
	printf("\nEndere�o alocado: %p - %d", x, *x);

	printf("\n\nAloca��o Float: ");
	float *y = (float*) malloc(sizeof(float) * 5); //"* 5" significa que quero 5 espa�os de memoria equivalente ao espa�o que um tipo Float consome.
	int i;
	for (i = 0; i < 5; i++) { //sem o for, o ponteiro s� mostrar� o primeiro endere�o de mem�ria dos que voc� alocou.
		*y = i + 1;
		printf("\nEndere�o alocado: %p - %f", y, *y);
		y++;
	}
	y -= 5; //Esta linha serve para voc� retornar ao endere�o inicial alocado.
	printf("\nEndere�o alocado: %p - %f", y, *y);

	char *c = (char*) malloc (10); //Pode-se usar o 'malloc(sizeof(char) * 10);', n�o usei pois o char vale apenas 1 byte e dessa forma nao precisa envolver matematica;




	free(x); //Serve para liberar os espa�os de mem�ria alocados de determinado ponteiro.
	free(y);
	free(c);



	return 0;
}
