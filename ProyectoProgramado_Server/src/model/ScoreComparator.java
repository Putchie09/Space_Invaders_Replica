package model;

import java.util.Comparator;

/**
 * Permite comparar jugadores por su id, se utiliza para
 * ordenar la lista al mostrar los mejores puntajes.
 */
public class ScoreComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return o2.compareTo(o1); // Ordena de mayor a menor
    }

}
