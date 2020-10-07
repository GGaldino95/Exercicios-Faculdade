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
#define RANDOM(x) rand() % x //Esta macro ir� gerar um n�mero rand�mico definido por um par�metro (x), que ira de 0 at� o valor do par�metro x

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


//Prot�tipos
void menu();
void exibirLista(cadastro *lista);
cadastro* incluirComecoDaLista(cadastro *lista);
cadastro* incluirFimDaLista(cadastro *lista);

#endif /* LIB_H_ */
