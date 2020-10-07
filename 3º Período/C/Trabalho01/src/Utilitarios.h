/*
 * Utilitarios.h
 *
 *  Created on: 21 de out de 2019
 *      Author: Gabriel Galdino
 */

#ifndef UTILITARIOS_H_
#define UTILITARIOS_H_

//Estruturas
typedef struct {
	char nome[41];
	int codigo;
	float preco;
	int quantidade;
	int *proximo;
} infoProdutos;

//Protótipos
void menu();
int funcao04();
int funcao05();
void funcao06();
void funcao07(float *valor);
void funcao08();
void funcao09();
void funcao10();
void funcao11();

#endif /* UTILITARIOS_H_ */
