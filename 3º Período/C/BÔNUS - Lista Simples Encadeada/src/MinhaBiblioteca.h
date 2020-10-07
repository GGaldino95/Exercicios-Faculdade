/*
 * MinhaBiblioteca.h
 *
 *  Created on: 12 de nov de 2019
 *      Author: amanda.oliveira
 */

#ifndef MINHABIBLIOTECA_H_
#define MINHABIBLIOTECA_H_

//Macro para gerar randômico
#define RANDOMICO rand()
#define RANDOM(x) rand() % x //limitando o valor final

//Criar estrutura simplesmente encadeada
typedef struct cadastro cadastro;

struct cadastro{
	int codigo;
	cadastro *proximo;
};

//As declarações abaixo equivalem a declaração acima
/*
struct cadastro{
	int codigo;
	struct cadastro *proximo;
};
typedef struct cadastro cadastro;
*/

/*
typedef struct {
	int codigo;
	struct cadastro *proximo;
} cadastro;
*/

//Protótipo
cadastro* inserirInicio(cadastro *listaSimples);
void imprimir(cadastro *listaSimples);
cadastro* inserirFim(cadastro *listaSimples);
cadastro* inserirFimUltimo(cadastro *listaSimples, cadastro **ultimo);
cadastro* inserirFimUltimoRegistro(cadastro *listaSimples);
cadastro* excluirElemento(cadastro* listaSimples, int cod);

#endif /* MINHABIBLIOTECA_H_ */
