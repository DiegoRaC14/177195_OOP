package guess.who;

import java.util.Random; // Librería random
import java.util.Scanner;

public class Menu {
	
	
	Random miRand = new Random(); // Creación de un objeto random
	Scanner sc = new Scanner(System.in);

	public Pokemon[] nuevoArregloP; // Se crea un nuevo arreglo después de cada método con pokemones actualizados
	
	String ANSI_RESET = "\033[0m" ;
	String ANSI_BLACKB = "\033[1;30m"; //Black bold
	String ANSI_GREENBACK = "\033[42m";  // Green background
	String ANSI_REDB = "\033[1;31m"; // Red bold
	
	
	public void mostrarPreguntas (Pokemon[] arrPokemonesRand, int indexPGanador, String [] arrAtaques, Pokemon pokemonGanador, int intento) {
		
		this.nuevoArregloP = arrPokemonesRand; // Actualizar la lista
		
		int eleccion = 0; // Para las primeras preguntas
		int opcion = 0;
		String opcionTexto;
		
		if (intento == 5) {
			eleccion = 4;
		}else {
			System.out.println();
			System.out.println("¿Qué deseas hacer ahora?");
			System.out.println();
			
			System.out.println("1: Escoger tipo del Pokemon");
			System.out.println("2: Escoger ataque del Pokemon");
			System.out.println("3: Adivinar Pokemon");
			System.out.print("Introduce el número de tu elección: ");
			eleccion = sc.nextInt();
		}
			
			switch(eleccion)
			{
			case 1:
				System.out.println();
				System.out.println("¿De qué tipo crees que es tu Pokémon?");
				System.out.println("1: Agua");
				System.out.println("2: Fuego");
				System.out.println("3: Planta");
				System.out.print("Elección: ");
				opcion = sc.nextInt();
			
				tipoPokemon(opcion, arrPokemonesRand, pokemonGanador);
				break;
			
			
			case 2:
				int contador = 1;
				System.out.println();
				System.out.println("¿Qué ataque piensas que tiene tu Pokémon?");
				for (String ataque: arrAtaques) { // Muestra todos los ataques
					System.out.println(contador+ ": " + ataque);
					contador++;
				}
				System.out.print("Elección: ");
				opcion = sc.nextInt();
				
				ataquePokemon(opcion, arrPokemonesRand, arrAtaques, pokemonGanador);
				break;
		
				
			case 3:
				System.out.println();
				System.out.println("¿Cuál es el nombre de tu pokemon?");
				System.out.print("Elección: ");
				opcionTexto = sc.next();
				opcionTexto.toLowerCase();
				
				nombrePokemon(opcionTexto, arrPokemonesRand, pokemonGanador);
				break;
		
			case 4:
				System.out.println();
				System.out.println(ANSI_REDB + "OJO: ÚLTIMA OPORTUNIDAD" + ANSI_RESET);
				System.out.println("Elige el nombre de un Pokemon");
				System.out.print("Elección: ");
				opcionTexto = sc.next();
				opcionTexto.toLowerCase();
				
				nombrePokemon(opcionTexto, arrPokemonesRand, pokemonGanador);
				break;
		}
	}
	
	public Pokemon [] tipoPokemon(int opcion, Pokemon[] arrPokemonesRand, Pokemon pokemonGanador) {
	    String opcionL;

	    if (opcion == 1) {
	        opcionL = "(agua)";
	    } else if (opcion == 2) {
	        opcionL = "(fuego)";
	    } else {
	        opcionL = "(planta)";
	    }
	    
	    if (pokemonGanador.getTipo().equals(opcionL)) {// Checar si el tipo coincide con la opción que se eligió
	        System.out.println();
	        System.out.println("¡Correcto! Te vas acercando");
	        
	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones del tipo seleccionado
	            if (pokemon.getTipo().equals(opcionL)) {
	                contador++;
	            }
	        }

	        nuevoArregloP = new Pokemon[contador]; // Inicializar el arreglo con tamaño adecuado
	        contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) {//Copiar pokemones que sean del tipo que se pide
	            if (pokemon.getTipo().equals(opcionL)) {
	                nuevoArregloP[contador] = pokemon;
	                contador++;
	            }
	        }

	        mostrarMenu(nuevoArregloP); // Mostrar pokemones restantes 
	        
	    } else {
	        System.out.println();
	        System.out.println("¡Incorrecto! El pokemon NO tiene el ataque " + opcionL);

	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones del tipo seleccionado
	            if (!pokemon.getTipo().equals(opcionL)) {
	                contador++;
	            }
	        }

	        nuevoArregloP = new Pokemon[contador]; // Inicializar el arreglo con tamaño adecuado
	        contador = 0;

	        // Copiar los Pokémon que no sean del tipo seleccionado al nuevo arreglo
	        for (Pokemon pokemon : arrPokemonesRand) {
	            if (!pokemon.getTipo().equals(opcionL)) {
	                nuevoArregloP[contador] = pokemon;
	                contador++;
	            }
	        }

	        mostrarMenu(nuevoArregloP); // Mostrar pokemones restantes 
	    }
	   return nuevoArregloP; 
	}
	
	public Pokemon[] ataquePokemon(int opcion, Pokemon[] arrPokemonesRand, String[] arrAtaques, Pokemon pokemonGanador) {
	    String opcionL = "";
	    switch (opcion) {
	        case 1:
	            opcionL = "Hydro pump";
	            break;
	        case 2:
	            opcionL = "Solar beam";
	            break;
	        case 3:
	            opcionL = "Eruption";
	            break;
	        case 4:
	            opcionL = "Flamethrower";
	            break;
	        case 5:
	            opcionL = "Aqua Jet";
	            break;
	        case 6:
	            opcionL = "Whirpool";
	            break;
	        case 7:
	            opcionL = "Synthesis";
	            break;
	        case 8:
	            opcionL = "Petal Dance";
	            break;
	    }
	    
	    String[] ataqueGanador = pokemonGanador.getAtaques();
	    String at1 = ataqueGanador[0];
	    String at2 = ataqueGanador[1];
	    String at3 = ataqueGanador[2];
	    String at4 = ataqueGanador[3];
	 
	    
	    if (at1.equals(opcionL) || at2.equals(opcionL) || at3.equals(opcionL) || at4.equals(opcionL)) {
	        System.out.println();
	        System.out.println("¡Correcto! Te vas acercando");
	        
	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones que tienen el ataque seleccionado
	            String[] ataquesPokemon = pokemon.getAtaques();
	            boolean tieneAtaque = false;
	            for (String ataque : ataquesPokemon) {
	                if (ataque.equals(opcionL)) {
	                    tieneAtaque = true;
	                    break;
	                }
	            }
	            if (tieneAtaque) {
	                contador++;
	            }
	        }

	        nuevoArregloP = new Pokemon[contador]; // Inicializar el arreglo con tamaño adecuado
	        contador = 0;

	        // Copiar los Pokémon que tienen el ataque seleccionado al nuevo arreglo
	        for (Pokemon pokemon : arrPokemonesRand) {
	            String[] ataquesPokemon = pokemon.getAtaques();
	            boolean tieneAtaque = false;
	            for (String ataque : ataquesPokemon) {
	                if (ataque.equals(opcionL)) {
	                    tieneAtaque = true;
	                    break;
	                }
	            }
	            if (tieneAtaque) {
	                nuevoArregloP[contador] = pokemon;
	                contador++;
	            }
	        }
	        
	        mostrarMenu(nuevoArregloP); // Mostrar pokemones restantes 
	    } else {
	        System.out.println();
	        System.out.println("¡Incorrecto! El pokemon NO tiene el ataque " + opcionL);
	        
	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones que no tienen el ataque seleccionado
	            boolean tieneAtaque = false;
	            for (String ataque : pokemon.getAtaques()) {
	                if (ataque.equals(opcionL)) {
	                    tieneAtaque = true;
	                    break;
	                }
	            }
	            if (!tieneAtaque) {
	                contador++;
	            }
	        }

	        nuevoArregloP = new Pokemon[contador]; // Inicializar el arreglo con tamaño adecuado
	        contador = 0;

	        // Copiar los Pokémon que NO tienen el ataque seleccionado al nuevo arreglo
	        for (Pokemon pokemon : arrPokemonesRand) {
	            boolean tieneAtaque = false;
	            for (String ataque : pokemon.getAtaques()) {
	                if (ataque.equals(opcionL)) {
	                    tieneAtaque = true;
	                    break;
	                }
	            }
	            if (!tieneAtaque) {
	                nuevoArregloP[contador] = pokemon;
	                contador++;
	            }
	        }
	        
	        mostrarMenu(nuevoArregloP); // Mostrar pokemones restantes 
	    }
	    
	    return nuevoArregloP; 
	}

	
	public Pokemon[] nombrePokemon(String opcion, Pokemon[] arrPokemonesRand, Pokemon pokemonGanador) {
	 
		this.nuevoArregloP = arrPokemonesRand;
		
	    if (opcion.equalsIgnoreCase(pokemonGanador.getNombre())) { // Usar equalsIgnoreCase para comparar cadenas sin importar mayúsculas o minúsculas
	        System.out.println();
	        System.out.println(ANSI_GREENBACK + ANSI_BLACKB + "¡Correcto! ¡GANASTEEEEEEEEE!");
	        System.out.println("El Pokemon era: " + pokemonGanador.getNombre() + pokemonGanador.getTipo() + ANSI_RESET);
	        
	        System.exit(0); // Terminar el programa
	        
	        nuevoArregloP = new Pokemon[1]; // Inicializar el arreglo con el tamaño adecuado
	        
	        
	    } else {
	        System.out.println();
	        System.out.println("¡Incorrecto!");

	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones que no coinciden con el nombre seleccionado
	            if (!pokemon.getNombre().equalsIgnoreCase(opcion)) {
	                contador++;
	            }
	        }

	        nuevoArregloP = new Pokemon[contador]; // Inicializar el arreglo con el tamaño adecuado
	        contador = 0;

	        // Copiar los Pokémon que no coinciden con el nombre seleccionado al nuevo arreglo
	        for (Pokemon pokemon : arrPokemonesRand) {
	            if (!pokemon.getNombre().equalsIgnoreCase(opcion)) {
	                nuevoArregloP[contador] = pokemon;
	                contador++;
	            }
	        }

	        mostrarMenu(nuevoArregloP); // Mostrar pokemones restantes 
	    }
	    return nuevoArregloP;
	}
	

    public Pokemon[] mostrarMenu(Pokemon[] nuevoArregloP) {
        
    	System.out.println("Pokemones restantes:");
        System.out.println();

        for (int i = 0; i < nuevoArregloP.length; i++) {
            System.out.print(nuevoArregloP[i].getNombre() + " " + nuevoArregloP[i].getTipo() + ": ");

            String[] ataques = nuevoArregloP[i].getAtaques(); // Obtener ataques

            for (int j = 0; j < ataques.length; j++) {
                System.out.print(ataques[j]);

                if (j < ataques.length - 1) { // Condición para comas
                    System.out.print(", ");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        return nuevoArregloP;
    }	

}
