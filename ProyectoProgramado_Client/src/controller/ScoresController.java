package controller;

import view.ScoresView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.MainClient;

/**
 * Controlador para la ventana de puntajes, 
 * se encarga de carga de cargar y mostrar 
 * los mejores puntajes y manejar los eventos dentro de la ventana.
 */
public class ScoresController implements ActionListener {

    private ScoresView window;

    /**
     * Constructor de la clase.
     *
     * @param window ventana de puntuaciones.
     */
    public ScoresController(ScoresView window) {
        this.window = window;

        initialize();
    }
    private void updateScores() {
        window.setScores(MainClient.getText("getBestScores"));
    }

    /**
     * Inicializa la vista, carga los datos y configura los ActionListener para los botones.
     */
    public void initialize() {
        updateScores();
        window.getBtnBack().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == window.getBtnBack()) {
            window.dispose();
        }
    }
}
