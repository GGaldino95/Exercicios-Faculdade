/*
 ============================================================================
 Name        : Exercicio04.c
 Author      : Gabriel Galdino

 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

//Protótipos
void menu();
void receberReal();
int receberInteiro();
void calcularSalario();
float calcularAumento(float salarioFinal);
float somarSalarios();

int main(void) {
	setbuf(stdout, NULL);
	menu();
	return 0;
}

void menu() {
	char opcao;
	float salario;
	int tamanho;


	while (opcao != 'c') {
		fflush(stdin);
		printf("\nSelecione uma opção: ");
		scanf("%c", &opcao);

		switch (opcao) {
		case 'a':
			calcularSalario(
					receberInteiro("Digite o número de dias trabalhados: "),
					&salario); //a saída de receberInteiro será atribuida no parâmetro (int dias) da função calcularSalario();
			printf("\nVocê receberá R$%.2f", salario);
			break;
		case 'b':
			tamanho = receberInteiro("Digite o tamanho do vetor: ");
			float *vetor = (float*) malloc(sizeof(float) * tamanho);
			printf("\nA média dos salários é R$%.2f", somarSalarios(vetor, tamanho));
			break;
		case 'c':
			printf("Programa encerrado!");
			break;
		default:
			printf("\nOpção inválida! Tente novamente.");
			break;
		}
	}

}

int receberInteiro(char *frase) {
	setbuf(stdout, NULL);

	int num;
	do {
		printf("\n%s", frase);
		scanf("%d", &num);

		if (num <= 0) {
			printf("\nNúmero inválido!");
		}

	} while (num <= 0);

	return num;
}

void receberReal(float *num) { //Aqui a função é void ao invés de float pois estamos usando parâmetro por referencia, assim nao precisando de retorno.
	setbuf(stdout, NULL);

	do {
		printf("\nDigite um número: ");
		scanf("%f", num);

		if (*num <= 0) {
			printf("\nNúmero inválido!");
		}
	} while (*num <= 0);
}

void calcularSalario(int dias, float *salarioFinal) {

	*salarioFinal = dias * 130;
	*salarioFinal *= 0.92f;
}

float calcularAumento(float novoSalario) {

	if (novoSalario <= 1500) {
		novoSalario *= 1.15f;
	} else if (novoSalario <= 5000) {
		novoSalario *= 1.10f;
	}

	return novoSalario;
}

float somarSalarios(float *pVet, int tam) {

	float soma = 0;
	int i;

	for (i = 1; i < tam; i++) {
		receberReal(pVet);
		*pVet = calcularAumento(*pVet);
		soma += *pVet;
		pVet++;
	}
	return soma / tam;
}
