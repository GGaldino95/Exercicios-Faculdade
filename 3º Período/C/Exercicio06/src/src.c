/*
 * src.c
 *
 *  Created on: 25 de nov de 2019
 *      Author: GGald
 */

#include <math.h>
#include <stdlib.h>
#include "lib.h"

int raizQuadradaIterativo(int n) {
	int resultado = 0, numeroImpar = 1;

	do {
		n -= numeroImpar;
		numeroImpar += 2;
		resultado++;
	} while (n > 0);

	if (n < 0) {
		//Não existe raiz
		return 0;
	} else {
		//Raiz quadrada
		return resultado;
	}
}

int raizQuadradaRecursivaCauda(int n, int resultado) {
	if ((n % 2) == 1) {
		return 3;
	} else {
		return n + raizQuadradaRecursivaCauda(n, (resultado = n - 1));
	}
}

int somaIterativo(int x, int y) {
	int resultado = 0;
	while (y >= 1) {
		resultado += x;
		y--;
	}
	return resultado;
}

int somaRecursivo(int x, int y) {
	if (x == 0 || y == 0) {
		return 0;
	} else if (y == 1) {
		return x;
	} else {
		return x + somaRecursivo(x, y - 1);
	}
}

int somaRecursivoCauda(int x, int y, int result) {
	if (x == 0 || y == 0) {
		return 0;
	} else if (y == 1) {
		return result + x;
	} else {
		return somaRecursivoCauda(x, y - 1, result + x);
	}
}

float serieIterativo(int termos) {
	float somatorio = 0;
	while (termos > 0) {
		somatorio += pow(termos, 3) / pow(10, termos - 1);
		termos--;
	}
	return somatorio;
}

float serieRecursivo(int termos) {
	if (termos == 0) { //Caso base
		return pow(termos, 3) / pow(10, termos - 1);
	} else { //caso recursivo
		return pow(termos, 3) / pow(10, termos - 1) + serieRecursivo(termos - 1);
	}
}

float serieRecursivoCauda(int num, float resultado) {
	if (num == 1) {
		return resultado + 1;
	} else {
		return serieRecursivoCauda(num - 1, num + resultado);
	}
}

void preencherVetor(int n, float *vetor) {
	if (n > 1) { //Caso Recursivo
		preencherVetor(n - 1, vetor + 1);
	}
	*vetor = rand();

	/*
	 if (n == 1) { //caso base
	 *vetor = rand();
	 } else { //caso recursivo
	 preencherVetor(n-1, vetor+1);
	 *vetor = rand();
	 }
	 */
}

void preencherVetorCauda(int n, float *vetor) {
	*vetor = rand(); //rand gera números aleatórios
	if (n > 1) { //Caso Recursivo
		preencherVetorCauda(n - 1, vetor + 1);
	}
}

