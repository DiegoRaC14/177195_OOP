package guess.who.archivos;

import java.util.Random; // Librería random

public class Aleatorio {
	
	Random miRand = new Random();
	
	
	public String[] asignarAtaques(String[] arrAtaques) { // Asignar ataques aleatorios

        String[] arregloRand = new String[4];
        boolean[] checarAtaques = new boolean[arrAtaques.length];
        int contador = 0;

        while (contador < arregloRand.length) {

            int numRand = miRand.nextInt(arrAtaques.length);

            if (!checarAtaques[numRand]) {
                arregloRand[contador] = arrAtaques[numRand];
                checarAtaques[numRand] = true;
                contador += 1;
            }

        }
        return arregloRand;
    }
	
	public Pokemon[] desplegarMenuRand(Pokemon[] arrPokemones) { //Imprimir menu primera vez
		
		boolean[] checarPokemones = new boolean [arrPokemones.length];
		int contador = 0;
		int numRand;
		Pokemon[] arrPokemonesRand = new Pokemon[arrPokemones.length];
		
		while (contador < arrPokemones.length) {
			numRand = miRand.nextInt(arrPokemones.length);
			
			if (!checarPokemones[numRand]) {
			    System.out.print(contador + 1 + ": " + arrPokemones[numRand].getNombre() + " " + arrPokemones[numRand].getTipo() + ": ");
			    arrPokemonesRand[contador] =  arrPokemones[numRand];
			    
			    String[] ataques = arrPokemones[numRand].getAtaques(); 
			    
			    for (int i = 0; i < ataques.length; i++) {
			        System.out.print(ataques[i]);
			        
			        if (i < ataques.length - 1) { // Condición para comas
			            System.out.print(", ");
			        }else {
			        	 System.out.print(".");
			        }
			    }
			    System.out.println();
			    checarPokemones[numRand] = true;
			    contador++;
			}

		}
		return arrPokemonesRand;
	}
	
	public int pokemonAdvinar(Pokemon[] arrPokemonesRand) { // Escoge un pokemon al azar
		int indexPGanador = miRand.nextInt(arrPokemonesRand.length);
		return indexPGanador;
	}
	
	
	

}
