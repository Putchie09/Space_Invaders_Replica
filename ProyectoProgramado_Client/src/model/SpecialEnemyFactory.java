package model;

import utils.Vector2D;
import main.MainClient;
import conf.Asset;

/**
 * Factory del enemigo especial
 */
public class SpecialEnemyFactory implements SpecialEnemyFactoryInterface{

    @Override
    public SpecialEnemy createSpecialEnemy() {
        int direction = SpecialEnemy.generateMovementDirection();
        SpecialEnemy enemy = null;
        
        switch (direction) {
            case 1: //Derecha a izquierda
                enemy = new SpecialEnemy(new Vector2D(MainClient.width + 55, 60), Asset.enemyFour, direction);
                break;
            case 2: //Izquierda a derecha
                enemy = new SpecialEnemy(new Vector2D(-55, 60), Asset.enemyFour, direction);
                break;
        }
        
        return enemy;
    }


}
