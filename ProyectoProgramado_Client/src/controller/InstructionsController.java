package controller;

import view.InstructionsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.MainClient;

/**
 * Controlador para la ventana de instrucciones,
 * se encarga de cargar y mostrar las instrucciones y manejar los eventos
 * dentro de la ventana.
 */
public class InstructionsController implements ActionListener {

    private InstructionsView window;

    /**
     * Constructor de la clase.
     *
     * @param window ventana de instrucciones.
     */
    public InstructionsController(InstructionsView window) {
        this.window = window;
        initialize();
    }

    /**
     * Inicializa la vista y configura los ActionListener para los botones.
     */
    public void initialize() {
        window.setInstructions(MainClient.getText("getInstructions"));
        window.getBtnBack().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == window.getBtnBack()) {
            window.dispose();
        }
    }

}
