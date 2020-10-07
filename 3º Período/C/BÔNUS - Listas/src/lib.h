/*
 * lib.h
 *
 *  Created on: 12 de nov de 2019
 *      Author: n231017274
 */

#ifndef LIB_H_
#define LIB_H_

//Macros e Constantes
#define RANDOMNUMBER (rand())
#define RANDOM(x) rand() % x //Esta macro irá gerar um número randômico definido por um parâmetro (x), que ira de 0 até o valor do parâmetro x

//Estruturas
/*
	typedef struct {
 	 	 int codigo;
 	 	 struct cadastro *proximo;
 	 } cadastro;
*/

typedef struct cadastro cadastro;
struct cadastro {
	int codigo;
	cadastro *proximo;
};


//Protótipos
void menu();
void exibirLista(cadastro *lista);
cadastro* incluirComecoDaLista(cadastro *lista);
cadastro* incluirFimDaLista(cadastro *lista);

#endif /* LIB_H_ */
