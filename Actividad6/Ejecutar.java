package guess.who.archivos;

public class Ejecutar {
	
	public void iniciarPrograma() {
	
		Menu miMenu = new Menu ();
		Aleatorio miAleatorio = new Aleatorio(); // Objeto clase aleatorio para llamar métodos
		Archivos misArchivos = new Archivos(); // Objeto clase archivos para manipular las estadísticas
		
		Pokemon[] arrPokemones = new Pokemon[15]; // Creación arreglo de objetos tipo pokemon
		
		String[] arrAtaques = {"Hydro pump", "Solar beam", "Eruption", "Flamethrower",
				"Aqua Jet", "Whirpool", "Synthesis", "Petal Dance"}; // Posibles ataques

		// Colores
		String ANSI_RESET = "\033[0m" ;
		String ANSI_BLACKB = "\033[1;30m"; //Black bold
		String ANSI_CYANB = "\033[1;36m"; // Cyan Bold
		String ANSI_PURPLEBR= "\033[0;95m"; // Purple bright
		String ANSI_YELLOW = "\033[0;33m";
		String ANSI_WHITEBACK = "\033[47m";  // White background
		
		Pokemon []arrPokemonesRand = new Pokemon [arrPokemones.length]; // Solo creación arreglo random
		Pokemon pokemonGanador;
		int indexPGanador;
		boolean primeraVezPrograma = false; // Variable para no volver a preguntar el nombre de usuario la 2da vez 
		boolean seguirPrograma; // Variable para almacenar el boolean de menu y ver si sigue el programa
							
		arrPokemones[0] = new Agua ("Squirtle", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[1] = new Agua ("Totodile", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[2] = new Agua ("Mudkip", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[3] = new Agua ("Froakie",miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[4] = new Agua ("Quaxly",miAleatorio.asignarAtaques(arrAtaques));
		
		arrPokemones[5] = new Fuego ("Charmander",miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[6] = new Fuego ("Cyndaquil", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[7] = new Fuego ("Torchic", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[8] = new Fuego ("Litten", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[9] = new Fuego ("Fuecoco",miAleatorio.asignarAtaques(arrAtaques));
		
		arrPokemones[10] = new Planta ("Bulbasaur", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[11] = new Planta ("Chikorita", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[12] = new Planta ("Treecko", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[13] = new Planta ("Rowlet", miAleatorio.asignarAtaques(arrAtaques));
		arrPokemones[14] = new Planta ("Sprigatito", miAleatorio.asignarAtaques(arrAtaques));
		
		
		do {
		System.out.println("¡Bienvenid@ a tu juego favorito...");
		System.out.println(ANSI_YELLOW + "...ADIVINA QUIÉN DE POKEMONES!" + ANSI_RESET);
		System.out.println();
		System.out.println();

		misArchivos.crearArchivo(misArchivos.obtenerUsername()); // Checar si el nombre de usuario ya existe
		
		System.out.println("A continuación se muestra tu tablero:");
		System.out.println();
		
		arrPokemonesRand = miAleatorio.desplegarMenuRand(arrPokemones); // Guardar arreglo de pokemones aleatorio e imprimir la lista
		indexPGanador = miAleatorio.pokemonAdvinar(arrPokemones); // Almacena el índice del pokemon elegido al azar
		pokemonGanador = arrPokemonesRand[indexPGanador]; // Copia info del Pokemon elegido al azar
		
		System.out.println(pokemonGanador.getNombre());
		
		System.out.println();
		System.out.println(ANSI_PURPLEBR + "Nota: Recuerda que tienes máximo 4 intentos y al 5to debes advinar el nombre" + ANSI_RESET);
		System.out.println();
		
		miMenu.mostrarPreguntas(arrPokemonesRand, indexPGanador, arrAtaques, pokemonGanador, 1); //Inicia las preguntas, se tiene que mandar primero el arregl o aleatorio
		
		if (miMenu.banderaArchivos) { // Checar si ganó y actualizar el archivo
			misArchivos.actualizarNumArchivo(1);
			seguirPrograma = miMenu.repetirPrograma();	
			continue; // Se modifica la condición de seguir y se manda hasta el final para checar el while
		}

		for (int i = 2; i <= 5; i++) {
			int intento;
			
		    intento = i;
		    miMenu.mostrarPreguntas(miMenu.nuevoArregloP, indexPGanador, arrAtaques, pokemonGanador, intento);
		    
			if (miMenu.banderaArchivos) { // Checar si ganó y actualizar el archivo con +1 partida ganada
				misArchivos.actualizarNumArchivo(1);
				seguirPrograma = miMenu.repetirPrograma(); // Se guarda el boolean que se regresa en repetir programa
				continue;
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println(ANSI_BLACKB + ANSI_WHITEBACK + "NOOOOOOO...  ¡PERDISTE! :c" + ANSI_RESET);			
		System.out.println("El Pokemon correcto era:" + pokemonGanador.getNombre() + pokemonGanador.getTipo());	
			
		misArchivos.actualizarNumArchivo(0); // Actualiza el archivo pero con cero partidas ganadas
		seguirPrograma = miMenu.repetirPrograma();
	
		
		}while (!seguirPrograma);
	}
	
}
