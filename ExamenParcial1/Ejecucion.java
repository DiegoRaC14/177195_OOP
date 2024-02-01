package examen.parcial1;

import java.util.Scanner;

public class Ejecucion {
	
	public void iniciarPrograma () {
		
		Scanner sc = new Scanner(System.in);//Creación de objeto escaner
		
		int choice;//Variable usada para FizzBuzz
		
		Palabras miCadena1 = new Palabras("hasta luego cocodrilo");
		Palabras miCadena2 = new Palabras("anita lava la tina");
		Extra miLista = new Extra();
		
		miCadena1.convertirPrimeraMayuscula(miCadena1.texto);
		miCadena2.convertirPrimeraMayuscula(miCadena2.texto);

		miCadena1.invertirCadena(miCadena1.texto);
		miCadena2.invertirCadena(miCadena2.texto);
		
		miCadena1.convertirVocalesMayuscula(miCadena1.texto);
		miCadena2.convertirVocalesMayuscula(miCadena2.texto);
		
		miCadena1.checarPalindromo(miCadena1.texto);
		miCadena2.checarPalindromo(miCadena2.texto);
		
		System.out.println("");
		System.out.println("¿Desea crear FizzBuzz?");
		System.out.println("Ingrese 1 para SÍ");
		System.out.println("Cualquier otro número entero para NO");
		System.out.println("");
		System.out.println("Ingresar un número: ");
		
		choice = Integer.parseInt(sc.nextLine());
		
		if (choice == 1) {
			miLista.crearFizzBuzz();
		}else {
			System.out.println("Fin del programa...");
			System.exit(0);
		}
		
		
		sc.close();//Se cierra flujo

	}

}
