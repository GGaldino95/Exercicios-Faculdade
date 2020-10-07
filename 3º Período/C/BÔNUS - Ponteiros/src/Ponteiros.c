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
	printf("\nEndereço de memória de salario %p - Direto", &salario); //Endereço da variável.
	printf("\nEndereço de memória de salario %p - Indireto", pSalario); //Endereço da variável salario armazenado no ponteiro.

	printf("\nEndereço de memória de pSalario %p", &pSalario); //Endereço do ponteiro.

	scanf("%f", pSalario); //Atribuir valor através do ponteiro.

	printf("\nConteúdo da variável salário R$%f - Direto", salario); //Conteúdo que há dentro da variável salario.

	*pSalario = 15000; //Atribuição do valor 15000 na variavel salario (através do *).
	printf("\nConteúdo da variável salário R$%f - Indireto", *pSalario); //Conteúdo que há dentro da variável salario.


	//Apontar para vetor
	pSalario = &valores[0]; //OU pSalario = valores;

	int i;
	for (i = 0; i < 3; i++) {
		//printf("\nValor do índice %d - %f - Endereço de memória %p", i, valores[i], &valores[i]);
		  printf("\nValor do índice %d - %f - Endereço de memória %p", i, *pSalario, pSalario);
	//Onde *pSalario retorna o valor da variável referenciada valores[], e pSalario pega o endereço de memória armazeado dentro de si proveniente de valores[].
		  pSalario++; //O incremento (++) num ponteiro serve para dizer qual o próximo endereço armazenado no vetor.
	}

	return 0;
}
