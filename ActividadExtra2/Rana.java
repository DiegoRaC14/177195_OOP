package imagenes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rana {
	
	// Tamaño de la imagen
	static int width = 1000;
	static int height = 1000;
	
	//Colores
	static Color lightGreen = new Color(118,173,51,255);
	static Color darkBrown = new Color(69,43,24,255);
	static Color lightPink = new Color(239,173,200,255);
	
	static BufferedImage imagen = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB); //Crea una imagen en blanco
	static Graphics2D g = imagen.createGraphics(); // Se inicializa para poder pintar sobre la imagen
	
	//Definir el tamaño de pixel y la matríz de colores
	private final static int PIXEL_SIZE = 50;
	/*private final static Color[][] PIXELS = {
		        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
		        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
		        {Color.WHITE, Color.BLUE, Color.RED, Color.BLUE, Color.WHITE},
		        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
		        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE}
	 			};//*/
	 
	 public static void crearRana() {
		
		 // Pinta el fondo de blanco
		 drawBackground(PIXEL_SIZE, Color.white);
		 
		 drawHorizontalLine(6, 16, 10, darkBrown);
		 drawVerticalLine(5, 11, 5, darkBrown);
		 drawVerticalLine(16, 11, 5, darkBrown);
		 drawVerticalLine(6, 9, 2, darkBrown);
		 drawVerticalLine(15, 9, 2, darkBrown);
		 drawHorizontalLine(7,8,2, darkBrown);
		 drawHorizontalLine(13,8,2, darkBrown);
		 putPixel(9, 9,darkBrown);
		 putPixel(12, 9, darkBrown);
		 drawHorizontalLine(10, 10, 2, darkBrown);
		 fillRect(6, 11, 10, 5, lightGreen);
		 fillRect(7, 9, 2, 2, lightGreen);
		 fillRect(13,9, 2, 2, lightGreen);
		 drawVerticalLine(8,10,2, darkBrown);
		 drawVerticalLine(13,10,2, darkBrown);
		 drawHorizontalLine(7,12, 2,lightPink);
		 drawHorizontalLine(13,12, 2, lightPink);
		 putPixel(9, 10, lightGreen);
		 putPixel(12, 10, lightGreen);
		 drawHorizontalLine(9,13,4, darkBrown);

		// Dibuja la cuadrícula
		 drawSquareGrid(PIXEL_SIZE, Color.black); // Dibuja la cuadrícula
		 
		 
		 //Guardar la imagen en formato jpg y usar excepciones
		 try {
			 File ranita = new File("Rana_pixelArt.jpg");
			 ImageIO.write(imagen, "jpg", ranita);
			 System.out.println(ranita.getName() + " se guardó con éxito.");
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
