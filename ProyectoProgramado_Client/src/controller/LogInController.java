
package controller;

import view.LogInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.MainClient;
import view.MenuView;

/**
 * Controlador para la autenticación de usuarios.
 * Este controlador gestiona las acciones relacionadas con la autenticación de usuarios
 * en la aplicación.
 */
public class LogInController implements ActionListener{
    
    private LogInView view;
    private MenuView menuView;
    private MenuController menuController;
    
    /**
     * Constructor de la clase LogInController.
     * 
     * @param vista La vista de inicio de sesión.
     */
    public LogInController(LogInView vista){
        this.view = vista;
        initialize();
    }
    
    /**
     * Inicializa la vista y configura los ActionListener para los botones.
     */
    public void initialize(){
        view.getLogInBtn().addActionListener(this);
        view.getBackBtn().addActionListener(this);
    }

    /**
     * Maneja las acciones de los botones en la ventana de autenticación de jugadores.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getLogInBtn()){
            String name = view.getNameTextField().getText();
            String password = view.getPasswordTextField().getText();
            
            //continúa verificando si existe un usuario con esos datos en el modelo.
            String player = MainClient.playerManager("searchPlayer",name, password);
            
            if(!player.isBlank()){
                
                String[] playerInfo = player.split("#");
                GameStatus.authenticatedPlayerName = playerInfo[0];
                GameStatus.score = Integer.parseInt(playerInfo[2]);
                
                // Si es válido el nombre y la contraseña, se debe hacer visible la vista de la pantalla del menú del juego.
                menuView = new MenuView();
                menuController = new MenuController(menuView);
            }else{
                JOptionPane.showMessageDialog(view, "El jugador no existe o \nla contraseña es incorrecta.");
            }
            
            //reiniciar cajas de texto
            view.getNameTextField().setText("");
            view.getPasswordTextField().setText("");
            
            view.dispose();
        }
    }
}
