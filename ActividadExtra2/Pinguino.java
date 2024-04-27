package imagenes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pinguino {
	
	//Tamaño de la imagen
	static int width = 1000;
	static int height = 1000;
	
	//Colores RGB
	static Color grayBlue = new Color(70,90,99,255);
	static Color yellow = new Color(253,193,1,255);
	
	static BufferedImage imagen = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB); //Crea una imagen en blanco
	static Graphics2D g = imagen.createGraphics(); // Se inicializa para poder pintar sobre la imagen
	
	//Definir el tamaño de pixel y la matríz de colores
	private final static int PIXEL_SIZE = 50;

	 
	 public static void crearPinguino() {
		// Dibuja el fondo
		 drawBackground(20, Color.white);
		 
		 //Dibujar cuerpo del pinguino
		 drawHorizontalLine(6,18, 3, Color.black);
		 drawHorizontalLine(13,18, 3, Color.black);
		 drawHorizontalLine(9,17,4, Color.black);
		 drawHorizontalLine(6,17,3, yellow);
		 drawHorizontalLine(13,17,3, yellow);
		 drawVerticalLine(5,13,5, Color.black);
		 drawVerticalLine(16,13,5, Color.black);
		 putPixel(4,14,Color.black);
		 putPixel(17,14,Color.black);
		 drawVerticalLine(3,11, 3, Color.black);
		 drawVerticalLine(4,11, 3,grayBlue);
		 drawVerticalLine(18,11, 3, Color.black);
		 drawVerticalLine(17,11, 3, grayBlue);
		 drawVerticalLine(4,7, 4, Color.black);
		 drawVerticalLine(5,7,6, grayBlue);
		 drawVerticalLine(17,7, 4, Color.black);
		 drawVerticalLine(16,7,6, grayBlue);
		 drawVerticalLine(5,5, 2, Color.black);
		 drawVerticalLine(6,5,10, grayBlue);
		 drawVerticalLine(16,5, 2, Color.black);
		 drawVerticalLine(15,5,10, grayBlue);
		 putPixel(6,4,Color.black);
		 putPixel(15,4,Color.black);
		 drawHorizontalLine(7,3,2,Color.black);
		 drawHorizontalLine(13,3,2,Color.black);
		 drawHorizontalLine(9,2,4, Color.black);
		 drawHorizontalLine(9,3,4, grayBlue);
		 fillRect(7,4,8,10,grayBlue);
		 drawHorizontalLine(8,13,6, Color.white);
		 drawHorizontalLine(10,12,2, yellow);
		 drawHorizontalLine(9,11,4, yellow);
		 fillRect(8,9,2,2,Color.black);
		 fillRect(12,9,2,2,Color.black);
		 putPixel(8,9, Color.white);
		 putPixel(12,9, Color.white);
		 
		 // Dibuja la cuadrícula (opcional para visualizar)
		 drawSquareGrid(20, Color.black);

		 
		 //Guardar la imagen en formato jpg y usar excepciones
		 try {
			 File pinguinoDibujo = new File("Pinguino_pixelArt.jpg");
			 ImageIO.write(imagen, "jpg", pinguinoDibujo);
			 System.out.println(pinguinoDibujo.getName() + " se guardó con éxito.");
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
