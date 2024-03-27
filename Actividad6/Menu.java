package guess.who.archivos;

import java.util.Random; // Libreria random
import java.util.Scanner;

public class Menu {
	
	
	Random miRand = new Random(); // Creación de un objeto random
	Scanner sc = new Scanner(System.in); // Creación de un objeto scanner
	Archivos misArchivos = new Archivos();

	public Pokemon[] nuevoArregloP; // Se crea un nuevo arreglo después de cada método con pokemones actualizados
	
	// Colores
	String ANSI_RESET = "\033[0m" ;
	String ANSI_BLACKB = "\033[1;30m"; //Black bold
	String ANSI_GREENB = "\033[1;32m"; // Green bold
	String ANSI_REDB = "\033[1;31m"; // Red bold
	String ANSI_CYANB = "\033[1;36m"; // Cyan Bold
	String ANSI_GREENBACK = "\033[42m";  // Green background
	
	public boolean banderaArchivos = false; //Para manejar los archivos desde la clase ejecutar
	
	
	public void mostrarPreguntas (Pokemon[] arrPokemonesRand, int indexPGanador, String [] arrAtaques, Pokemon pokemonGanador, int intento) {
		
		this.nuevoArregloP = arrPokemonesRand; // Actualizar la lista
		
		int eleccion = 0; // Para escoger el primer menú
		int opcion = 0;
		String opcionTexto;
		
		if (intento == 5) { // Si se manda que el intento es el 5to se manda automáticamente a  la eleccion 4
			eleccion = 4;
		}else {				
			
			do {
				System.out.println();
				System.out.println(ANSI_CYANB + "Intento " + intento + ":" + ANSI_RESET);
				System.out.println("¿Qué deseas hacer ahora?");
				System.out.println();
					
				System.out.println("1: Escoger tipo del Pokemon");
				System.out.println("2: Escoger ataque del Pokemon");
				System.out.println("3: Adivinar Pokemon");
				System.out.print("Introduce el número de tu elección: ");	
				
				try {
					eleccion = Integer.parseInt(sc.nextLine());
						
					if (eleccion < 1 || eleccion > 3) {
						System.out.println();
						System.out.println(ANSI_REDB + " ❌ " + ANSI_RESET + "Introduce un valor entre 1 y 3.");
					}
						
				} catch (NumberFormatException exception ) {
					System.out.println();
					System.out.println(ANSI_REDB + " ❌ " + ANSI_RESET + "Introduce un número entero.");
					//System.out.println(exception.getMessage()); //Mostrar mensaje de excepción en consola
				}
			} while (eleccion < 1 || eleccion > 3);
		} 
			
		
		switch(eleccion){
			case 1:
				do {
					System.out.println();
					System.out.println("¿De qué tipo crees que es tu Pokemon?");
					System.out.println("1: Agua");
					System.out.println("2: Fuego");
					System.out.println("3: Planta");
					System.out.print("Elección (ingresa un número entero): ");
					
					try {
						opcion = Integer.parseInt(sc.nextLine());
				
						if (opcion < 1 || opcion > 3 ) {
							System.out.println();
							System.out.println(ANSI_REDB + " ❌ " + ANSI_RESET + "Introduce un valor entre 1 y 3.");
						} else{
							tipoPokemon(opcion, arrPokemonesRand, pokemonGanador); // Llama al método tipoPokemon
						}
					} catch (NumberFormatException exception) {
						System.out.println();
						System.out.println(ANSI_REDB + " ❌ " + ANSI_RESET + "Introduce un valor entero.");
					}
				
				} while (opcion < 1 || opcion > 3); // Condición de paro
				
				break;
			
			
			case 2:
				do {
					int contador = 1;
					System.out.println();
					System.out.println("¿Qué ataque piensas que tiene tu Pokemon?");
					for (String ataque: arrAtaques) { // Muestra todos los ataques
						System.out.println(contador + ": " + ataque);
						contador++;
					}
					System.out.print("Elección (ingresa un número entero): ");
					
					try { 
						opcion = Integer.parseInt(sc.nextLine());
						
						if (opcion < 1 || opcion > contador - 1) {
							System.out.println();
							System.out.println(ANSI_REDB + " ❌ " + ANSI_RESET + "Introduce un valor entre 1 y " + (contador - 1) + ".");
						} else {
							ataquePokemon(opcion, arrPokemonesRand, pokemonGanador, arrAtaques);
						}
						
					} catch (NumberFormatException exception) {
						System.out.println();
						System.out.println(ANSI_REDB + " ❌ " + ANSI_RESET + "Introduce un valor entero.");
					}
				} while (opcion < 1 || opcion > 8);
				break;
		
				
			case 3:
				System.out.println();
				System.out.println("¿Cuál es el nombre de tu Pokemon?");
				System.out.print("Ingresa el nombre (puede ser en mayúsculas o minúsculas): ");
				opcionTexto = sc.nextLine();
				
				nombrePokemon(opcionTexto, arrPokemonesRand, pokemonGanador);
				break;
		
			case 4:
				System.out.println();
				System.out.println(ANSI_REDB + "OJO: ÚLTIMA OPORTUNIDAD" + ANSI_RESET);
				System.out.print("Ingresa el nombre del Pokemon que creas que es (puede ser en mayúsculas o minúsculas): ");
				opcionTexto = sc.nextLine();
				
				nombrePokemon(opcionTexto, arrPokemonesRand, pokemonGanador);
				break;
		}
		
	}
	
	public Pokemon [] tipoPokemon(int opcion, Pokemon[] arrPokemonesRand, Pokemon pokemonGanador) {
	    String opcionP;

	    if (opcion == 1) {
	        opcionP = "(agua)";
	    } else if (opcion == 2) {
	        opcionP = "(fuego)";
	    } else {
	        opcionP = "(planta)";
	    }
	    
	    if (pokemonGanador.getTipo().equals(opcionP)) {// Checar si el tipo coincide con la opción que se eligió
	        System.out.println();
	        System.out.println(ANSI_GREENB + "¡Correcto! Te vas acercando" + ANSI_RESET);
	        
	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones del tipo seleccionado
	            if (pokemon.getTipo().equals(opcionP)) {
	                contador++;
	            }
	        }

	        nuevoArregloP = new Pokemon[contador]; // Inicializar el arreglo con tamaño adecuado
	        contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) {//Copiar pokemones que sean del tipo que se pide
	            if (pokemon.getTipo().equals(opcionP)) {
	                nuevoArregloP[contador] = pokemon;
	                contador++;
	            }
	        }

	        mostrarMenu(nuevoArregloP); // Mostrar pokemones restantes 
	        
	    } else {
	        System.out.println();
	        System.out.println(ANSI_REDB + "¡Incorrecto! El pokemon NO tiene el ataque " + opcionP + ANSI_RESET);

	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones del tipo seleccionado
	            if (!pokemon.getTipo().equals(opcionP)) {
	                contador++;
	            }
	        }

	        nuevoArregloP = new Pokemon[contador]; // Inicializar el arreglo con tamaño adecuado
	        contador = 0;

	        // Copiar los Pokémon que no sean del tipo seleccionado al nuevo arreglo
	        for (Pokemon pokemon : arrPokemonesRand) {
	            if (!pokemon.getTipo().equals(opcionP)) {
	                nuevoArregloP[contador] = pokemon;
	                contador++;
	            }
	        }

	        mostrarMenu(nuevoArregloP); // Mostrar pokemones restantes 
	    }
	   return nuevoArregloP; 
	}
	
	public Pokemon[] ataquePokemon(int opcion, Pokemon[] arrPokemonesRand, Pokemon pokemonGanador, String[] arrAtaques) {
	    String opcionP = "";
	    
	    switch (opcion) {
        case 1:
            opcionP = arrAtaques[0]; //Hydro pump (si se cambia el orden del arreglo se actualiza) 
            break;
        case 2:
            opcionP = arrAtaques[1];// Solar beam
            break;
        case 3:
            opcionP = arrAtaques[2]; // Eruption
            break;
        case 4:
            opcionP = arrAtaques[3];
            break;
        case 5:
            opcionP = arrAtaques[4];
            break;
        case 6:
            opcionP = arrAtaques[5];
            break;
        case 7:
            opcionP = arrAtaques[6];
            break;
        case 8:
            opcionP = arrAtaques[7];
            break;
    }
	    
	    String[] ataquesGanadores = pokemonGanador.getAtaques();
	    String at1 = ataquesGanadores[0];
	    String at2 = ataquesGanadores[1];
	    String at3 = ataquesGanadores[2];
	    String at4 = ataquesGanadores[3];
	 
	    
	    if (at1.equals(opcionP) || at2.equals(opcionP) || at3.equals(opcionP) || at4.equals(opcionP)) {
	        System.out.println();
	        System.out.println(ANSI_GREENB + "¡Correcto! Te vas acercando" + ANSI_RESET);
	        
	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones que tienen el ataque seleccionado
	            String[] ataquesPokemon = pokemon.getAtaques();
	            boolean tieneAtaque = false;
	            for (String ataque : ataquesPokemon) {
	                if (ataque.equals(opcionP)) {
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

	        for (Pokemon pokemon : arrPokemonesRand) {// Copiar los Pokémon que tienen el ataque seleccionado al nuevo arreglo
	            String[] ataquesPokemon = pokemon.getAtaques();
	            boolean tieneAtaque = false;
	            for (String ataque : ataquesPokemon) {
	                if (ataque.equals(opcionP)) {
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
	        System.out.println(ANSI_REDB + "¡Incorrecto! El pokemon NO tiene el ataque " + opcionP + ANSI_RESET);
	        
	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones que no tienen el ataque seleccionado
	            boolean tieneAtaque = false;
	            for (String ataque : pokemon.getAtaques()) {
	                if (ataque.equals(opcionP)) {
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
	                if (ataque.equals(opcionP)) {
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

	
	public Pokemon[] nombrePokemon(String opcionTexto, Pokemon[] arrPokemonesRand, Pokemon pokemonGanador) {
		
		this.nuevoArregloP = arrPokemonesRand;
	

	    if (opcionTexto.trim().equalsIgnoreCase(pokemonGanador.getNombre())) { // Usar equalsIgnoreCase para comparar cadenas sin importar mayúsculas o minúsculas
	        System.out.println();
	        System.out.println(ANSI_GREENBACK + ANSI_BLACKB + "¡Correcto! ¡GANASTEEEEEEEEE!" + ANSI_RESET);
	        System.out.println("El Pokemon era: " + pokemonGanador.getNombre() + pokemonGanador.getTipo());
	        
	        
			banderaArchivos = true; // Para agregar un punto al archivo en la clase ejecutar

			
	        nuevoArregloP = new Pokemon[1]; // Inicializar el arreglo con el tamaño adecuado
	        
	    } else {
	        System.out.println();
	        System.out.println(ANSI_REDB + "¡Incorrecto! El pokemon no es: " + opcionTexto + ANSI_RESET);

	        int contador = 0;

	        for (Pokemon pokemon : arrPokemonesRand) { // Contar pokemones que no coinciden con el nombre seleccionado
	            if (!pokemon.getNombre().trim().equalsIgnoreCase(opcionTexto)) {
	            	contador++;
	            }
	        }
	        
	        nuevoArregloP = new Pokemon[contador]; // Inicializar el arreglo con el tamaño adecuado
	        contador = 0;

	        // Copiar los Pokémon que no coinciden con el nombre seleccionado al nuevo arreglo
	        for (Pokemon pokemon : arrPokemonesRand) {
	            if (!pokemon.getNombre().equalsIgnoreCase(opcionTexto)) { // Guardar pokemones
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

    
    public boolean repetirPrograma() {
        boolean terminar = false;
        int eleccion = -1;
        
        do {
            System.out.println();
            System.out.println("¿Quieres seguir jugando?");
            System.out.println("0: No " + ANSI_REDB + "💊" + ANSI_RESET);
            System.out.println("1: Sí " + ANSI_CYANB + "💊" + ANSI_RESET);
            System.out.print("Digita tu respuesta:  ");
           
            try {
                eleccion = Integer.parseInt(sc.nextLine());
                
                if (eleccion != 0 && eleccion != 1) {
                    System.out.println("Escoge 1 ó 0.");
                    
                } else {
                    if (eleccion == 0) {
                        System.out.println("¡¡Hasta pronto " + misArchivos.getArchivo().getName() + "!!");
                        System.out.println("Terminando programa...");
                        terminar = true;
                      
                    } else {
                    	System.out.println("Adelante...");
                    	System.out.println();
                    	System.out.println();
                    	terminar = false;
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println(ANSI_REDB + " ❌ " + ANSI_RESET + "Introduce un valor entero.");
            }
            
        } while (eleccion != 0 && eleccion != 1);
        
        return terminar;
    }

}
