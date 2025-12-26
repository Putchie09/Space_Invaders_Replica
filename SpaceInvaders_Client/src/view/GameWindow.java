package view;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import utils.ThreadFPS;
import controller.GameStatus;
import java.awt.Color;
import main.MainClient;
import utils.Keyboard;

/**
 * Ventana principal del juego en la que se dibujan los assets y gestiona el ciclo principal del juego.
 */
public class GameWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private BufferStrategy bs;
    private Graphics g;
    private Canvas lienzo;
    private ThreadFPS thread;
    public Keyboard keyboard;
    public GameStatus gameStatus;
    
    private int WIDTH = MainClient.width;
    private int HEIGHT = MainClient.height;

    public GameWindow() {
        setTitle("SPACE INVADERS");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        
        lienzo = new Canvas();
        lienzo.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        lienzo.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        lienzo.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        lienzo.setFocusable(true);
        this.add(lienzo);

        keyboard = new Keyboard();
        lienzo.addKeyListener(keyboard);

        eventListener();
        

        initialize(); // Inicializa el estado del juego
        thread = new ThreadFPS(this);
        thread.start(); // Inicia el hilo del juego
        setVisible(true);
    }

    public void initialize() {
        gameStatus = new GameStatus();
    }

    /**
     * Actualiza el estado del juego en cada frame.
     * Llama a las funciones de actualización del teclado y del estado del juego.
     */
    public void update() {
        keyboard.update();
        gameStatus.update();
    }

    /**
     * Dibuja los elementos del juego en la ventana.
     */
    public void draw() {
        bs = lienzo.getBufferStrategy();

        if (bs == null) {
            lienzo.createBufferStrategy(3);
            bs = lienzo.getBufferStrategy();
        }

        g = bs.getDrawGraphics();

        // DIBUJAR ASSETS
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        gameStatus.draw(g);

        g.dispose();
        bs.show();
    }

    /**
     * Detecta cuando se presiona la x de la ventana.
     */
    public void eventListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GameStatus.objectList.clearList(); // limpiar la lista
                thread.stopThread(); // detener hilo 
                dispose();
            }
        });
    }
}
