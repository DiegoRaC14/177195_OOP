package herencia.abstraccion;

import java.util.Random;

public class Mamifero extends Animal {// 2 atributos que no se repitan y sobreescribir el método
	
	Random miRandom = new Random();
	

	String colorPelaje = ""; // Inicializar variable
	String amamantar; 
	
	
	public String alimentarse() {// Rescribiendo el método abstracto
		return " come carne y plantas";
	}
	
	public String reproduccion() {
		return "Es vivíparo";
		
	}
	
	public String randomColorPelaje() {
		String[] arregloColorP = {"café fuerte", "café claro", "negro", "blanco", "gris", "rojizo"};
		String randomColorP1 = arregloColorP[miRandom.nextInt(arregloColorP.length)];
		String randomColorP2 = arregloColorP[miRandom.nextInt(arregloColorP.length)];
		
		if (randomColorP1 != randomColorP2) {
			colorPelaje = randomColorP1 + " y " + randomColorP2;
		} else {
			colorPelaje = randomColorP1;
		}
		
		return colorPelaje;
	}
	
	public String randomAmamantar(boolean randomOpcion) {
	if (randomOpcion == false) {
		amamantar = "ya no amamanta";
	}else{
		amamantar = "sigue amamantando";
	}
		
		return amamantar;
	}
	
	public String randomHambre() {
		String opcion;
		if (getHambre() == false) {
			opcion = "NO tiene hambre";
		}else {
			opcion = "tiene hambre";
		}
		
		return opcion;
	}
	
}
