package model;

import utils.Vector2D;
import conf.Asset;
import main.MainClient;

/**
 * Factory del enemigo uno (el más lejano al jugador).
 */
public class EnemyOneFactory implements EnemyFactoryInterface {

    @Override
    public Enemy createEnemy(Vector2D position) {
        
        return new Enemy(position, 
                Asset.enemyOne, 
                MainClient.getSetting("ENEMY_ONE_SCORE"),
                MainClient.getSetting("ENEMY_ONE_LASER_SPEED"));
    }
}
