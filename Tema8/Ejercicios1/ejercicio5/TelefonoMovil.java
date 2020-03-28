package ejercicio5;

import java.io.Serializable;

public class TelefonoMovil implements Serializable{
	private String numero;
	private float saldo;
	public TelefonoMovil(String num, float sal) {
		numero=num;
		saldo=sal;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNumero() {
		return numero;
	}
	@Override
	public String toString() {
		return "Teléfono movil | número:" + numero + ", saldo:" + saldo + "]";
	}
	
}
