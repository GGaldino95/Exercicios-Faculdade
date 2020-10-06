package exercicio00;

public class Exercicio00 {

	public static void main(String[] args) {
		int a=5, b=3, c;
		double d=2.5, f=0;
		float g;
		
		
		c = a/b; //Como as vari�veis s�o inteiras, o resultado ser� inteiro
		d += d/a; //Primeiro foi realizado a divis�o de d/a, logo ap�s  o c�lculo, o resultado foi incrementado em d
		f -= a++/d;
		/*f n�o foi inicializado, por isso ele est� como nulo, ao realizar -=, est� tentando
		  fazer um decremento em f, sendo assim ser� necess�rio definir o valor inicial de f
		  para realizar o c�lculo matem�tico;
		  
		  C�lculo:
		  f = f - (a/d);
		  a = a + 1;
		 */
		
		g = (float)d*5.1f;
		/* A Vari�vel d � do tipo double, por isso foi necess�rio realizar 
		o typecast para float, visto que a vari�vel g � do tipo float e s� pode receber float;
		o n�mero 5.1 � por padr�o double, pois todo n�mero decimal inserido no c�digo
		diretamente � do tipo double, sendo assim, tamb�m foi necess�rio realizar o typecast
		para float.
		*/
		
		System.out.println("A:  "+a);
		System.out.println("B:  "+b);
		System.out.println("C:  "+c);
		System.out.println("D:  "+d);
		System.out.println("F:  "+f);
		System.out.println("G:  "+g);
		
		
		
	}

}
