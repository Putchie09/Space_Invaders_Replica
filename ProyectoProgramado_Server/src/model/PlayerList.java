package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para manejar una lista de jugadores.
 * Esta clase proporciona métodos para agregar jugadores, buscar jugadores por nombre y contraseña,
 * y verificar si un jugador ya existe en la lista.
 */
public class PlayerList {

    private ArrayList<Player> playerList;
    
    
    public PlayerList() {
        playerList = new ArrayList<>();
    }

    /**
     * Retorna la lista de jugadores.
     * @return atributo lista.
     */
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    
    /**
     * Establece la lista de jugadores.
     * @param playerList lista que se asignará al atributo.
     */
    public void setPlayerList(ArrayList<Player> playerList){
        this.playerList = playerList;
    }

    /**
     * Agrega un jugador a la lista de jugadores.
     * @param player El jugador a agregar.
     */
    public void addPlayer(Player player) {
        playerList.add(player);
    }
    
    /**
     * Busca un jugador en la lista de jugadores por nombre y contraseña.
     * 
     * @param name El nombre del jugador a buscar.
     * @param password La contraseña del jugador a buscar.
     * @return El jugador encontrado, o null si no se encontró.
     */
    public String searchPlayer(String name, String password) {
        Iterator<Player> iterator = playerList.iterator();
        while (iterator.hasNext()) {
            Player currentPlayer = iterator.next();
            if (currentPlayer.getName().equals(name) 
                    && currentPlayer.getPassword().equals(password)) {
                return currentPlayer.getPlayerInfo();
            }
        }
        return "";
    }

    /**
     * Verifica si un jugador ya existe en la lista de jugadores.
     * 
     * @param name El nombre del jugador a verificar.
     * @return true si el jugador ya existe, false en caso contrario.
     */
    public boolean playerExist(String name) {
        Iterator<Player> iterator = playerList.iterator();
        while (iterator.hasNext()) {
            Player currentPlayer = iterator.next();
            if (currentPlayer.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ordena la lista de jugadores por puntaje, (de mayor a menor)
     * Y retorna un string en formato "nombre - puntaje", con los 10 mejores puntajes.
     * 
     * @return info string que contiene el nombre y puntaje de los jugadores.
     */
    public String getBestScores() {
        if(playerList.isEmpty()){
            return "No hay registros";
        }
        
        playerList.sort(new ScoreComparator());
        int maxListIndex = 9; // top 10 scores

        // Si hay menos de 10 jugadores en la lista debe mostrar todos los encontrados
        if (playerList.size() < maxListIndex) {
            maxListIndex = playerList.size();
        }

        String info = "";
        for (int i = 0; i < maxListIndex; i++) {
            Player currentPlayer = playerList.get(i);
            info += currentPlayer.getName() + " - " + currentPlayer.getScore() + "\n";
        }
        return info;
    }
    
    
    public Player getPlayerByName(String name) {
        for (Player player : playerList) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }
    
}