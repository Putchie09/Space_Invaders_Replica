package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.MainClient;
import utils.Vector2D;

/**
 * Enemigo especial cuya puntuación es un valor aleatorio entre 80 y 150.
 * Se desplaza de derecha a izquierda hasta salir de la pantalla.
 */
public class SpecialEnemy extends MovableObject {

    private int score;
    private boolean screenDeath;
    private int movementDirection;
    public static final int SPEED = MainClient.getSetting("SPECIAL_ENEMY_SPEED");

    public SpecialEnemy(Vector2D position, BufferedImage image, int movementDirection) {
        super(position, image);
        screenDeath = false;
        this.movementDirection = movementDirection;
        generateScore();
    }

    @Override
    public void update() {

        if (movementDirection == 1) { //Derecha a izquierda
            this.getPosition().setX(this.getPosition().getX() - SPEED);
            
        } else if (movementDirection == 2) { //Izquierda a derecha
            this.getPosition().setX(this.getPosition().getX() + SPEED);
            
        }
        
        detectCollision();

        if (this.getPosition().getX() < -60) { //Elimina al enemigo si este sale de la ventana (izquierda)
            this.destroy();
            screenDeath = true; //Para validar si fue eliminado por el jugador o no
        }
        
        if (this.getPosition().getX() > MainClient.width + 60) { //Elimina al enemigo si este sale de la ventana (derecha)
            this.destroy();
            screenDeath = true; //Para validar si fue eliminado por el jugador o no
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int) position.getX(), (int) position.getY(), null);
    }

    public int getScore() {
        return score;
    }

    public boolean getScreenDeath() {
        return screenDeath;
    }
    
    /**
     * Genera una puntuación aleatoria para el enemigo, entre 80 y 150 puntos
     */
    private void generateScore() {
        score = (int) ((Math.random() * 71) + 80);
    }
    
    /**
     * Genera un número aleatorio entre 1 y 2
     * 1- Movimiento de derecha a izquierda
     * 2- Movimiento de izquierda a derecha
     * 
     * @return el número aleatorio para definir el movimiento
     */
    public static int generateMovementDirection() {
        return (int) ((Math.random() * 2) + 1);
        
    }

}
