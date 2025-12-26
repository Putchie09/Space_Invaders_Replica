package model;

/**
 * La estrategia del láser depende de si es disparado por un jugador o un alien,
 * se utiliza para decidir si el laser avanza hacia arriba o hacia abajo.
 */
public interface LaserStrategy {
    void moveLaser(Laser laser, int speed);
}
