package actividad.aleatorio;

import java.util.Random;

public class Aleatorio {
    
    Random miRandom = new Random();// Objeto tipo random para acceder a los métodos


	public void imprimirNombres(String[] arregloNombres) {
		
		boolean[] checarNombres = new boolean [arregloNombres.length]; // Arreglo de booleanos con tamaño del arreglo de nombres
		int contador = 1; // Imprimir todos los nombres
		int numAleatorio = 0;
		
		while (contador < arregloNombres.length + 1) {
			
			numAleatorio = miRandom.nextInt(arregloNombres.length); // Crea num aleatorio entre 0 y longitud de arreglo
			
			if (!checarNombres[numAleatorio]) {
				System.out.println("Nombre " + contador + ": " + arregloNombres[numAleatorio]);
				contador ++;
				checarNombres[numAleatorio] = true;
				
			}
		}
	}
	
	public void imprimirCondiciones(String[] arregloNombres, char condicion, int posicion) {
	    boolean bandera = false;
	    String nombre;

	    for (int i = 0; i < arregloNombres.length; i++) {
	    	
	    	nombre = arregloNombres[i];
	        if (nombre.length() >= posicion) {
	        	
	            if (nombre.toLowerCase().charAt(posicion - 1) == condicion) {
	                System.out.println(nombre);
	                bandera = true;
	            }
	        }
	    }

	    if (!bandera) {//No se cumplen las condiciones dadas
	        System.out.println("No hay nombres que cumplan las características dadas.");
	    } 
	}
	
	
    public void imprimirAtributos(Circulo[] miCirculo, String eleccion1, String eleccion2) {
    	boolean bandera = false;
    	int indiceArreglo = miRandom.nextInt(miCirculo.length);
    	
    	
    	if (miCirculo[indiceArreglo].color.toLowerCase() == eleccion1 || miCirculo[indiceArreglo].color.toLowerCase() == eleccion2) {

    		System.out.println("El radio del círculo es: " + miCirculo[indiceArreglo].radio);
    	}else {
    		System.out.println("El círculo no es " + eleccion1 + " ni " + eleccion2);
    	}

    }
	
	

}
