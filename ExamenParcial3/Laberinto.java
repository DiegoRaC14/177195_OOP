package resolver.laberinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Laberinto {
	
	private static final char ABIERTO = '1';
	private static final char INTENTADO = '2';
	private static final char CAMINO = '#';
	
	private int numeroFilas = 0, numeroColumnas = 0;
	private int ultimaFila, ultimaColumna;
	private char [][] cuadricula;
	
	private String nombreArchivo;

	public Laberinto(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	 public char[][] leerLaberinto() throws IOException {
		 	 	
		File miArchivo = new File(nombreArchivo);

	    // Primera lectura: contar el número de filas para determinar el tamaño del arreglo
	    try (BufferedReader contadorFilas = new BufferedReader(new FileReader(miArchivo))) {
	    	while (contadorFilas.readLine() != null) {
	            numeroFilas++;
	            }
	    }

	     // Segunda lectura: contar el número de columnas a partir de la primera línea
	    try (BufferedReader contadorColumnas = new BufferedReader(new FileReader(miArchivo))) {
	    	
	        String contenidoLinea = contadorColumnas.readLine(); // Leer la primera línea del archivo
	        
	        if (contenidoLinea != null) { // Verificar si la línea leída no es nula
	            numeroColumnas = contenidoLinea.length(); // Longitud del contenido, así se checan las columnas
	            
	            cuadricula = new char[numeroFilas][numeroColumnas]; // Inicializar la cuadrícula con las dimensiones correctas

	            for (int i = 0; i < numeroFilas; i++) {// Llenar la matriz desde la primera línea del archivo

	                if (contenidoLinea != null) { //Checar si hay más líneas en el archivo
	                    for (int j = 0; j < numeroColumnas; j++) {
	                        cuadricula[i][j] = contenidoLinea.charAt(j);
	                    }
	                    contenidoLinea = contadorColumnas.readLine();// Leer la siguiente línea del archivo para la próxima iteración
	               
	                } else { // En caso de que no haya un elemento se llena con espacio
	                    for (int j = 0; j < numeroColumnas; j++) {
	                        cuadricula[i][j] = ' '; // Carácter especial que representa una celda vacía
	                    }
	                }
	            }
	        }
	    }
	    
	    System.out.println();
	    System.out.println("Número de filas: " + numeroFilas);
	    System.out.println("Número de columnas: " + numeroColumnas);
	      
	    
	    return cuadricula;
	}
	
	
	public void intentarPosicion(int fila, int columna) {
		cuadricula[fila][columna] = INTENTADO; 
	}
	
	public boolean checarSolucion(int fila, int columna) {
		boolean resultado = false;
		
	    for (int i = 0; i < numeroFilas; i++) {
	        for (int j = 0; j < numeroColumnas; j++) {
	            if (cuadricula[i][j] == 'F');
	            resultado = true;
	        }
	        System.out.println(); // Imprime una línea en blanco después de cada fila
	    }
	    
	    return resultado; // Devuelve true si se encontró el resultado y false si no
	}

	
	public boolean finalCuadricula(int fila, int columna) {
		if (fila == ultimaFila && columna == ultimaColumna) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean checarPosicionValida(int fila,int columna) {
		boolean resultado = false;
		
		if (fila >= 0 && fila < cuadricula.length && columna >= 0 && columna < cuadricula[0].length) { // Checamos que estemos dentro de la cuadrícula
			if (cuadricula[fila][columna] == ABIERTO) // Checamos si se puede pasar
				resultado = true;
		}

		return resultado;
		
	}
	
	// Getters
	public int getnumeroFilas() { // Getter del número de filas que hay
		return cuadricula.length;
	}
	
	
	public int getnumeroColumna() { // Getter del número de columnas que hay
		return cuadricula[0].length;
	}
	
	
	public void marcarCasilla (int fila, int columna) {
		cuadricula[fila][columna] = CAMINO;
	}
	
	
	public void imprimirLaberinto() {
	    for (int i = 0; i < numeroFilas; i++) {
	        for (int j = 0; j < numeroColumnas; j++) {
	            System.out.print(cuadricula[i][j]); // Utiliza print en lugar de println para imprimir en la misma línea
	        }
	        System.out.println(); // Imprime una línea en blanco después de cada fila
	    }
	}


}
