package actividad.aleatorio;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Random miRandom = new Random();// Objeto tipo random para acceder a los métodos
		Aleatorio ejecutar = new Aleatorio();// Objeto tipo aleatorio
		Scanner sc = new Scanner(System.in); // Objeto tipo scaner
		
		/* Punto 1*/
		String[] arregloNombres = {"Daniel", "Diego", "Cándida", "Nicolás", "Bruno", "Jatziri",
	   "Samuel","Samantha", "Jesús", "Paola", "Alma", "Oswaldo", "Santiago", "Lizett","César"};

		System.out.println("Lista de nombres generada aleatoriamente:");
		ejecutar.imprimirNombres(arregloNombres);
		
		
		/* Punto 2 */
		
		Circulo[] miCirculo = new Circulo[10]; 
		
		miCirculo[0] = new Circulo ("verde", 23.6);
		miCirculo[1] = new Circulo ("azul", 72.5);
		miCirculo[2] = new Circulo ("morado", 8.9);
		miCirculo[3] = new Circulo ("azul", 1.50);
		miCirculo[4] = new Circulo ("rojo", 11.23);
		miCirculo[5] = new Circulo ("verde", 3.06);
		miCirculo[6] = new Circulo ("naranja", 88.88);
		miCirculo[7] = new Circulo ("azul", 59.04);
		miCirculo[8] = new Circulo ("amarillo", 31.00);
		miCirculo[9] = new Circulo ("verde", 56.467);
		
		String eleccion1 = "verde";
		String eleccion2 = "azul";
		System.out.println();
		ejecutar.imprimirAtributos(miCirculo, eleccion1, eleccion2);

		
		/* Punto 3 */
		
		int posicion;
		char caracter;
		String cadena;
		
		System.out.println();
		System.out.println();
		System.out.println("Bienvenid@ al menú de opciones");
		
		System.out.println("Ingrese el caracter (en minúsculas) que deseé que tenga el nombre:");
		cadena = sc.next();
		caracter = cadena.charAt(0);
	
		System.out.println("Ingrese la posición en la que debe estar la letra:");
		posicion = sc.nextInt();
		

		ejecutar.imprimirCondiciones(arregloNombres,caracter,posicion);
		
		
		sc.close();// Cerrar flujo
	}
}
