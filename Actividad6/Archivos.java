package guess.who.archivos;

import java.util.Scanner;
import java.io.*;

public class Archivos {

    Scanner sc = new Scanner(System.in);
    File archivo;

    public String obtenerUsername() {
        System.out.println("¿Quién eres?");
        System.out.print("Ingresa tu nombre de usuario: ");
        String username = sc.nextLine();
        System.out.println();
        username = username.toLowerCase();
        return username;
    }

    public void crearArchivo(String username) {
        archivo = new File(username + ".txt");
        int[]actualizarNums = {0,0};
        try {
            if (archivo.exists()) {
                System.out.println();
                System.out.println("Bienvenid@ de nuevo " + username + ". Cargando tus datos...");
                System.out.println();
            } else {
                if (archivo.createNewFile()) {
                    System.out.println("El archivo " + archivo.getName() + " para almacenar tus datos fue creado con éxito.");
                    System.out.println();
                    
                    try {
                        FileWriter escritura = new FileWriter(archivo);
                        escritura.write(actualizarNums[0] + System.lineSeparator());
                        escritura.write(actualizarNums[1] + System.lineSeparator());
                        escritura.close();
                    } catch (IOException excepcion) {
                        excepcion.getMessage();
                    }
                    
                } else {
                    System.out.println("Error al crear el archivo con tus datos.");
                    System.out.println();
                }
            }
        } catch (IOException excepcion) {
            excepcion.printStackTrace(System.out);
        }
    }

    public void actualizarNumArchivo(int partidasGanadas) {
        int[] actualizarNums = {0, 0}; 
        String contenido;
        
        try {
            FileReader archivoLector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(archivoLector);
            contenido = lectura.readLine(); 
            actualizarNums[0] = Integer.parseInt(contenido) + 1; 

            while ((contenido = lectura.readLine()) != null) { 
                actualizarNums[1] = Integer.parseInt(contenido) + partidasGanadas; 
            }

            lectura.close(); // Cerrar el BufferedReader después de su uso
        } catch (IOException | NumberFormatException excepcion) {
            excepcion.getMessage(); 
        }

        try {
            FileWriter escritura = new FileWriter(archivo);
            escritura.write(actualizarNums[0] + System.lineSeparator());
            escritura.write(actualizarNums[1] + System.lineSeparator());
            escritura.close();
        } catch (IOException excepcion) {
            excepcion.getMessage();
        }

        System.out.println();
        System.out.println("Total de partidas jugadas: " + actualizarNums[0]);
        System.out.println("Total de partidas ganadas: " + actualizarNums[1]);
        System.out.println("Total de partidas perdidas: " + (actualizarNums[0] - actualizarNums[1]));
    }
}

