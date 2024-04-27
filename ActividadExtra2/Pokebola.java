package imagenes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pokebola {
	
	// Tamaño de la imagen
	static int width = 1000;
	static int height = 1000;
	
	//Colores
	static Color brightRed = new Color(234,0,0,255);
	static Color gray = new Color(184,184,184,255);
	
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
	 
	 public static void crearPokebola() {
		 // Dibuja el fondo
		 drawBackground(PIXEL_SIZE, Color.white);
		 
		 drawHorizontalLine(9,16,4,Color.black);
		 drawVerticalLine(6,13,2,Color.black);
		 drawVerticalLine(15,13,2,Color.black);
		 drawVerticalLine(5,9,4,Color.black);
		 drawVerticalLine(16,9,4,Color.black);
		 drawVerticalLine(6,7,2,Color.black);
		 drawVerticalLine(15,7,2,Color.black);
		 fillRect(7,6,8,6,brightRed);
		 drawHorizontalLine(7,15,2,Color.black);
		 drawHorizontalLine(13,15,2,Color.black);
		 drawHorizontalLine(7,6,2,Color.black);
		 drawHorizontalLine(13,6,2,Color.black);
		 drawHorizontalLine(9,5,4,Color.black);
		 drawVerticalLine(6,9,3,brightRed);
		 drawVerticalLine(15,9,3,brightRed);
		 drawHorizontalLine(9,15,4,gray);
		 fillRect(12,13,3,2,gray);
		 putPixel(7,14, gray);
		 putPixel(11,14, gray);
		 drawHorizontalLine(10,13,2,Color.black);
		 drawHorizontalLine(7,12,3,Color.black);
		 drawHorizontalLine(12,12,3,Color.black);
		 drawHorizontalLine(10,10,2,Color.black);
		 putPixel(6,11, Color.black);
		 putPixel(15,11,Color.black);
		 putPixel(9,11, Color.black);
		 putPixel(12,11,Color.black);
		 fillRect(10, 11, 2, 2, gray);
		 putPixel(10,11,Color.white);
		 drawVerticalLine(9,7,3,Color.white);
		 drawHorizontalLine(8,8, 3, Color.white);

		 
		 
		// Dibuja la cuadrícula
		 drawSquareGrid(PIXEL_SIZE, Color.black); // Dibuja la cuadrícula
		 
		 
		 //Guardar la imagen en formato jpg y usar excepciones
		 try {
			 File pokebolaDibujo = new File("Pokebola_pixelArt.jpg");
			 ImageIO.write(imagen, "jpg", pokebolaDibujo);
			 System.out.println(pokebolaDibujo.getName() + " se guardó con éxito.");
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
	 
