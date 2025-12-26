package utils;

/**
* Clase que representa un vector 2D.
* Se utiliza para manejar las coordenadas de los objetos.
*/
public class Vector2D {

    private double x;
    private double y;
    
    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Resta el vector, con otro que recibe por parametro.
     * @param vector_restar Vector a restar.
     * @return Nuevo vector con la resta.
     */
    public Vector2D subtract(Vector2D vector_restar) {
        return new Vector2D(x - vector_restar.getX(), y - vector_restar.getY());
    }

    /**
     * Calcula la magnitud del vector
     * Se utiliza para las colisiones.
     * 
     * @return magnitud en double.
     * */
    public double magnitud() {
        return Math.sqrt(x * x + y * y);
    }
    
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Vector2D [x: " + x + ", y: " + y + "]";
    }

}
