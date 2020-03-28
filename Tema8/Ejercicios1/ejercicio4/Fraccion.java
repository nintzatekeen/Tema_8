package ejercicio4;

public class Fraccion {
	private int numerador, denominador;
	public Fraccion(int num, int den) throws FraccionException {
			numerador=num;
			denominador=den;
			if(denominador==0) {
				throw new FraccionException("No se puede instanciar fracción con denom 0");
			}
	}
	@Override
	public String toString() {
		return "Fraccion [numerador=" + numerador + ", denominador=" + denominador + "]";
	}
	public Fraccion sumar (Fraccion otrafraccion) throws FraccionException {
		int den=otrafraccion.denominador*this.denominador;
		int num=otrafraccion.numerador*(den/otrafraccion.denominador)+this.numerador*(den/this.denominador);
		Fraccion nuevafraccion=new Fraccion(num, den);
		nuevafraccion.simplificar();
		return nuevafraccion;
	}
	public Fraccion restar (Fraccion otrafraccion) throws FraccionException {
		Fraccion aux=new Fraccion(otrafraccion.numerador, -otrafraccion.denominador);
		return sumar(aux);
	}
	public Fraccion multiplicar(Fraccion otrafraccion) throws FraccionException {
		if(denominador*otrafraccion.denominador==0) {
			throw new FraccionException("El resultado de esta operación es una fracción inválido");
		}
		Fraccion nuevafraccion = new Fraccion(otrafraccion.numerador, otrafraccion.denominador);
		nuevafraccion.numerador=numerador*otrafraccion.numerador;
		nuevafraccion.denominador=denominador*otrafraccion.denominador;
		nuevafraccion.simplificar();
		return nuevafraccion;
	}
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}
	public Fraccion dividir (Fraccion otrafraccion) throws FraccionException {
		if((denominador==0)||(otrafraccion.denominador==0)) {
			throw new FraccionException("El resultado de esta operación es una fracción inválido");
		}
		Fraccion aux=otrafraccion;
		int aux1=aux.denominador;
		aux.denominador=aux.numerador;
		aux.numerador=aux1;
		return multiplicar(aux);
		
		
	}
	
	
	public void simplificar () {
		int min=Math.min(Math.abs(numerador), Math.abs(denominador));
		int max=Math.max(Math.abs(numerador), Math.abs(denominador));
		boolean simplificada=false;
		if(max%min==0) {
			numerador=numerador/min;
			denominador=denominador/min;
			simplificada=true;
		}
		for(int i=min/2;(i>=2)&&(simplificada==false);i--) {
			if((numerador%i==0)&&(denominador%i==0)){
				numerador=numerador/i;
				denominador=denominador/i;
				simplificada=true;
			}
		}
	}
}
