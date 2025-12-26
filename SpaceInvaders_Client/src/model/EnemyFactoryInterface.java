package model;

import utils.Vector2D;

/**
 * Interfaz para todas las fábricas de enemigos.
 */
public interface EnemyFactoryInterface {
    
    Enemy createEnemy(Vector2D position); 
    
}
