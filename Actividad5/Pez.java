package herencia.abstraccion;

import java.util.Random;

public class Pez extends Animal {// 2 atributos que no se repitan y sobreescribir el método
	
	Random miRandom = new Random();
	
	String colorEscamas;
	String tipoAgua;
	

	public String alimentarse(){ //Reescrbir método abstracto
		return "plantas acuáticas u otros peces";
	}
	
	public String reproduccion(){
		return "Es ovíparo";

	}

	public String randomColorEscamas() {
		String[] arregloColorEscamas = {"doradas", "plateadas", "azules", "amarillas","rojas"};
		String colorEscamas = arregloColorEscamas[miRandom.nextInt(arregloColorEscamas.length)];
		
		return colorEscamas;
	}
	
	public String randomTipoAgua (boolean randomOpcion) {
		if (randomOpcion == false) {
			tipoAgua = "vive en agua salada";
		}else {
			tipoAgua = "vive en agua dulce";
		}
	return tipoAgua;
	}
	
	public String randomHambre () {
		String opcion;
		if (getHambre() == false) {
			opcion = "NO tiene hambre";
		}else {
			opcion = "tiene hambre";
		}
		
	return opcion;
	}
}
