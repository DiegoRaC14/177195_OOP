package herencia.abstraccion;

import java.util.Random;

public class Ejecucion {
	
	public void iniciarPrograma() {
		
		Random miRandom = new Random(); // Crea números pseudoaleatorios
		Mamifero miMamifero = new Mamifero();
		Pez miPez = new Pez();
		Ave miAve = new Ave();
		
		String[] arregloNombres = {"Flavio","Doradito", "Pequeñín", "Zeús", "Tritón", "Azul","Chispitas", "Manchitas", "Nala", "Spike",
				"Miki","Rufo", "Chiwis","Firulais", "Fito"};

		
		for (int i = 1; i <= 10; i++) {// Ciclo para tener 10 animales
			
			int opcion = miRandom.nextInt(1,4);// Dice qué animal generará
			
			String randomNombre = arregloNombres[miRandom.nextInt(arregloNombres.length)];
			int randomEdad = miRandom.nextInt(31);
			boolean randomHambre = miRandom.nextBoolean();
			
			switch (opcion){
			
			case 1: // Pez
				miPez.setNombre(randomNombre);
				miPez.setEdad(randomEdad);
				miPez.setHambre(randomHambre);
				
				System.out.println("Animal " + i + ": ");
				System.out.println(miPez.getNombre() + " es un pez de " + miPez.getEdad() + " años con escamas " + miPez.randomColorEscamas() + "."); 
				System.out.println(miPez.reproduccion() + ", " + miPez.randomTipoAgua(miRandom.nextBoolean()) + ".");
				System.out.println("Se alimenta de " + miPez.alimentarse() + " y " + miPez.randomHambre() + ".");
				System.out.println();
				break;
				
			case 2: // Ave
				miAve.setNombre(randomNombre);
				miAve.setEdad(randomEdad);
				miAve.setHambre(randomHambre);
				
				System.out.println("Animal " + i + ": ");
				System.out.println(miAve.getNombre() + " es un ave de " + miAve.getEdad() + " años con plumas " + miAve.randomColorPlumas()+ ".");
				System.out.println(miAve.reproduccion() + ", "+ miAve.volar(miRandom.nextBoolean()) + ".");
				System.out.println("Se alimenta de " + miAve.alimentarse() + " y " + miAve.randomHambre() + ".");
				System.out.println();
			break;
				
			case 3: // Mamífero
				miMamifero.setNombre(randomNombre);
				miMamifero.setEdad(randomEdad);
				miMamifero.setHambre(randomHambre);
				
				System.out.println("Animal " + i + ": ");
				System.out.println(miMamifero.getNombre() + " es un mamífero de " + miMamifero.getEdad() + " años con pelaje " + miMamifero.randomColorPelaje() + ".");
				System.out.println(miMamifero.reproduccion() + ", " + miMamifero.randomAmamantar(miRandom.nextBoolean()) + ".");
				System.out.println("Se alimenta de " + miMamifero.alimentarse() + " y " + miMamifero.randomHambre() + ".");
				System.out.println();
			break;
			
				
			}
		}
	}

}
