/*
 * lib.h
 *
 *  Created on: 25 de nov de 2019
 *      Author: GGald
 */

#ifndef LIB_H_
#define LIB_H_

//Protótipo

int raizQuadradaIterativo(int n);
int raizQuadradaRecursivaCauda(int n, int resultado);

int somaIterativo(int x, int y);
int somaRecursivo(int x, int y);
int somaRecursivoCauda(int x, int y, int result);

float serieIterativo(int termos);
float serieRecursivo(int termos);
float serieRecursivoCauda(int termos, float res);

void preencherVetor(int n, float *vetor);
void preencherVetorCauda(int n, float *vetor);

void exibirVetor(int n, float *vetor);

#endif /* LIB_H_ */
