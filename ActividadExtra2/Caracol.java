package imagenes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Caracol {

	// Tamaño de la imagen
	static int width = 1000;
	static int height = 1000;
	
	//Colores RGB
	static Color brown = new Color(137,86,45,255);
	static Color lightYellow = new Color(246,239,97,255);
	
	static BufferedImage imagen = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB); //Crea una imagen en blanco
	static Graphics2D g = imagen.createGraphics(); // Se inicializa para poder pintar sobre la imagen
	
	//Definir el tamaño de pixel y la matríz de colores
	private final static int PIXEL_SIZE = 50;

	 
	 public static void crearCaracol() {
		 // Dibuja el fondo
		 drawBackground(PIXEL_SIZE, Color.white);
		 
		 //Dibuja el caracol
		 drawHorizontalLine(8,15,9,Color.black);
		 drawVerticalLine(7,11,4,Color.black);
		 drawVerticalLine(5,8,2,Color.black);
		 drawHorizontalLine(6,7,3,Color.black);
		 putPixel(6,6,Color.black);
		 putPixel(8,6,Color.black);
		 fillRect(6,8,3,3,lightYellow);
		 fillRect(11,10,5,5, brown);
		 drawVerticalLine(7,11,3,Color.black);
		 putPixel(6,10,Color.black);
		 drawVerticalLine(9,8,3,Color.black);
		 drawVerticalLine(10,11,3,Color.black);
		 putPixel(11,14,Color.black);
		 putPixel(10,14,lightYellow);
		 fillRect(8,11,2,4,lightYellow);
		 putPixel(11,10,Color.black);
		 putPixel(15,10,Color.black);
		 drawHorizontalLine(12,9,3,Color.black);
		 drawVerticalLine(16,11,3,Color.black);
		 putPixel(15,14,Color.black);
		 drawHorizontalLine(13,13,2,Color.black);
		 putPixel(14,12,Color.black);
		 putPixel(13,11,Color.black);
		 putPixel(12,12,Color.black);
		 putPixel(7,9,Color.black);
	
		 
		// Dibuja la cuadrícula
		 drawSquareGrid(PIXEL_SIZE, Color.black); // Dibuja la cuadrícula
		 
		 
		 //Guardar la imagen en formato jpg y usar excepciones
		 try {
			 File caracolDibujo = new File("Caracol_pixelArt.jpg");
			 ImageIO.write(imagen, "jpg", caracolDibujo);
			 System.out.println(caracolDibujo.getName() + " se guardó con éxito.");
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