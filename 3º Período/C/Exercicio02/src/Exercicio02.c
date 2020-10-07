/*
 ============================================================================
 Name        : Exercicio02.c
 Author      : Gabriel Galdino
 Version     : 0.0
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
	setbuf(stdout, NULL); //buffer

	char string1[50];
	char string2[50];

	//Questão 1
	printf("Questão 1:");
	printf("\nDigite uma frase para a primeira string: ");
	fflush(stdin);
	gets(string1);

	printf("Digite uma frase para a segunda string: ");
	fflush(stdin);
	gets(string2);

	printf("Os valores inseridos foram: %s"
			"\n %s", string1, string2);

	//Questão 2
	printf("\n\nQuestão 2:");
	strcat(string1, " ");
	strcat(string1, string2);
	printf("\n A concatenação resulta em: %s", string1);

	//Questão 3
	printf("\n\nQuestão 3:");
	strcmp(string1, string2) == -1 ?
	printf("\n%s, \n%s", string1, string2): //verdadeiro //perceba que no final da linha usa-se : ao invés de ;
	printf("\n%s, \n%s", string2, string1); //falso

	/* Os comandos acima são a mesma coisa que:
	 *
	 * if (strcmp(string1, string2) == -1) {
	 *	printf("\n%s, %s", string1, string2);
	 *	} else {
	 *	printf("\n%s, %s", string2, string1);
	*   }
	*/

	//Questão 4
	printf("\n\nQuestão 4:");
	strcpy(string2, string1);
	printf("\nA segunda string agora vale %s", string2);

	//Questão 5
	printf("\n\nQuestão 5:");
	char letra;
	printf("\nDigite uma letra: ");
	fflush(stdin);
	scanf("%c", &letra);

	int i, tamanho = strlen(string1);
	for(i = 0; i < tamanho; i++) {
		if (letra == string1[i]) {
			string1[i] = '*';
		}
	}

	printf("\nString 1 %s", string1);
	return 0;

	//Questão 6
	printf("\n\nQuestão 6:");
	printf("\nO tamanho da string 1 é %d", tamanho);

	//Questão 7
	printf("\n\nQuestão 7:");

	//for(i = 0; string2[i] != '\0'; i++); é a mesma coisa que o while abaixo.
	while (string2[i] != '\0') {
		i++;
	}
	printf("\nO tamanho da string 2 é %d", i);

}
