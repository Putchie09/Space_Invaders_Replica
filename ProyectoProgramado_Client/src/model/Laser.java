package model;

import conf.Asset;
import java.awt.Graphics;
import main.MainClient;
import utils.Vector2D;

/**
 * Representa el laser que dispara la nave y los enemigos.
 */
public class Laser extends MovableObject implements Runnable {

    private LaserStrategy laserStrategy;
    private int speed;
    private boolean running;

    // para que se mueva 60 veces por segundo
    private static final int REFRESH_RATE = 16;

    public Laser(Vector2D position, LaserStrategy laserStrategy, int speed) {
        super(position, Asset.laser);
        this.laserStrategy = laserStrategy;
        this.speed = speed;
        running = true;
    }

    public LaserStrategy getLaserStrategy() {
        return laserStrategy;
    }

    /**
     * Método run del hilo que maneja el movimiento del láser.
     */
    @Override
    public void run() {
        while (running) {

            laserStrategy.moveLaser(this, speed);

            if (outOfScreen()) {
                destroy();
                return;
            }

            detectCollision();

            try {
                Thread.sleep(REFRESH_RATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update() {
    }

    /**
     * Dibuja el láser desde su centro.
     *
     * @param g Objeto Graphics para dibujar.
     */
    @Override
    public void draw(Graphics g) {
        int xCenter = (int) position.getX() - width / 2;
        int yCenter = (int) position.getY() - height / 2;

        g.drawImage(image, xCenter, yCenter, null);
    }

    @Override
    public Vector2D getCenter() {
        return new Vector2D(position.getX() + width / 2, position.getY() + width / 2);
    }

    private boolean outOfScreen() {
        return position.getY() < 0 || position.getY() > MainClient.height;
    }

    public void stop() {
        running = false;
    }

    public void resume() {
        running = true;
    }
}
