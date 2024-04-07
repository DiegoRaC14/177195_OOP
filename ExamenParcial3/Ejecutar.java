package resolver.laberinto;

import java.io.IOException;
import java.util.Scanner;

public class Ejecutar {
    
    //public static String filePath = "C:Users\diego\eclipse-workspace\ExamenParcial3.Resolver.Laberinto"; // Verifica la ruta
    
    public void iniciarPrograma() {
    	
        Scanner sc = new Scanner(System.in); // Objeto tipo Scanner
        
        try {
         System.out.println("Ingrese el nombre del archivo que contiene el laberinto.");
         System.out.print("(Debe estar en la misma dirección que el rograma): ");
         //String nombreArchivo = sc.nextLine();
         Laberinto miLaberinto = new Laberinto("LaberintoEjemplo.txt");
         
         miLaberinto.leerLaberinto(); // Método para leer el archivo
         miLaberinto.imprimirLaberinto(); // Método para imprimir el laberinto en consola
            
         sc.close(); // Cerrar el Scanner
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
    }
}

