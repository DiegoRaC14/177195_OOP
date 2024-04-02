package listas;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
	
	public List<Integer> numerosPares(List<Integer> listaFibonacci){
		
		List<Integer> listaPares = new ArrayList<Integer>();
		
		for (int numero: listaFibonacci) {
			if (numero%2 == 0) {
				listaPares.add(numero);
			}
		}

		return listaPares ;
	}
	
	public List<Integer> numerosImpares(List<Integer> listaFibonacci){
		
		List<Integer> listaImpares = new ArrayList<Integer>();
		
		for (int numero: listaFibonacci) {
			if (numero%2 != 0) {
				listaImpares.add(numero);
			}
		}
		
		return listaImpares;
	}
}
