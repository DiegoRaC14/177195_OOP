package listas;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {
	
	private File archivo;

	public void ejecutar () {
		Fibonacci miSerie = new Fibonacci ();
		Splitter miSplitter = new Splitter();
		
		List <Integer> listaFibonacci = new ArrayList<Integer> (); // Crear listas e inicializarlas
		List <Integer> listaPares = new ArrayList<Integer> ();
		List <Integer> listaImpares = new ArrayList<Integer> ();
		
		HashMap <List <Integer>, String> miMapa = new HashMap <>(); // Para asignar una clave a cada lista
		
		listaFibonacci = miSerie.crearFibonacci(); // Guarda la serie de Fibonacci en una lista
		miMapa.put(listaFibonacci, "serieFibonacci"); // Asigna una cadena de texto a la lista 
		listaPares = miSplitter.numerosPares(listaFibonacci);
		miMapa.put(listaPares, "seriePares");
		listaImpares = miSplitter.numerosImpares(listaFibonacci);
		miMapa.put(listaImpares, "serieImpares");
		

		try {
			grabarSerie(listaFibonacci, miMapa.get(listaFibonacci));
			grabarSerie(listaPares, miMapa.get(listaPares));
			grabarSerie(listaImpares, miMapa.get(listaImpares));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Programa terminado con éxito. Puedes revisar los archivos en tu carpeta..." );
	}
	
	public void grabarSerie(List<Integer> lista, String nombreArchivo) throws IOException {
		
		archivo = new File (nombreArchivo + ".txt");
		
		if (archivo.exists()) {
			archivo.delete();
			System.out.println("El archivo " + archivo.getName() + " ya existía pero fue borrado para actualizar los números.");
		}
		
		
		try {
			if (archivo.createNewFile()) { // Intento crear el archivo
				
				
				try {
					FileWriter escritura = new FileWriter(archivo);
					
					for (int numero: lista) { // Se escriben los números en el documento
						escritura.write(numero + System.lineSeparator());
					}
					escritura.close(); // Cerrar el flujo de información 
					System.out.println("Los números de " + nombreArchivo + " se grabaron con éxito.");
					System.out.println();
					
					
				} catch (IOException e) {
					e.getMessage();
				}
				
			} else {
                System.out.println("Error al crear el archivo.");
                System.out.println();
			}
			
		} catch (IOException e) {
			e.getMessage();
		}	
		
		
	}
}
