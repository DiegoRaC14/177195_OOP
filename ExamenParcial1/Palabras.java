package examen.parcial1;

public class Palabras {
	
	String texto;//Atributo
	
	//Método constructor
	public Palabras(String texto) {
		this.texto = texto;
	}

	public void convertirPrimeraMayuscula (String texto) {
		
		int noIndex = 0;
	
		System.out.println("");
		System.out.println("Frase original: " + texto);
		
		String textoEnMayusculas = texto.toUpperCase();
		System.out.println("Primera letra de la cadena en mayúsculas: " + textoEnMayusculas.charAt(noIndex) + ".");
	}
	
	
	public void invertirCadena (String texto) {
		
		System.out.println("");
		String textoModificado = "";
		
		for (int i = texto.length()-1; i >= 0; i--) {
			textoModificado += texto.charAt(i);
		}
		
		System.out.println("Frase original: " + texto);
		System.out.println("Frase invertida: " + textoModificado);
	
	}
	
	
	public void convertirVocalesMayuscula(String texto) {
		
		System.out.println("");
		System.out.println("Frase original: " + texto);
		
		for (int i = 0; i < texto.length(); i++) {

			if (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u'){
				String textoEnMayusculas = texto.toUpperCase(); //Poner todo el texto en mayúsculas
				texto = texto.replace(texto.charAt(i), textoEnMayusculas.charAt(i));
			}
		}
		System.out.println("Frase con vocales mayúsculas: " + texto);
	}
	
	
	public void checarPalindromo (String texto) {
		
		String textoModificado = "";
		System.out.println("");
		System.out.print("La frase: " + texto);
		
		for (int i = texto.length()-1; i >= 0; i--) {//Invierte el texto
			textoModificado += texto.charAt(i);
		}
		
		texto = texto.replaceAll("\\s", "");//ReplaceAll quita todos los espacios
		
		if(texto.equals(textoModificado.replaceAll("\\s", ""))) {
			System.out.println(" es un palíndromo.");
		}else {
			System.out.println(" NO es un palíndromo.");
		}
		
		
	}
	
}
