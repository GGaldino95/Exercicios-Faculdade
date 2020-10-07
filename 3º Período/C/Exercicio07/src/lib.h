/*
 ============================================================================
 Name        : Exercicio07.c
 Author      : Gabriel Galdino
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#ifndef LIB_H_
#define LIB_H_

//Macros
#define RNG (rand())

//Estruturas
typedef struct cadastro cadastro;
struct cadastro {
	int codigo;
	cadastro *proximo;
	cadastro *anterior;
};

//Funções
cadastro* inclusaoInicio();
cadastro* inclusaoFinal();
void exibirLista();


#endif /* LIB_H_ */
