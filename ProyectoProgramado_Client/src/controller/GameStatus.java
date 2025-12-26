package controller;

import model.*;
import utils.*;
import java.awt.*;
import main.MainClient;

/**
 * Se encarga de la lógica general del juego.
 */
public class GameStatus {

    public static SpaceShip player;
    public static MovableObjectsList objectList;
    public static EnemiesList enemiesList;
    private Crono enemiesCrono;
    private Crono specialEnemiesCrono;
    private SpecialEnemyFactory specialEnemyFactory;
    public static String authenticatedPlayerName;
    public static int score;
    private boolean gameOver;

    private static final int ENEMY_COOLDOWN_MIN = MainClient.getSetting("ENEMY_COOLDOWN_MIN");
    private static final int ENEMY_COOLDOWN_MAX = MainClient.getSetting("ENEMY_COOLDOWN_MAX");
    private static final int SPECIAL_ENEMY_SPAWN_COOLDOWN_MIN = MainClient.getSetting("SPECIAL_ENEMY_SPAWN_COOLDOWN_MIN");
    private static final int SPECIAL_ENEMY_SPAWN_COOLDOWN_MAX = MainClient.getSetting("SPECIAL_ENEMY_SPAWN_COOLDOWN_MAX");
    private final Vector2D INITIAL_PLAYER_POSITION = new Vector2D(MainClient.width / 2 - 25, MainClient.height - 120);

    public GameStatus() {

        objectList = new MovableObjectsList();
        enemiesList = new EnemiesList();
        specialEnemyFactory = new SpecialEnemyFactory();
        gameOver = false;

        // Cronómetro para enemigos
        enemiesCrono = new Crono();
        specialEnemiesCrono = new Crono(); //Se llama su "run" para evitar la creación inmediata de un enemigo especial
        specialEnemiesCrono.run(generateSpecialEnemySpawnTime());

        // Crear el jugador
        player = new SpaceShip(INITIAL_PLAYER_POSITION);
        objectList.addObject(player);

        //Crear enemigos
        enemiesList.generateEnemies();
    }

    /**
     * Actualiza los objetos del juego
     */
    public void update() {

        //Cuando se acaba el juego se dejan de generar enemigos y actualizar objetos
        if (gameOver) {
            return;
        }

        objectList.updateObjects();
        enemiesList.updateEnemies();

        //Ataques de enemigos
        if (!enemiesCrono.isRunning()) {
            enemiesList.randomAttack();
            //Número aleatorio entre 0.5 y 2 segundos
            enemiesCrono.run((int) (Math.random() * ENEMY_COOLDOWN_MAX) + ENEMY_COOLDOWN_MIN);
        }
        enemiesCrono.update();

        // Crear enemigo especial
        if (!specialEnemiesCrono.isRunning()) {
            objectList.addObject(specialEnemyFactory.createSpecialEnemy());
            //Número aleatorio entre 10 y 15 segundos
            specialEnemiesCrono.run(generateSpecialEnemySpawnTime());
        }
        specialEnemiesCrono.update();
    }

    /**
     * Dibuja los objetos del juego y la HUD
     *
     * @param g
     */
    public void draw(Graphics g) {
        objectList.drawObjects(g);
        enemiesList.drawEnemies(g);
        drawHUD(g, player);

        // Dibujar pantalla final
        if (player.isDead()) {
            endGameMessage(g, false);
            gameOver = true;
        } else if (enemiesList.isEmpty() && !player.isDead()) {
            endGameMessage(g, true);
            gameOver = true;
        }
    }

    /**
    * Genera un tiempo de aparición aleatorio para un enemigo especial.
    */
    private int generateSpecialEnemySpawnTime() {
        return (int) (Math.random() * SPECIAL_ENEMY_SPAWN_COOLDOWN_MAX) + SPECIAL_ENEMY_SPAWN_COOLDOWN_MIN;
    }

    /**
     * Permite dibujar el mensaje final, cuando pierde o gana.
     *
     * @param g
     * @param victory
     */
    public void endGameMessage(Graphics g, boolean victory) {
        //Pintar pantalla de negro
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, MainClient.width, MainClient.height);
        g.drawRect(0, 0, MainClient.width, MainClient.height);

        if (victory) {
            drawText("Has ganado", Color.GREEN, g, new Vector2D(MainClient.width / 2, MainClient.height / 2), true,
                    new Font("Tahoma", Font.PLAIN, 45));

            MainClient.updatePlayerScore(authenticatedPlayerName, player.getScore());

        } else {
            drawText("Perdiste", Color.RED, g, new Vector2D(MainClient.width / 2, MainClient.height / 2), true,
                    new Font("Tahoma", Font.PLAIN, 45));
        }

        drawText("Puntaje: " + player.getScore(), Color.GREEN, g,
                new Vector2D(MainClient.width / 2, MainClient.height / 2 + 30), true,
                new Font("Tahoma", Font.PLAIN, 18));

        drawText("Cierre la ventana para volver", Color.WHITE, g,
                new Vector2D(MainClient.width / 2, MainClient.height - 200), true,
                new Font("Tahoma", Font.PLAIN, 18));
    }

    /**
     * Permite dibujar el puntaje y las vidas del jugador.
     *
     * @param g
     * @param player
     */
    public void drawHUD(Graphics g, SpaceShip player) {
        // NOMBRE JUGADOR en la esquina superior izquierda
        drawText("JUGADOR: " + authenticatedPlayerName, Color.WHITE, g, new Vector2D(25, 30), false,
                new Font("Tahoma", Font.PLAIN, 18));

        // PUNTAJE ACTUAL en la esquina superior derecha
        drawText("PUNTAJE: " + String.valueOf(player.getScore()), Color.WHITE, g, new Vector2D(565, 30), false,
                new Font("Tahoma", Font.PLAIN, 18));

        // VIDAS en la esquina superior derecha, al lado del puntaje
        drawText("VIDAS: " + String.valueOf(player.getLives()), Color.WHITE, g, new Vector2D(700, 30), false,
                new Font("Tahoma", Font.PLAIN, 18));
    }

    /**
     * Permite dibujar textos en la pantalla.
     *
     * @param text a dibujar.
     * @param color del texto.
     * @param g elemento con el cual dibujar.
     * @param font tamaño de fuente.
     * @param pos posición del texto.
     * @param centrado true o false.
     */
    public static void drawText(String text, Color color, Graphics g, Vector2D pos, boolean centrado, Font font) {
        g.setFont(font);
        g.setColor(color);

        // Se crea un nuevo vector, para no modificar la posicion original
        Vector2D position = new Vector2D(pos.getX(), pos.getY());

        if (centrado) {
            // Obtiene las dimensiones del texto
            FontMetrics font_Dimensions = g.getFontMetrics();

            // setea la x en el centro del texto horizontalmente
            position.setX(position.getX() - font_Dimensions.stringWidth(text) / 2);

            // setea la y en el centro del texto verticalmente, el alto depende de la fuente
            position.setY(position.getY() - font_Dimensions.getHeight() / 2);
        }
        g.drawString(text, (int) position.getX(), (int) position.getY());
    }

}
