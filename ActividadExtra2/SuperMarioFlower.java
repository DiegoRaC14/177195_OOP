package imagenes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SuperMarioFlower {
	
	// Tamaño de la imagen
	static int width = 1000;
	static int height = 1000;
	
	//Colores
	static Color brightGreen = new Color(0,204,0,255);
	static Color yellow = new Color(254,229,0,255);
	static Color lightOrange = new Color(254,139,8,255);
	static Color orange = new Color(255,51,0,255);
	
	static BufferedImage imagen = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB); //Crea una imagen en blanco
	static Graphics2D g = imagen.createGraphics(); // Se inicializa para poder pintar sobre la imagen
	
	//Definir el tamaño de pixel y la matríz de colores
	private final static int PIXEL_SIZE = 50;

	 
	 public static void crearSuperMarioFlower() {
		 // Dibuja el fondo
		 drawBackground(PIXEL_SIZE, Color.white);
		 
		 drawHorizontalLine(7,18,8,Color.black);
		 fillRect(4,14,14,3,brightGreen);
		 drawHorizontalLine(5,17,2,Color.black);
		 drawHorizontalLine(15,17,2,Color.black);
		 putPixel(4,16,Color.black);
		 putPixel(17,16,Color.black);
		 drawVerticalLine(3,13,3,Color.black);
		 drawVerticalLine(18,13,3,Color.black);
		 drawHorizontalLine(4,12,2,Color.black);
		 drawHorizontalLine(16,12,2,Color.black);
		 drawHorizontalLine(6,13,2,Color.black);
		 drawHorizontalLine(14,13,2,Color.black);
		 putPixel(8,14,Color.black);
		 putPixel(13,14,Color.black);
		 drawVerticalLine(9,11,6,Color.black);
		 drawVerticalLine(12,11,6,Color.black);
		 fillRect(10,11,2,7,brightGreen);
		 drawHorizontalLine(7,17,8,brightGreen);
		 drawHorizontalLine(4,13,2,brightGreen);
		 drawHorizontalLine(16,13,2,brightGreen);
		 
		 //Empieza cabeza de la flor
		 drawHorizontalLine(7,10,8,Color.black);
		 drawHorizontalLine(5,9,2,Color.black);
		 drawHorizontalLine(15,9,2,Color.black);
		 fillRect(5,4,12,6,orange);
		 drawHorizontalLine(5,9,2,Color.black);
		 drawHorizontalLine(15,9,2,Color.black);
		 putPixel(4,8, Color.black);
		 putPixel(17,8, Color.black);
		 drawVerticalLine(3,5, 3,Color.black);
		 drawVerticalLine(18,5, 3,Color.black);
		 drawVerticalLine(4,5, 3,orange);
		 drawVerticalLine(17,5, 3, orange);
		 putPixel(4,4, Color.black);
		 putPixel(17,4, Color.black);
		 drawHorizontalLine(5,3,2,Color.black);
		 drawHorizontalLine(15,3,2,Color.black);
		 drawHorizontalLine(7,2,8,Color.black);
		 drawHorizontalLine(7,3,8,orange);
		 fillRect(8,4,6,5, lightOrange);
		 fillRect(6,5,10,3, lightOrange);
		 fillRect(8,5,6,3,yellow);
		 putPixel(7,6,yellow);
		 putPixel(14,6,yellow);
		 drawHorizontalLine(8,6,6,Color.white);
		 drawVerticalLine(9,5,3,Color.black);
		 drawVerticalLine(12,5,3,Color.black);
		 
		// Dibuja la cuadrícula
		 drawSquareGrid(PIXEL_SIZE, Color.black); // Dibuja la cuadrícula
		 
		 
		 //Guardar la imagen en formato jpg y usar excepciones
		 try {
			 File florSMDibujo = new File("SuperMarioFlower_pixelArt.jpg");
			 ImageIO.write(imagen, "jpg", florSMDibujo);
			 System.out.println(florSMDibujo.getName() + " se guardó con éxito.");
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
