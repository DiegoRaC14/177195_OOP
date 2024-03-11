package guess.who;

public class Ejecutar {
	
	public void iniciarPrograma() {
	
		Menu miMenu = new Menu ();
		Aleatorio miAleatorio = new Aleatorio(); // Objeto clase aleatorio para llamar métodos
		
		String ANSI_RESET = "\033[0m" ;
		String ANSI_BLACKB = "\033[1;30m"; //Black bold
		String ANSI_YELLOW = "\033[0;33m";
		String ANSI_CYANB = "\033[1;36m";
		String ANSI_WHITEBACK = "\033[47m";  // White background
		
		String[] arrAtaques = {"Hydro pump", "Solar beam", "Eruption", "Flamethrower",
						"Aqua Jet", "Whirpool", "Synthesis", "Petal Dance"};
		
		
		Pokemon[] arrPokemones = new Pokemon[15]; // Creación arreglo de objetos
		
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
		
		int indexPGanador;
		Pokemon []arrPokemonesRand = new Pokemon [arrPokemones.length]; // Creación 
		Pokemon pokemonGanador;
		
		System.out.println("¡Bienvenid@ a tu juego favorito...");
		System.out.println(ANSI_YELLOW + "...ADIVINA QUIÉN DE POKEMONES!" + ANSI_RESET);
		System.out.println();
		System.out.println();
		
		System.out.println("A continuación se muestra tu tablero:");
		System.out.println();
		
		arrPokemonesRand = miAleatorio.desplegarMenuRand(arrPokemones); // Guardar arreglo de pokemones aleatorio e imprimir la lista
		indexPGanador = miAleatorio.pokemonAdvinar(arrPokemones); // Almacena el índice del Pokemon elegido al azar
		pokemonGanador = arrPokemonesRand[indexPGanador]; // Copia info del Pokemkon elegido al azar
		
		System.out.println(pokemonGanador.getNombre());

		System.out.println();
		System.out.print(ANSI_CYANB + "Intento 1:" + ANSI_RESET);
		miMenu.mostrarPreguntas(arrPokemonesRand, indexPGanador, arrAtaques, pokemonGanador, 1);

		for (int i = 2; i <= 5; i++) {
		    System.out.println();
		    System.out.print(ANSI_CYANB + "Intento " + i + ":" + ANSI_RESET);
		    int intento = i;
		    miMenu.mostrarPreguntas(miMenu.nuevoArregloP, indexPGanador, arrAtaques, pokemonGanador, intento);
		}

		System.out.println();
		System.out.println();
		System.out.println(ANSI_BLACKB + ANSI_WHITEBACK + "NOOOOOOO...  ¡PERDISTE! :c" + ANSI_RESET);
		System.out.println("El Pokemon correcto era:" + pokemonGanador.getNombre() + pokemonGanador.getTipo());		
	}

	
}
