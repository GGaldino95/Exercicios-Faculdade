/*
 ============================================================================
 Name        : Exercicio01_Nivelamento.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */
#include <math.h> //biblioteca de cálculos matemáticos
#include <ctype.h> // biblioteca para utilizar o toUpper
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	setbuf(stdout, NULL);

	char menu;
	int n, termos, contador;
	float resultado;

	do {
		printf("\n A - Série A"
				"\n B - Série B"
				"\n C - Série C"
				"\n D - Finalizar"
				"\n Digite sua opção: ");

		fflush(stdin);
		scanf("%c", &menu);
		menu = toupper(menu);

	if (menu == 'A' || menu == 'B' || menu == 'C') {
	//if (menu >= 'A' && menu <= 'C') {
		do {
			printf("\n Digite a quantidade de termos: ");
			scanf("%d", &termos);

			if (termos <= 0) {
				printf("\n Valor invalido!");
			}
		}  while(termos <= 0);

		//Inicialização de variáveis
		contador = 1;
		resultado = 0;
		n = 1;
		switch (menu) {
			case 'A':
				while (contador <= termos) {
				resultado += n + (n-1) / pow(n, 2); //pow: potência (n = base, 2 = expoente)
				contador++;
				n++;
				}
				printf("\n O resultado do somatório dos %d primeiros termos "
					   "é: %.3f", termos, resultado);
				break;
			case 'B':
				do {
					resultado += pow(n, 3) / pow(10, n-1);
					n++;
				} while(n <= termos);
				printf("\n O resultado do somatório dos %d primeiros termos "
					   "é: %.3f", termos, resultado);
				break;
			case 'C':
				for (n=1 ; n <= termos; n++) { //a inicialização "n=1" é opcional pois já foi inicializado antes do switch
					resultado += (float)n / (3*(n*2));
				}
				printf("\n O resultado do somatório dos %d primeiros termos "
					   "é: %.3f", termos, resultado);
				break;
			case 'D':
				printf("\n Programa Finalizado");
				break;
			default:
				printf("\n Valor Invalido.");
			}
		}
	} while(menu != 'D');

	return 0;
}
