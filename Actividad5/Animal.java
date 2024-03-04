package herencia.abstraccion;

import java.util.Random;

public abstract class Animal { // Clase abstracta 
	
	
	/*Debe tener 2 métodos (al menos uno abstracto y uno protegido) y 3 atributos(solo private y
	 se puede tener acceso a ellos mediante setters y getters
	*/
	Random miRandom = new Random();
	
	private String nombre;
	private int edad;
	private boolean hambre;

	
	public abstract String alimentarse();// Firma del método sin implementar
	protected abstract String reproduccion();

	// Getters y setters
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setHambre(boolean hambre) {
		this.hambre = hambre;	
	}
	
	public boolean getHambre(){
		return hambre;
	}
	

}
