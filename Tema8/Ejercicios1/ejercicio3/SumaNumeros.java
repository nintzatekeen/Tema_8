package ejercicio3;

public class SumaNumeros {
	public static void main(String[] args) {
		int sum=0;
		int nosumados=0;
		for(int i=0; i<args.length; i++) {
			try {
				sum=sum+Integer.parseInt(args[i]);
			}catch(NumberFormatException nfe) {
				System.out.println(args[i]+" no se puede sumar");
				nosumados++;
			}
		}
		System.out.println("Suma="+sum+", no sumados: "+nosumados);
	}
}
