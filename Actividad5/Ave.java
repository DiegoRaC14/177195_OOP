package herencia.abstraccion;

import java.util.Random;

public class Ave extends Animal {// 2 atributos que no se repitan y sobreescribir el método
	
	Random miRandom = new Random();
	
	String colorPlumas;
	boolean volar;
	
	
	public String alimentarse() { // Reescribir el método abstracto
		return "insectos, plantas y semillas";	
	}
	
	public String reproduccion(){
		return "Es ovíparo";
	}
	
	public String randomColorPlumas() {
		String[] arregloColorPlumas = {"negras", "cafés", "rojas", "verdes", "azules", "grises", "blancas", "amarillas"};
		String colorPlumas = arregloColorPlumas[miRandom.nextInt(arregloColorPlumas.length)];
		
		return colorPlumas;
	}
	
	public String volar (boolean randomOpcion) {
		String volar;
		if (randomOpcion == false) {
			volar = "NO puede volar";
		}else {
			volar = "sí puede volar";
		}
		
	return volar;
	}
	
	public String randomHambre() {
		String opcion;
		if(getHambre() == false) {
			opcion = "NO tiene hambre";
		}else {
			opcion = "tiene hambre";
		}
		
	return opcion;
	}
}
