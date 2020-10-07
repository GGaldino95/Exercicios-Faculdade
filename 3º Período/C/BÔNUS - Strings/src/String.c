/*
 ============================================================================
 Name        : String.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
	setbuf(stdout, NULL);

	//Declaração
	char letra;
	char vetorChar[10]; //Declaração vetor de Char
	//char string[] = {'O', 'l', 'a', '\0'};
	char string[50] = "Ola Gabriel";



	//Atribuição
	letra = 'A';
	printf("\n Letra = %c e o decimal = %d \n", letra, letra);

	printf("\n Digite uma frase: ");
	gets(string);
	//scanf("%s", string); //scanf("%s", &string[0]); É a mesma coisa
	printf("\n %s", string);

	//Aplicando funções
	//int tamanho;
	//tamanho = strlen(string);
	//printf("\nO tamanho desta string é %d", tamanho);
	printf("\nO tamanho desta string é %d", strlen(string)); //É a mesma coisa das linhas acima

	printf("\nVetorchar = %s e string = %s", vetorChar, string);
	strcpy(vetorChar, string); //Onde vetorChar é o destino, e string é a origem
	printf("\nApós strcopy"
			"\nVetorchar = %s e string = %s", vetorChar, string);

	printf("\nVetorchar = %s e string = %s", vetorChar, string);
	strcat(vetorChar, " "); //Usa-se esta linha pois a concatenação não acrescenta espaço
	strcat(vetorChar, string); //Onde vetorChar é o destino, e string é a origem
	printf("\nApós strcat"
			"\nVetorchar = %s e string = %s", vetorChar, string);




	return 0;
}
