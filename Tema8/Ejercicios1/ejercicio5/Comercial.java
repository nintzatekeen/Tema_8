package ejercicio5;

import java.io.Serializable;

public class Comercial implements Serializable{
	private String nombre;
	private float salario;
	private TelefonoMovil telefono;
	public Comercial(String nom, float sal, TelefonoMovil tlf) {
		nombre=nom;
		salario=sal;
		telefono=tlf;
	}
	public Comercial(String nom, float sal) {
		nombre=nom;
		salario=sal;
	}
	public void asignarTelefono(TelefonoMovil asignado) {
		telefono=asignado;
	}
	public void ver() {
		System.out.println("Comercial:\n\tnombre:"+nombre+"\n\tsalario"+salario);
		if(telefono!=null) {
			System.out.println("\t"+telefono.toString());
		}
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public void setTelefono(TelefonoMovil telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public float getSalario() {
		return salario;
	}
	public TelefonoMovil getTelefono() {
		return telefono;
	}
}
