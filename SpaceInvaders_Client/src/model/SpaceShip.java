package model;

import conf.Asset;
import java.awt.Graphics;
import controller.GameStatus;
import main.MainClient;
import utils.*;

/**
 * Representa la nave del jugador. Puede moverse y disparar
 */
public class SpaceShip extends MovableObject {

    private Crono laserCrono;
    private int lives;
    private int score;

    private final int PLAYER_SPEED = MainClient.getSetting("PLAYER_SPEED");
    private final int PLAYER_LASER_SPEED = MainClient.getSetting("PLAYER_LASER_SPEED");
    private final int LASER_COOLDOWN = MainClient.getSetting("LASER_COOLDOWN");

    public SpaceShip(Vector2D position) {
        super(position, Asset.playerShip);

        laserCrono = new Crono();
        lives = MainClient.getSetting("PLAYER_LIVES");
        score = 0;
        dead = false;
    }

    @Override
    protected void destroy() {
        if (lives != 0) { //Para no seguir restando más allá de 0
            if (lives > 1) {
                decreaseLives();
            } else {
                decreaseLives();
                dead = true;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int) position.getX(), (int) position.getY(), null);

    }

    /**
     * Actualiza el estado de la nave. Mueve la nave, dispara y revisa colisiones.
     */
    @Override
    public void update() {
        // Disparar
        if (Keyboard.shoot && !laserCrono.isRunning()) {
            shoot();
        }
        
        // Mover nave 
        if (Keyboard.right && position.getX() < MainClient.width - 65) {
            position.setX(position.getX() + PLAYER_SPEED);
        }
        if (Keyboard.left && position.getX() > - 10) {
            position.setX(position.getX() - PLAYER_SPEED);
        }

        laserCrono.update();
        detectCollision();
    }

    /**
     * Dispara un láser desde la nave.
     * Crea un nuevo láser y lo añade a la lista de objetos del juego.
     * Inicia el cronómetro para el tiempo de espera entre disparos.
     */
    private void shoot() {
        //Centro horizotal del jugador
        Vector2D laserPosition = new Vector2D(position.getX() + width / 2, position.getY() - height / 6);

        Laser laser = new Laser(laserPosition, new PlayerLaserStrategy(), PLAYER_LASER_SPEED);

        GameStatus.objectList.addObject(laser);
        Thread laserThread = new Thread(laser);
        laserThread.start();

        laserCrono.run(LASER_COOLDOWN); // tiempo de espera para volver a shoot
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void decreaseLives() {
        lives--;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void sumScore(int score) {
        this.score += score;
    }
}