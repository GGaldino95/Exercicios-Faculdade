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

	//Declara��o
	char letra;
	char vetorChar[10]; //Declara��o vetor de Char
	//char string[] = {'O', 'l', 'a', '\0'};
	char string[50] = "Ola Gabriel";



	//Atribui��o
	letra = 'A';
	printf("\n Letra = %c e o decimal = %d \n", letra, letra);

	printf("\n Digite uma frase: ");
	gets(string);
	//scanf("%s", string); //scanf("%s", &string[0]); � a mesma coisa
	printf("\n %s", string);

	//Aplicando fun��es
	//int tamanho;
	//tamanho = strlen(string);
	//printf("\nO tamanho desta string � %d", tamanho);
	printf("\nO tamanho desta string � %d", strlen(string)); //� a mesma coisa das linhas acima

	printf("\nVetorchar = %s e string = %s", vetorChar, string);
	strcpy(vetorChar, string); //Onde vetorChar � o destino, e string � a origem
	printf("\nAp�s strcopy"
			"\nVetorchar = %s e string = %s", vetorChar, string);

	printf("\nVetorchar = %s e string = %s", vetorChar, string);
	strcat(vetorChar, " "); //Usa-se esta linha pois a concatena��o n�o acrescenta espa�o
	strcat(vetorChar, string); //Onde vetorChar � o destino, e string � a origem
	printf("\nAp�s strcat"
			"\nVetorchar = %s e string = %s", vetorChar, string);




	return 0;
}
