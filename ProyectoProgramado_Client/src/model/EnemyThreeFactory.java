package model;

import utils.Vector2D;
import conf.Asset;
import main.MainClient;

/**
 * Factory del enemigo tres (el más cercano al jugador).
 */
public class EnemyThreeFactory implements EnemyFactoryInterface {

    @Override
    public Enemy createEnemy(Vector2D position) {
        return new Enemy(position,
                Asset.enemyThree,
                MainClient.getSetting("ENEMY_THREE_SCORE"),
                MainClient.getSetting("ENEMY_THREE_LASER_SPEED"));
    }
}
