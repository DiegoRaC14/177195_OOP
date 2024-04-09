package examen3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutar {
	
	char [][] laberinto;
	
	public void iniciarPrograma () {
		
		Scanner sc = new Scanner(System.in); // Objeto tipo Scanner
		Archivo miArchivo = new Archivo();
		
		String nombreArchivo;
        
        try {
	         System.out.println("Ingrese el nombre del archivo que contiene el laberinto.");
	         System.out.print("(Debe estar en la misma carpeta que el programa y debe ser .txt): ");
	         nombreArchivo = sc.nextLine();
	         Laberinto miLaberinto = new Laberinto(nombreArchivo + ".txt");
	         
	         laberinto = miLaberinto.leerLaberinto(); // Método para leer el archivo
	         miLaberinto.imprimirLaberinto(); // Método para imprimir el laberinto en consola
	         
	         
	         Raton raton = new Raton(laberinto); //Crea un ratón y manda el laberinto obtenido de archivo .txt
	         ArrayList<String> ruta = raton.encontrarRuta(); //Guarda la lista
	         //System.out.println("Movimientos:" + ruta);
	         miArchivo.grabarArchivo(ruta, nombreArchivo);
	            
	         sc.close(); // Cerrar el Scanner
        } catch (IOException e) {
        	 e.printStackTrace();
        }
        
        System.out.println();
        System.out.println("El laberinto fue resuelto con éxito.");
        System.out.println("Puede ver el archivo .txt en la carpeta donde se encuentra el programa.");
		
	}

}
