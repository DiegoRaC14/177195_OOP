package actividad.opciones;

public class Cuadrado {
	
	//Atributos
	public double lado;
	public String nombreFigura;
	
	
	//Métodos constructor 
	public Cuadrado(String nombreFigura, double lado) {
		
		this.lado = lado;
		this.nombreFigura = nombreFigura;
	}

	public Cuadrado (String nombreFigura) {//Asigna el valor 177195 en el lado si no se especifica en main
        
		this(nombreFigura, 177195);
	}
	
	
	//Métodos 
	public double calcularPerimetro(double lado){
		
		double perimetro;
		perimetro = lado * 4;
		
		return perimetro;
	}
	
	
	public double calcularArea(double lado) {
		
		double area;
		area = lado * lado;
		
		return area;
	}
	
	public double calcularDiagonal(double lado) {
		
		double diagonal;
		diagonal = 1.41421 * lado;
		
		return diagonal;
	}

}
