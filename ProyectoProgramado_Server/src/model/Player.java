package model;

/**
 * Representa un jugador, con su información básica: nombre, contraseña y
 * puntaje.
 */
public class Player implements Comparable<Player> {

    private String name;
    private String password;
    private int score;

    public Player() {
    }

    public Player(String name, String password, int score) {
        this.name = name;
        this.password = password;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player [" + "name: " + name + ", password: " + password + ", score: " + score + ']';
    }

    /**
     * Se utiliza para retornar al cliente, el jugador actual, con un cierto formato.
     * @return información del jugador.
     */
    public String getPlayerInfo() {
        return name + "#" + password + "#" + score;
    }

    /**
     * Se utiliza para ordenar la lista por puntaje.
     */
    @Override
    public int compareTo(Player o) {
        return Integer.compare(this.getScore(), o.getScore());
    }

}
