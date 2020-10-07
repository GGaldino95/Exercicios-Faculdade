/*
 ============================================================================
 Name        : Exercicio05.c
 Author      : Gabriel Galdino
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct{
	char nome[50];
	int idade;
	char sexo;
	float peso;
} cadPaciente;

int main(void) {
	setbuf(stdout, NULL);

	cadPaciente paciente;

	printf("\nDigite o nome do paciente: ");
	gets(paciente.nome);

	printf("\nDigite a idade do paciente: ");
	scanf("%d", &paciente.idade);

	fflush(stdin);
	printf("\nDigite o gênero do paciente: ");
	scanf("%c", &paciente.sexo);

	printf("\nDigite o peso do paciente: ");
		scanf("%f", &paciente.peso);

		printf("\n======= DADOS PACIENTE =======");
		printf("\n Nome: %s"
				"\n Idade: %d"
				"\n Gênero: %c"
				"\n Peso: %.2f", paciente.nome, paciente.idade, paciente.sexo, paciente.peso);
		printf("\n==============================");
	return 0;
}
