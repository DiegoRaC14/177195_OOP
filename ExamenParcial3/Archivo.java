package examen3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {

	public void grabarArchivo(ArrayList<String> movimientos, String nombreArchivo) {
		
		File archivo = new File (nombreArchivo + "_movimientos.txt");
		
		if (archivo.exists()) { // Checa si el archivo existe
			archivo.delete();
			System.out.println();
			System.out.println("El archivo " + archivo.getName() + " ya existía pero fue borrado para actualizar los números.");
		} else {
			
			try {
				if (archivo.createNewFile()) { // Intenta crear el nuevo archivo
					try {
						FileWriter escritura = new FileWriter(archivo);	
						
						for (String indicacion: movimientos) {
							escritura.write(indicacion + System.lineSeparator());
						}
						escritura.close();
						System.out.println();
						System.out.println("La indicaciones de " + nombreArchivo + ".txt se grabaron con éxito.");
						System.out.println();
					} catch (IOException e) {
						e.getMessage();
					
					}
				} else {
					System.out.println("No se pudieron escribir las indicaciones en el archivo" + archivo.getName());
				}
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}
	
}
