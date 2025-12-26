package conf;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Clase para cargar y almacenar las imágenes utilizadas en el juego.
 */
public class Asset {

    public static BufferedImage playerShip;
    public static BufferedImage laser;

    public static BufferedImage enemyOne;
    public static BufferedImage enemyTwo;
    public static BufferedImage enemyThree;
    public static BufferedImage enemyFour;

    public static void initAssets() {
        playerShip = loadImage("images/playerShip.png");
        laser = loadImage("images/laser.png");
        enemyOne = loadImage("images/enemyOne.png");
        enemyTwo = loadImage("images/enemyTwo.png");
        enemyThree = loadImage("images/enemyThree.png");
        enemyFour = loadImage("images/enemyFour.png");
    }

    /**
     * Carga una imagen desde la carpeta de recursos.
     */
    public static BufferedImage loadImage(String url_Imagen) {
         try {
            InputStream inputStream = Asset.class.getClassLoader().getResourceAsStream(url_Imagen);
            if (inputStream != null) {
                return ImageIO.read(inputStream);
            } else {
                System.out.println("No se encontró el recurso: " + url_Imagen);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar imagen: " + url_Imagen);
            e.printStackTrace();
        }
        return null;
    }
}
