/*
 ============================================================================
 Name        : NovasEstruturas.c
 Author      : Gabriel Galdino
 Description : Novas Estruturas de Dados: Typedef, Struct
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct {  	//typedef aplicado diretamente na criação do struct (tipo antigo)
	char rua[30];
	int numero;
	char estado[2];
} dadosEndereco; 	//tipo novo declarado após } do struct.


struct dadosPaciente {
	char nome[50];
	int idade;
	char genero;
	float peso;
	//dadosEndereco end; //chamada do struct dadosEndereco(novo tipo após typedef).
	dadosEndereco end[2]; //conversão da estrutura para um vetor, permitindo armazenamento de até [2] endereços para cada Paciente.
};
typedef struct dadosPaciente dadosPaciente; //typedef 'struct dadosPaciente'(tipo antigo) dadosPaciente(tipo novo)

union valores { //Union funciona da mesma forma que o struct, porém ele irá usar EXCLUSIVAMENTE um tipo de variável, apenas. (ou usará int, ou usará float)
	int valI;
	float valF;
};
typedef union valores valores; //typedef 'union valores'(tipo antigo) valores(tipo novo)

int main(void) {
	setbuf(stdout, NULL);
	int i = 100;

	//Uso do Struct
	//struct dadosPaciente dados; //struct 'tipo' 'nome'    (sem typedef)
	dadosPaciente dados; 				 //'tipo' 'nome'	(com typedef)

	printf("\nDigite o peso: ");
	scanf("%f", &dados.peso); //Atribuindo o valor digitado ao campo float 'peso' da estrutura dadosPaciente.

	for (i = 0; i < 2; i++) {
		printf("\nDigite o nome da rua: ");
			fflush(stdin);
			gets(dados.end[i].rua); //dados(instância do struct dadosPaciente).end(instancia do struct dadosEndereco dentro de dadosPaciente).rua(campo rua do struct dadosEndereco)
			printf("\n%s", dados.end[i].rua); //impressão
	}

	//Uso do Union
	valores val;
	printf("Usando apenas o valor int");
	val.valI = 23;
	printf("\nValor Inteiro = %d"
			"\n Valor float = %f", val.valI, val.valF); //Ele mostrará o valor atribuído em valI (23), e o float sem atribuição.

	printf("Usando apenas o valor float");
	val.valF = 23.96;
		printf("\nValor Inteiro = %d"
				"\n Valor float = %f", val.valI, val.valF); //Ele mostrará o valor atribuído em ValF (23.96), e o valor que havia em int será "apagado".
	return 0;
}
