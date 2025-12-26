package utils;

import view.GameWindow;


/**
 * Hilo principal del juego, controla que la actualización y dibujo se realicen a una velocidad constante y fluida.
 */
public class ThreadFPS extends Thread {

    private boolean running;
    private GameWindow window;
    public static final int FPS = 60;
    
    //cuántas veces se actualiza la pantalla por segundo (60 fps) 
    private double refreshRate = 1000000000 / FPS;
    
    //Solucionar la variación de "velocidad" según la cantidad de fps que tenga el cliente
    private double delta = 0;

    public ThreadFPS(GameWindow window) {
        this.window = window;
        running = true;
    }

    public void activate() {
        running = true;
    }

    /**
     * Método principal que controla el ciclo de juego.
     * Calcula la cantidad de tiempo transcurrido entre actualizaciones y dibuja en la ventana del juego.
     */
    @Override
    public void run() {
        long currentTime = 0;
        long previousTime  = System.nanoTime();
        int frames = 0;
        int time = 0;

        while (running) {
            currentTime = System.nanoTime();
            delta += (currentTime - previousTime ) / refreshRate;
            time += (currentTime - previousTime );
            previousTime  = currentTime;

            // Actualiza y dibuja la ventana del juego si ha pasado el tiempo suficiente
            if (delta >= 1) {
                window.update();
                window.draw();
                delta--;
                frames++;
            }

            if (time >= 1000000000) {
                frames = 0;
                time = 0;
            }
        }
    }

    /**
     * Detener temporalmente el hilo
     */
    public void stopThread() {
        running = false;
        
    }

}

