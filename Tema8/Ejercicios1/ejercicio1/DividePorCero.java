package ejercicio1;

import java.io.IOException;

public class DividePorCero {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int e1=0, e2=0;
		try {
			System.out.println("Introduzca un entero:");
			e1=Consola2.leeInt();
		}catch(NumberFormatException nfe) {
			System.out.println("Error: El número no es un entero");
		}
		try {
			System.out.println("Introduzca el segundo entero:");
			e2=Consola2.leeInt();
		}catch(NumberFormatException nfe2) {
			System.out.println("Error: El número no es un entero");
		}
		
		try {
			System.out.println(e1+"/"+e2+"="+(e1/e2));
		}catch(ArithmeticException ae) {
			System.out.println("Error: división por cero");
		}
	}
}
