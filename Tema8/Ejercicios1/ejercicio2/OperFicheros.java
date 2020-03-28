package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import ejercicio1.Consola;

public class OperFicheros {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Introduzca nombre de fichero");
		String nomfich=Consola.leeString();
		
	}
	public static int compruebaTamanio(String nomfich){
		try {
			FileInputStream fis=null;
			try {
				fis=new FileInputStream(nomfich);
				return fis.available();
			}catch(FileNotFoundException fnfe) {
				System.out.println("Archivo no encontrado");
				return -1;
			}
			catch(IOException ioe) {
				System.out.println("Excepción IO");
				return -1;
			}
			finally {
				fis.close();
			}
		}catch(IOException ioe1) {
			System.out.println("Error catastrófico");
			return -1;
		}
	}
}
