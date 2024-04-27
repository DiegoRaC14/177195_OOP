package imagenes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Flamingo {

	// Tamaño de la imagen
	static int width = 1000;
	static int height = 1000;
	
	//Colores RGB
	static Color pink = new Color(255,98,180);
	static Color lightPink = new Color(238,195,204,255);
	static Color darkPink = new Color(245, 0, 135);
	static Color peach = new Color(241,172,80);
	static Color gray = new Color(103,96,101,255);
	
	static BufferedImage imagen = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB); //Crea una imagen en blanco
	static Graphics2D g = imagen.createGraphics(); // Se inicializa para poder pintar sobre la imagen
	
	//Definir el tamaño de pixel
	private final static int PIXEL_SIZE = 20;

	 
	 public static void crearFlamingo() {
		 // Dibuja el fondo
		 drawBackground(50, Color.cyan);
		 
		 //Dibuja piernas
		 fillRect(24,46,11,2,Color.black);
		 putPixel(25,45,Color.black);
		 fillRect(26,34, 3,12,Color.black);
		 fillRect(31,34, 3,12,Color.black);
		 putPixel(30,45,Color.black);
		 drawHorizontalLine(25,46,4,peach);
		 drawHorizontalLine(30,46,4,peach);
		 drawVerticalLine(27,35,11, peach); //Aquí agregar pixeles a las patas
		 drawVerticalLine(32,35,11, peach);
		 
		 //Empieza cuerpo (lado izquierdo)
		 drawHorizontalLine(23,34,13,Color.black);
		 drawHorizontalLine(23,33,13,darkPink);
		 putPixel(22,33,Color.black);
		 putPixel(22,32,darkPink);
		 putPixel(21,32,Color.black);
		 putPixel(20,31,Color.black);
		 drawVerticalLine(19,29,2,Color.black);
		 drawVerticalLine(18,20,9,Color.black);
		 putPixel(19,20,lightPink);
		 drawVerticalLine(19,18,2,Color.black);
		 putPixel(20,18,lightPink);
		 drawVerticalLine(20,16,2,Color.black);
		 putPixel(21,16,lightPink);
		 drawVerticalLine(21,14,2,Color.black);
		 drawHorizontalLine(7,13,14,Color.black);
		 putPixel(21,13,darkPink);
		 drawHorizontalLine(7,14,2,Color.black); //Pico

		 //Cabeza y principio del pico
		 fillRect(7,10,5,3,Color.black);
		 putPixel(8,10,gray);
		 drawHorizontalLine(8,9,4,Color.black);
		 putPixel(9,9,gray);
		 drawHorizontalLine(9,8,3,Color.black);
		 putPixel(10,8,gray);
		 drawHorizontalLine(10,7,6, Color.black);
		 drawVerticalLine(16,8,5,Color.black);
		 fillRect(12,8,4,3,lightPink);//Relleno del pico
		 fillRect(12,11,4,2,peach); //Relleno del pico
		 putPixel(16,7,lightPink);
		 putPixel(16,6,Color.black);
		 drawHorizontalLine(17,5,6, Color.black);
		 drawHorizontalLine(17,6,6, lightPink);
		 fillRect(17,7,8,5,pink); //Relleno de la cabeza
		 drawVerticalLine(18,7,2,Color.black);//Ojo izquierdo
		 drawVerticalLine(20,7,2,Color.black);//Ojo derecho
		 drawHorizontalLine(17,12,4,darkPink);
		 putPixel(21,12, pink);
		 fillRect(22,12,3,5,pink); //Relleno cuello
		 putPixel(23,6,Color.black);
		 putPixel(24,7,Color.black);
		 putPixel(23,7,lightPink);
		 
		 //Contorno cuello lado derecho
		 drawVerticalLine(25,8,9,Color.black);
		 drawHorizontalLine(22,16,2,pink);
		 putPixel(24,16,darkPink);
		 drawHorizontalLine(21,17,3,pink);
		 drawVerticalLine(24,17,2,Color.black);
		 drawHorizontalLine(21,18,2,pink);
		 putPixel(23,18,darkPink);
		 fillRect(20,19,3,2,pink);
		 fillRect(19,21,4,8,pink);
		 drawVerticalLine(23,19,4,Color.black);
		 
		 // Cuerpo
		 drawHorizontalLine(23,21,9,Color.black);
		 drawHorizontalLine(23,22,9,lightPink);
		 drawHorizontalLine(32,22,4,Color.black);
		 
		 //Ala
		 fillRect(23,23,14,10,pink);
		 fillRect(21,29,2,3,pink);
		 drawVerticalLine(20,29,2,pink);
		 
		 drawHorizontalLine(25,23,7,Color.black);
		 putPixel(24,24,Color.black);
		 drawVerticalLine(23,25,3,Color.black);
		 putPixel(24,28,Color.black);
		 putPixel(23,28,darkPink);
		 putPixel(25,29,Color.black);
		 putPixel(24,29,darkPink);
		 putPixel(25,30,darkPink);
		 drawHorizontalLine(26,30,9, Color.black);
		 putPixel(35,29,Color.black);
		 putPixel(34,29,lightPink);
		 
		 putPixel(36,28,Color.black);
		 putPixel(35,28,lightPink);
		 putPixel(34,28,Color.black);
		 
		 putPixel(36,27,lightPink);
		 putPixel(35,27,Color.black);
		 
		 drawHorizontalLine(32,24,2,Color.black);
		 drawHorizontalLine(34,25,2,Color.black);
		 putPixel(36,26,Color.black);
		 putPixel(37,27,Color.black);
		 
		 
		 // Cola
		 putPixel(36,23,Color.black);
		 putPixel(35,23,lightPink);
		 
		 putPixel(37,24,Color.black);
		 putPixel(36,24,lightPink);
		 putPixel(38,25,Color.black);
		 putPixel(37,25,lightPink);
		 putPixel(39,26,Color.black);
		 putPixel(38,26,lightPink);
		 putPixel(40,27,Color.black);
		 putPixel(39,27,lightPink);
		 putPixel(41,28,Color.black);
		 putPixel(40,28,lightPink);
		 putPixel(42,29,Color.black);
		 putPixel(41,29,lightPink);
		 drawVerticalLine(43,30,2,Color.black);
		 putPixel(42,30,lightPink);
		 putPixel(42,31,darkPink);
		 drawVerticalLine(41,31,3,Color.black);
		 drawHorizontalLine(40,32,3,Color.black);
		 putPixel(41,32,darkPink);
		 putPixel(39,31,Color.black);
		 
		 drawHorizontalLine(36,33,2,Color.black);
		 drawHorizontalLine(36,32,2,darkPink);
		 putPixel(38,32,Color.black);
		 putPixel(37,26,pink);
		 drawHorizontalLine(37,27,2,pink);
		 drawHorizontalLine(37,28,3,pink);
		 fillRect(37,29,5,2,pink);
		 drawHorizontalLine(37,31,2,pink);
		 putPixel(40,31,pink);
		 putPixel(37,27,Color.black);
		 putPixel(41,29,lightPink);
		 
		// Dibuja la cuadrícula
		 drawSquareGrid(50, Color.black); // Dibuja la cuadrícula
		 
		 
		 //Guardar la imagen en formato jpg y usar excepciones
		 try {
			 File flamingoDibujo = new File("Flamingo_pixelArt.jpg");
			 ImageIO.write(imagen, "jpg", flamingoDibujo);
			 System.out.println(flamingoDibujo.getName() + " se guardó con éxito.");
		 } catch (IOException e) {
			 System.out.println("Ocurrió un error al crear la imagen de Rana");
			 e.getMessage();
		 }
	 }

	 //Métodos (primero es x,y [posición, empieza desde 1,1 como una matriz] y luego largo.
	 private static void drawVerticalLine(int x, int y, int largo, Color c) {
		    for (int i = y - 1; i < (y - 1) + largo; i++) {
		        g.setColor(c);
		        g.fillRect((x -1) * PIXEL_SIZE, i * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
		    }
		}
 
	 private static void drawHorizontalLine(int x, int y, int largo, Color c){
		    for(int i = x - 1; i < x - 1 + largo; i++){
		        g.setColor(c);
		        g.fillRect(i * PIXEL_SIZE, (y - 1) * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
		    }
		}
	    
	    private static void putPixel(int x, int y, Color c){// Poner un solo pixel del tamaño de un recuadro       
		   g.setColor(c);
		   g.fillRect((x - 1) * PIXEL_SIZE, (y - 1) * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);    
	    }
	    
	    private static void fillRect(int x, int y, int width, int height, Color c){
	        g.setColor(c);
	        g.fillRect((x - 1) * PIXEL_SIZE, (y - 1) * PIXEL_SIZE, width * PIXEL_SIZE, height * PIXEL_SIZE);
	    }
	    
	    private static void drawSquareGrid(int size, Color c) {
	        for (int i = 0; i < size; i++) {
	            for (int j = 0; j < size; j++) {                
	                g.setColor(c);
	                g.drawRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
	            }
	        }
	    }
	    private static void drawBackground(int size, Color c) {
	    	for (int i = 0; i < size; i++) {
	            for (int j = 0; j < size; j++) {
	                g.setColor(c);
	                g.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);                
	            }
	       }
	    }

}