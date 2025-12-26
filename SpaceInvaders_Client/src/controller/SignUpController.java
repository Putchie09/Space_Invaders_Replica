package controller;

import view.SignUpView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.MainClient;
import view.MenuView;

/**
 * Controlador para la inscripción de usuarios. Este controlador gestiona las
 * acciones relacionadas con la inscripción de nuevos usuarios en la aplicación.
 */
public class SignUpController implements ActionListener {

    private SignUpView view;
    private MenuView menuView;
    private MenuController menuController;

    /**
     * Constructor de la clase SignInController.
     *
     * @param vista La vista de inscripción de usuarios.
     */
    public SignUpController(SignUpView vista) {
        this.view = vista;
        initialize();
    }

    /**
     * Inicializa la vista y configura los ActionListener para los botones.
     */
    public void initialize() {
        view.getSignInBtn().addActionListener(this);
        view.getBackBtn().addActionListener(this);
    }

    /**
     * Maneja las acciones de los botones en la ventana de inscripción de
     * jugadores.
     *
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSignInBtn()) {
            String name = view.getNameTextField().getText();
            String password = view.getPasswordTextField().getText();

            String userRegister = MainClient.playerManager("addPlayer", name, password);
            JOptionPane.showMessageDialog(view, userRegister);

            if (userRegister.equals("¡Usuario registrado correctamente!")) {
                GameStatus.authenticatedPlayerName = name;
                menuView = new MenuView();
                menuController = new MenuController(menuView);
            }
            
            view.getNameTextField().setText("");
            view.getPasswordTextField().setText("");
            
            // Sí logra inscribir, se debe hacer visible la vista de la pantalla del menú del juego.
            view.dispose();
        }
        
        if(e.getSource() == view.getBackBtn()){
            view.dispose();
        }
        
    }
}
