package ejercicio5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import ejercicio1.Consola;

public class Principal {
	public static boolean evaluaComercial(Comercial com) throws ErrorComercialException {
		if (com.getSalario() < 0) {
			throw new ErrorComercialException("El salario no puede ser negativo");
		}
		if (com.getTelefono() == null) {
			throw new ErrorComercialException("No existe teléfono para este comercial");
		}
		if (verificarNum(com.getTelefono()) != true) {
			throw new ErrorComercialException("Teléfono no válido");
		}
		return true;
	}

	public static boolean verificarNum(TelefonoMovil tel) {
		String movil = tel.getNumero();
		for (int i = 0; i < movil.length(); i++) {
			if ((movil.charAt(i) < '0') || (movil.charAt(i) > '9')) {
				return false;
			}
		}
		return true;
	}

	public static void grabarComerciales(File f) {
		char resp;
		try {

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			try {
				//este try es para cerrar en caso de error el oos
				do {
					System.out.println("Introduzca nombre del comercial:");
					String nom = Consola.leeString();
					System.out.println("Introduzca el salario del comercial:");
					float sal = Consola.leeFloat();
					System.out.println("Introduzca el número de móvil del comercial");
					String tel = Consola.leeString();
					System.out.println("Introduzca el saldo del móvil del comercial");
					float saldo = Consola.leeFloat();
					TelefonoMovil nuevo2 = new TelefonoMovil(tel, saldo);
					Comercial nuevo = new Comercial(nom, sal, nuevo2);
					try {
						if (evaluaComercial(nuevo)) {
							oos.writeObject(nuevo);
						}
					} catch (ErrorComercialException ece) {
						System.out.println(ece.getMessage());
					}
					do {
						System.out.println("¿Desea continuar? S/N");
						resp = Consola.leeChar();
					} while ((resp != 's') && (resp != 'n') && (resp != 'S') && (resp != 'N'));
				} while ((resp != 'n') && (resp != 'N'));
				//oos.writeObject(null);
				//oos.close();
			}catch(FileNotFoundException fnfe0) {
				System.err.println("Archivo no encontrado");
			}
			catch(IOException ioe0) {
				System.err.println("Fallo de IO");
			}
			finally {
				oos.writeObject(null);
				oos.close();
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public static boolean repetido(String nom, ArrayList<Comercial> arr) {
		for (Comercial c : arr) {
			if (c.getNombre().equals(nom))
				return true;
		}
		return false;
	}

	public static HashMap<String, TelefonoMovil> generarMapaMoviles(ArrayList<Comercial> arr) {
		HashMap<String, TelefonoMovil> aux = new HashMap<String, TelefonoMovil>();
		for (Comercial c : arr) {
			aux.put(c.getNombre(), c.getTelefono());
		}
		return aux;
	}

	public static void buscaMovil(HashMap<String, TelefonoMovil> h) throws Exception {
		System.out.println("Introduzca nombre de comercial");
		String resp = Consola.leeString();
		if (!h.containsKey(resp)) {
			throw new Exception("Comercial no existente");
		} else {
			System.out.println(h.get(resp).toString());
		}
	}

	public static void main(String[] args) {
		System.out.println("Introduzca nombre de fichero:");
		String nomfich = Consola.leeString();
		File f = new File(nomfich);
		grabarComerciales(f);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			try {
				//try para cerrar el ois
				ArrayList<Comercial> lista = new ArrayList<Comercial>();
				Comercial aux = null;
				try {
				aux = (Comercial) ois.readObject();
				}catch(ClassNotFoundException cnfe1) {
					System.out.println(cnfe1.getMessage());
				}
		
				while (aux != null) {
					if (!repetido(aux.getNombre(), lista)) {
						lista.add(aux);
					}
					try {
						aux = (Comercial) ois.readObject();
					} catch (ClassNotFoundException e) {
						System.out.println(e.getMessage());
					}
				}
				//ois.close();
				HashMap<String, TelefonoMovil> mapa = Principal.generarMapaMoviles(lista);
				try {
					Principal.buscaMovil(mapa);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
			}catch(IOException ioe0) {
				System.out.println("Excepción IO");
			}
			finally {
				ois.close();
			}	
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

}
