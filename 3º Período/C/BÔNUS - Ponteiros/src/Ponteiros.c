/*
 ============================================================================
 Name        : Ponteiros.c
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

	float 	salario,
		  *pSalario, //ponteiro
			valores[] = {56,98,78};

	printf("Digite o salario: ");
	scanf("%f", &salario);

	pSalario = &salario;
	printf("\nEndere�o de mem�ria de salario %p - Direto", &salario); //Endere�o da vari�vel.
	printf("\nEndere�o de mem�ria de salario %p - Indireto", pSalario); //Endere�o da vari�vel salario armazenado no ponteiro.

	printf("\nEndere�o de mem�ria de pSalario %p", &pSalario); //Endere�o do ponteiro.

	scanf("%f", pSalario); //Atribuir valor atrav�s do ponteiro.

	printf("\nConte�do da vari�vel sal�rio R$%f - Direto", salario); //Conte�do que h� dentro da vari�vel salario.

	*pSalario = 15000; //Atribui��o do valor 15000 na variavel salario (atrav�s do *).
	printf("\nConte�do da vari�vel sal�rio R$%f - Indireto", *pSalario); //Conte�do que h� dentro da vari�vel salario.


	//Apontar para vetor
	pSalario = &valores[0]; //OU pSalario = valores;

	int i;
	for (i = 0; i < 3; i++) {
		//printf("\nValor do �ndice %d - %f - Endere�o de mem�ria %p", i, valores[i], &valores[i]);
		  printf("\nValor do �ndice %d - %f - Endere�o de mem�ria %p", i, *pSalario, pSalario);
	//Onde *pSalario retorna o valor da vari�vel referenciada valores[], e pSalario pega o endere�o de mem�ria armazeado dentro de si proveniente de valores[].
		  pSalario++; //O incremento (++) num ponteiro serve para dizer qual o pr�ximo endere�o armazenado no vetor.
	}

	return 0;
}
