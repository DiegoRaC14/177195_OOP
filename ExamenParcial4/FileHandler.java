package examenFinal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class FileHandler {
	
    public static void saveImage(BufferedImage image, File file) throws IOException {
      	ImageIO.write(image, "PNG", file);
    }

    public static BufferedImage loadImage(File file) throws IOException {
        return ImageIO.read(file);
    }
}
