package actividad.aleatorio;

public class Circulo {
	
	public static final double PI = 3.14159; //Declaración de la constante PI
	
	
	//Atributos
	double radio;
	String color;
	String nombreFigura;
	
	//Métodos constructor
	public Circulo (String color, double radio) {
		
		this.color = color;
		this.radio = radio;
	}
	

	//Métodos
	public double calcularPerimetro(double radio){
		
		 double perimetro;
		 perimetro = PI * (2 * radio);
		 
		 return perimetro;
	}

	public double calcularArea(double radio){
		
		double area;
		area = Math.PI * (radio*radio);
		
		return area;
	}
	
}
