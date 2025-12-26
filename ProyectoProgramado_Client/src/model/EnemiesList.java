package model;

import controller.GameStatus;
import java.awt.Graphics;
import java.util.ArrayList;
import main.MainClient;
import utils.Vector2D;

/**
 * Representa la lista de enemigos, se encarga de organizarlos
 * en las filas y columnas, gestionar los ataques aleatorios etc...
 */
public class EnemiesList {

    private ArrayList<Enemy> enemiesList;
    private ArrayList<Enemy> enemiesToRemove;

    private EnemyOneFactory enemyOneFactory = new EnemyOneFactory();
    private EnemyTwoFactory enemyTwoFactory = new EnemyTwoFactory();
    private EnemyThreeFactory enemyThreeFactory = new EnemyThreeFactory();

    public EnemiesList() {
        enemiesList = new ArrayList<>();
        enemiesToRemove = new ArrayList<>();
    }

    public int getCount() {
        return enemiesList.size();
    }

    public void addEnemy(Enemy enemy) {
        enemiesList.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemiesList.remove(enemy);
    }

    public Enemy getEnemy(int posicion) {
        return enemiesList.get(posicion);
    }
    
    public boolean isEmpty(){
        return enemiesList.isEmpty();
    }

    public void clearList() {
        enemiesList.clear();
    }

    /**
     * Genera los enemigos en filas y columnas.
     */
    public void generateEnemies() {

        int rows = MainClient.getSetting("ENEMY_ROWS");
        int cols = MainClient.getSetting("ENEMY_COLUMNS");
        
        int horizontalMargin = MainClient.getSetting("HORIZONTAL_MARGIN");
        int verticalMargin = MainClient.getSetting("VERTICAL_MARGIN");
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                //márgenes de separación entre enemigos
                int x = 200 + j * horizontalMargin;
                int y = 100 + i * verticalMargin;

                if (i == 0) { //Primera fila
                    addEnemy(enemyOneFactory.createEnemy(new Vector2D(x, y)));

                } else if (i == 1 || i == 2) { //Segunda fila
                    addEnemy(enemyTwoFactory.createEnemy(new Vector2D(x, y)));

                } else { //Tercera fila
                    addEnemy(enemyThreeFactory.createEnemy(new Vector2D(x, y)));
                }
            }
        } // for filas
    }

    public void drawEnemies(Graphics g) {
        for (Enemy enemy : enemiesList) {
            enemy.draw(g);
        }
    }

    /**
     * Actualiza el estado de los enemigos.
     * Maneja el movimiento, las colisiones y la eliminación de enemigos.
     */
    public void updateEnemies() {
        boolean movementChanged = false;

        if (enemiesList.isEmpty()) {
            return;
        }

        Enemy currentEnemy = null;
        for (int i = 0; i < enemiesList.size(); i++) {
            currentEnemy = enemiesList.get(i);
            currentEnemy.update();

            //si algún enemigo está muerto se debe eliminar
            if (currentEnemy.isDead()) {
                enemiesToRemove.add(currentEnemy);
                GameStatus.player.addScore(currentEnemy.getScore());
            }
            
            //Cambiar dirección al llegar al borde de la ventana
            if (!movementChanged && (currentEnemy.getPosition().getX() <= 0
                    || currentEnemy.getPosition().getX() >= MainClient.width - 50)) {

                currentEnemy.changeMovement(); 
                moveEnemiesDown();
                movementChanged = true;
            }
            
            //Si un enemigo llega a la fila del jugador se elimina
            if (currentEnemy.position.getY() >= GameStatus.player.getPosition().getY() + 10){ 
                GameStatus.player.destroy();
                enemiesToRemove.add(currentEnemy);
            }
            
        }

        //elimina los enemigos muertos, se hace fuera para evitar modificaciones durante el recorrido
        for (Enemy enemy : enemiesToRemove) {
            removeEnemy(enemy);
        }
        enemiesToRemove.clear();
        
    }


    /**
     * Mueve a los enemigos hacia abajo.
     * También incrementa su velocidad.
     */
    public void moveEnemiesDown() {
        for (Enemy enemy : enemiesList) {
            enemy.moveDown();
            enemy.increaseSpeed();
        }
    }

    /**
     * Selecciona aleatoriamente un enemigo para que ataque.
     */
    public void randomAttack() {
        int enemies = getCount();
        int attackingEnemy;

        if (enemies > 0) {
            attackingEnemy = (int) (Math.random() * getCount());
            getEnemy(attackingEnemy).attack();
        }
    }

}
