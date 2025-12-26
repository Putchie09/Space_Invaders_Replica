package model;

/**
 * Mueve el laser hacia abajo.
 */
public class EnemyLaserStrategy implements LaserStrategy {

    @Override
    public void moveLaser(Laser laser, int speed) {
        
        double positionY = laser.getPosition().getY();
        
        laser.getPosition().setY(positionY + speed);
    }
}
