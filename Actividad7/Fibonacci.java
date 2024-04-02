package listas;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
	
	public List<Integer> crearFibonacci(){
		
		List<Integer> listaFibonacci = new ArrayList<Integer>(); // Creación de una lista
		boolean bandera = false;
		int num1 = 0;
		int num2 = 1;
		int suma = 0;
		
		listaFibonacci.add(num1); // Agrega el cero a la lista
		listaFibonacci.add(num2); // Agrega el uno 
		
		 do { 
			 suma = num1 + num2;
			 listaFibonacci.add(suma);
			 
			 num1 = num2;
			 num2 = suma; 
			 
			 if (suma > 1000000) {
				 bandera = true;
			 }
			 
		 } while (!bandera);
		
		return listaFibonacci;
	}
}
