
package utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Permite detectar las acciones en el teclado.
 * Se utiliza para poder mover la nave y disparar.
 */
public class Keyboard implements KeyListener {

    private boolean[] keys;
    public static boolean left;
    public static boolean right;
    public static boolean shoot;

    /**
     * Inicializa el arreglo de teclas y las
     * variables estáticas.
     */
    public Keyboard() {
        keys = new boolean[256];
        left = false;
        right = false;
        shoot = false;
    }

    /**
     * Método que actualiza el estado de las variables estáticas según el estado
     * de las teclas.
     */
    public void update() {
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        shoot = keys[KeyEvent.VK_SPACE];
    }

    /**
     * Establece en true la tecla cuando se presiona.
     * @param e cuál tecla se presionó.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    /**
     * Establece en false la tecla cuando se libera
     * @param e cuál tercla se liberó.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

}