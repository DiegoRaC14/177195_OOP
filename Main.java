package actividad.opciones;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // Escanear valores
		boolean bandera = true;
		
		while (bandera) {
			
			System.out.println("");
			System.out.println("1. Cálculos con el cuadrado.");
			System.out.println("2. Cálculos con el círculo.");
			System.out.println("3. Salir del programa.");
			System.out.print("Ingrese un número: ");
			
			int choice = Integer.parseInt(sc.nextLine()); // Ingresar la opción
			
			switch (choice) {
			
				case 1: // Elección de cuadrado
					
					System.out.println("");
					System.out.print("Ingrese el lado del cuadrado: ");
					
					double lado = Double.parseDouble(sc.nextLine()); // Parsing
					Cuadrado miCuadrado = new Cuadrado("cuadrado", lado); // Crear objeto con valores ingresados
					
					boolean cuadradoBandera = true;
					
					while (cuadradoBandera) {
					System.out.println("");
					System.out.println("1. Calcular el perímetro.");
					System.out.println("2. Calcular el área.");
					System.out.println("3. Calcular la diagonal.");
			        System.out.println("4. Volver al menú principal.");
			        System.out.println("5. Salir del programa.");
					System.out.print("Ingrese un número: ");
					
					choice = Integer.parseInt(sc.nextLine()); // Ingresar la opción
					
					switch (choice) {
					
						case 1:
							System.out.println("");
							System.out.println("El " + miCuadrado.nombreFigura + " tiene perímetro: " + miCuadrado.calcularPerimetro(miCuadrado.lado) + ".");
							break;
						
						case 2:
							System.out.println("");
							System.out.println("El " + miCuadrado.nombreFigura + " tiene área: " + miCuadrado.calcularArea(miCuadrado.lado) + ".");
							break;
						
						case 3:
							System.out.println("");
							System.out.println("El " + miCuadrado.nombreFigura + " tiene diagonal: " + miCuadrado.calcularDiagonal(miCuadrado.lado) + ".");
							break;
							
						case 4:
							cuadradoBandera = false;
							break;
							
						case 5:
							System.out.println("Exiting...");
							System.exit(0);
							break;
							
						default:
							System.out.println("Opción no válida.");
							break;
					}
					
			
				}
				
				case 2: // Elección de círculo
				    System.out.println("");
				    System.out.print("Ingrese el radio del círculo: ");
				    
				    double radio = Double.parseDouble(sc.nextLine()); // Parsing
				    Circulo miCirculo = new Circulo("círculo", radio); // Crear objeto círculo con el valor ingresado
				    
				    boolean circuloBandera = true;

				    while (circuloBandera) {
				        System.out.println("");
				        System.out.println("1. Calcular el perímetro.");
				        System.out.println("2. Calcular el área.");
				        System.out.println("3. Volver al menú principal.");
				        System.out.println("4. Salir del programa.");
				        System.out.print("Ingrese un número: ");
				        
				        choice = Integer.parseInt(sc.nextLine());//Ingresar número entero
				        
				        switch (choice) {
				            
				            case 1:
				            	System.out.println("");
				                System.out.println("El " + miCirculo.nombreFigura + " tiene perímetro: " + miCirculo.calcularPerimetro(miCirculo.radio) + ".");
				                break;
				            
				            case 2:
				            	System.out.println("");
				                System.out.println("El " + miCirculo.nombreFigura + " tiene área: " + miCirculo.calcularArea(miCirculo.radio) + ".");
				                break;
				            
				            case 3:
				                circuloBandera = false;
				                break;
				            
				            case 4:
				                System.out.println("Exiting...");
				                System.exit(0);
				                break;
				            
				            default:
				                System.out.println("Opción no válida.");
				                break;
				        }
				    }
				    break;
				
				case 3:
					System.out.println("Exiting...");
					System.exit(0);
					break;
				
				default:
					System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
					break;
			}
			
		}
			sc.close(); // Cerrar flujo de escaner	
	}
}

