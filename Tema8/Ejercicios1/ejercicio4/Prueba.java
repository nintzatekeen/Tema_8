package ejercicio4;

public class Prueba {
	public static void main(String[] args) throws FraccionException {
		try {
			Fraccion f=new Fraccion(15, 45);
			Fraccion f2=new Fraccion(2, 3);
			Fraccion f3 = new Fraccion(2, 3);
			f3.setNumerador(4);
			f3.setDenominador(0);
			System.out.println(f.sumar(f2).toString());
			System.out.println(f.restar(f2).toString());
			System.out.println(f.multiplicar(f2).toString());
			System.out.println(f.dividir(f2).toString());
			System.out.println(f.multiplicar(f3));
			System.out.println(f.sumar(f3));
		}catch(FraccionException fe) {
			System.out.println(fe.getMessage());
		}
	}
}
