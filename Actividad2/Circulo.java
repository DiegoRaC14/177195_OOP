package clases_y_objetos;

public class Circulo {
	
	public static final double PI = 3.14159; //Declaración de la constante PI
	
	
	//Atributos
	public double radio;
	public String nombreFigura;
	
	//Métodos constructor
	public Circulo (String nombreFigura, double radio) {
		
		this.nombreFigura = nombreFigura;
		this.radio = radio;
	}
	
	 public Circulo(String nombreFigura) {//Asigna el valor 177195 en el radio si no se especifica en main
	        
		 this(nombreFigura, 177195);
	    }

	
	//Métodos
	public double calcularPerimetro(double radio){
		
		 double perimetro;
		 perimetro = PI * (2 * radio);
		 
		 return perimetro;
	}

	public double calcularArea(double radio){
		
		double area;
		area = PI * (radio*radio);
		
		return area;
	}
	
}
