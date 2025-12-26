package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import controller.GameStatus;
import main.MainClient;
import utils.Vector2D;

/**
 * Representa un enemigo en el juego. 
 * Los enemigos pueden moverse y atacar al jugador.
 */
public class Enemy extends MovableObject {
    
    
    private int score;
    private int laserSpeed;
    public static boolean moveRight;
    public boolean attacking;
    
    //aumenta cada vez que bajan los enemigos
    public static double xSpeed; 
    
    public static int Y_SPEED = MainClient.getSetting("ENEMY_Y_SPEED"); 
    
    private static final double SPEED_INCREMENT = 0.01;

    public Enemy(Vector2D position, BufferedImage image, int score, int laserSpeed) {
        super(position, image);
        this.score = score;
        this.laserSpeed = laserSpeed;
        moveRight = true;
        attacking = false;
        this.xSpeed = 1;
    }

    public void changeMovement() {
    	moveRight = !moveRight;
    }
    
    public void increaseSpeed() {
        xSpeed += SPEED_INCREMENT;
    }
    
    //baja un nivel de altura a los enemigos
    public void moveDown() {
        this.getPosition().setY(this.getPosition().getY() + Y_SPEED);
    }

    public int getLaserSpeed() {
        return laserSpeed;
    }

    public void setLaserSpeed(int laserSpeed) {
        this.laserSpeed = laserSpeed;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Permite destuir el enemigo si se sale de rango,
     * detectar las colisiones y atacar.
     */
    @Override
    public void update() {
        detectCollision();
    }
    
    
    /**
     * Permite dibujar al enemigo y moverlo
     * para ello utiliza el metodo moverEnemigo.
     * @param g componente Graphics sobre el cual dibujar.
     * */
    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int) position.getX(), (int) position.getY(), null);

        if(attacking){
        	attack();
        }
        moveEnemy();
    }

    public void moveEnemy() {
        if(moveRight){
            position.setX(position.getX() + xSpeed);
        }else{
            position.setX(position.getX() - xSpeed);
        }
    }
    
    
    /**
     * Dispara un laser hacia el jugador.
     */
    public void attack() {

        // El centro horizontal del enemigo
        Vector2D laserPosition = new Vector2D(position.getX() + width / 2, position.getY() - height / 6);
        
        Laser laser = new Laser(laserPosition, new EnemyLaserStrategy(), getLaserSpeed());
        
        Thread thread = new Thread(laser);
        thread.start();
        
        GameStatus.objectList.addObject(laser);
    }
}
