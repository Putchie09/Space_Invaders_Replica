package model;

import utils.Vector2D;
import conf.Asset;
import main.MainClient;

/**
 * Factory del enemigo dos (el central).
 */
public class EnemyTwoFactory implements EnemyFactoryInterface {

    @Override
    public Enemy createEnemy(Vector2D position) {
        return new Enemy(position,
                Asset.enemyTwo,
                MainClient.getSetting("ENEMY_TWO_SCORE"),
                MainClient.getSetting("ENEMY_TWO_LASER_SPEED"));
    }

}
