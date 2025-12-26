package model;

import controller.GameStatus;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * La clase MovableObjectsList gestiona una lista de objetos movibles,
 * proporcionando métodos para agregar, eliminar y obtener elementos. Además,
 * tiene funcionalidades para imprimir la lista y limpiarla.
 */
public class MovableObjectsList {

    private ArrayList<MovableObject> movableObjectsList;
    private ArrayList<MovableObject> objectsToRemove;

    public MovableObjectsList() {
        movableObjectsList = new ArrayList<>();
        objectsToRemove = new ArrayList<>();
    }

    //Obtener el tamaño de la lista
    public int getCount() {
        return movableObjectsList.size();
    }

    public void addObject(MovableObject object) {
        movableObjectsList.add(object);
       // objectsToAdd.add(object);

    }

    public void removeObject(MovableObject object) {
        movableObjectsList.remove(object);
    }

    public MovableObject getObject(int posicion) {
        return movableObjectsList.get(posicion);
    }

    public void clearList() {
        movableObjectsList.clear();
    }

    /**
     * Permite dibujar en pantalla cada objeto de la lista.
     *
     * @param g componente para dibujar.
     */
    public void drawObjects(Graphics g) {
        for (MovableObject currentObject : movableObjectsList) {
            if (currentObject != null) {
                currentObject.draw(g);
            }
        }
    }

    /**
     * Permite actualizar y eliminar objetos en la lista.
     */
    public void updateObjects() {

        for (int i = 0; i < movableObjectsList.size(); i++) {
            MovableObject currentObject = movableObjectsList.get(i);
            currentObject.update();

            if (currentObject.isDead()) {
                if (currentObject instanceof SpecialEnemy) {
                    SpecialEnemy specialEnemy = (SpecialEnemy) currentObject;
                    if (!specialEnemy.getScreenDeath()) {
                        GameStatus.player.addScore(specialEnemy.getScore());
                    }
                }
                objectsToRemove.add(currentObject); // Añadir a la lista temporal de objetos a eliminar
            }
        }

        // Eliminar objetos muertos
        for (MovableObject object : objectsToRemove) {
            movableObjectsList.remove(object);
        }

        // Limpiar la lista temporal
        objectsToRemove.clear();
    }

}
