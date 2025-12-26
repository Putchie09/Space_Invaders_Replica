package model;

/**
 * Mueve el laser hacia arriba.
 */
public class PlayerLaserStrategy implements LaserStrategy {

    @Override
    public void moveLaser(Laser laser, int speed) {
        double positionY = laser.getPosition().getY();
        
        laser.getPosition().setY(positionY - speed);
    }
}
