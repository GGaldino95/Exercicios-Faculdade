package exercicio00;

public class Exercicio00 {

	public static void main(String[] args) {
		int a=5, b=3, c;
		double d=2.5, f=0;
		float g;
		
		
		c = a/b; //Como as variáveis são inteiras, o resultado será inteiro
		d += d/a; //Primeiro foi realizado a divisão de d/a, logo após  o cálculo, o resultado foi incrementado em d
		f -= a++/d;
		/*f não foi inicializado, por isso ele está como nulo, ao realizar -=, está tentando
		  fazer um decremento em f, sendo assim será necessário definir o valor inicial de f
		  para realizar o cálculo matemático;
		  
		  Cálculo:
		  f = f - (a/d);
		  a = a + 1;
		 */
		
		g = (float)d*5.1f;
		/* A Variável d é do tipo double, por isso foi necessário realizar 
		o typecast para float, visto que a variável g é do tipo float e só pode receber float;
		o número 5.1 é por padrão double, pois todo número decimal inserido no código
		diretamente é do tipo double, sendo assim, também foi necessário realizar o typecast
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
