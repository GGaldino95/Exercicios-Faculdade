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

	//Quest�o 1
	printf("Quest�o 1:");
	printf("\nDigite uma frase para a primeira string: ");
	fflush(stdin);
	gets(string1);

	printf("Digite uma frase para a segunda string: ");
	fflush(stdin);
	gets(string2);

	printf("Os valores inseridos foram: %s"
			"\n %s", string1, string2);

	//Quest�o 2
	printf("\n\nQuest�o 2:");
	strcat(string1, " ");
	strcat(string1, string2);
	printf("\n A concatena��o resulta em: %s", string1);

	//Quest�o 3
	printf("\n\nQuest�o 3:");
	strcmp(string1, string2) == -1 ?
	printf("\n%s, \n%s", string1, string2): //verdadeiro //perceba que no final da linha usa-se : ao inv�s de ;
	printf("\n%s, \n%s", string2, string1); //falso

	/* Os comandos acima s�o a mesma coisa que:
	 *
	 * if (strcmp(string1, string2) == -1) {
	 *	printf("\n%s, %s", string1, string2);
	 *	} else {
	 *	printf("\n%s, %s", string2, string1);
	*   }
	*/

	//Quest�o 4
	printf("\n\nQuest�o 4:");
	strcpy(string2, string1);
	printf("\nA segunda string agora vale %s", string2);

	//Quest�o 5
	printf("\n\nQuest�o 5:");
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

	//Quest�o 6
	printf("\n\nQuest�o 6:");
	printf("\nO tamanho da string 1 � %d", tamanho);

	//Quest�o 7
	printf("\n\nQuest�o 7:");

	//for(i = 0; string2[i] != '\0'; i++); � a mesma coisa que o while abaixo.
	while (string2[i] != '\0') {
		i++;
	}
	printf("\nO tamanho da string 2 � %d", i);

}
