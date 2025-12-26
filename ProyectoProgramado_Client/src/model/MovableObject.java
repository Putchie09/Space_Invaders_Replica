package model;

import controller.GameStatus;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utils.Vector2D;

/**
 * Representa un objeto movible del juego.
 * Tiene una imagen, posición y detecta colisiones.
 */
public abstract class MovableObject {

    protected Vector2D position;
    protected BufferedImage image;
    protected int width;
    protected int height;
    protected boolean dead;

    public MovableObject(Vector2D position, BufferedImage image) {
        this.position = position;
        this.image = image;
        this.dead = false;

        if (image != null) {
            width = image.getWidth();
            height = image.getHeight();
        }
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    protected void destroy() {
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }
    
    // Retorna el centro del objeto
    protected Vector2D getCenter() {
        return new Vector2D(position.getX() + width / 2, position.getY() + height / 2);
    }

    /**
     * Detecta colisiones con otros objetos movibles.
     */
    protected void detectCollision() {
        MovableObjectsList list = GameStatus.objectList;
        MovableObject currentObject;
        double distance = 0, radius = 0;

        for (int i = 0; i < list.getCount(); i++) {
            currentObject = list.getObject(i);
            
            if (currentObject != this) {
                //distancia entre los centros de cada objeto
                distance = currentObject.getCenter().subtract(getCenter()).magnitud();
                radius = currentObject.width / 2 + width / 2; //Suma de los radios
                
                //Si al distancia es menor que la suma de los radios y ninguno de los objetos está muerto hay colisión
                if (distance < radius && !currentObject.isDead() && !isDead()) {  
                    collideWith(currentObject, this);
                }
            }
        }
    }

    /**
     * Maneja la colisión entre dos objetos movibles.
     * 
     * @param a El primer objeto movible.
     * @param b El segundo objeto movible.
     */

    protected void collideWith(MovableObject a, MovableObject b) {
        if (a instanceof Laser && b instanceof Enemy) {
            Laser laser = (Laser) a;
            if (laser.getLaserStrategy() instanceof PlayerLaserStrategy) { //Verify shooter
                a.destroy();
                b.destroy();
            }
        }
        
        if (a instanceof Laser && b instanceof SpaceShip) {
            Laser laser = (Laser) a;
            if (laser.getLaserStrategy() instanceof EnemyLaserStrategy) {
                a.destroy();
                b.destroy();
            }
        }
        
        if (a instanceof Laser && b instanceof SpecialEnemy) {
            Laser laser = (Laser) a;
            if (laser.getLaserStrategy() instanceof PlayerLaserStrategy) {
                a.destroy();
                b.destroy();
            }
        }
        
        if (a instanceof SpaceShip && b instanceof Enemy) {
            a.destroy();
        }
        
    }

    public abstract void update();

    public abstract void draw(Graphics g);

}
