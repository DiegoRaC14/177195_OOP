package clases_y_objetos;

public class Main {
	
	public static void main(String[] args) {
		
		Cuadrado miCuadrado = new Cuadrado("cuadrado", 177195/1000.0);
		Circulo miCirculo = new Circulo("círculo", 177195/1000.0);
			
		
		System.out.println("El " + miCuadrado.nombreFigura + " tiene perímetro: " + miCuadrado.calcularPerimetro(miCuadrado.lado) + ".");
		System.out.println("El " + miCuadrado.nombreFigura + " tiene área: " + miCuadrado.calcularArea(miCuadrado.lado) + ".");
		System.out.println("El " + miCuadrado.nombreFigura + " tiene diagonal: " + miCuadrado.calcularDiagonal(miCuadrado.lado) + ".");
		System.out.println("");
		System.out.println("El " + miCirculo.nombreFigura + " tiene perímetro: " + miCirculo.calcularPerimetro(miCirculo.radio) + ".");
		System.out.println("El " + miCirculo.nombreFigura + " tiene área: " + miCirculo.calcularArea(miCirculo.radio) + ".");
		
	}

}
