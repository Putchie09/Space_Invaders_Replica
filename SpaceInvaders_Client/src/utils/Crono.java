package utils;

/**
 * Clase para medir tiempo entre eventos.
 * Se utiliza para que no se pueda spamear el laser.
 */
public class Crono {

    private long delta;
    private long elapsedTime;
    private long waitingTime;
    private boolean running;

    public Crono() {
        this.delta = 0;
        this.elapsedTime = 0;
        this.running = false;
    }

    // Inicia el crono con un tiempo de espera específico.
    public void run(long waitingTime) {
        running = true;
        this.waitingTime = waitingTime;
        delta = 0;
    }

    // Calcula el tiempo transcurrido desde el último evento y verifica si ha pasado el tiempo de espera.
    public void update() {
        if (running) {
            delta += System.currentTimeMillis() - elapsedTime;
        }

        //Si terminó el tiempo de espera
        if (delta >= waitingTime) {
            running = false;
            delta = 0;
        }

        elapsedTime = System.currentTimeMillis();
    }

    public boolean isRunning() {
        return running;
    }

}
