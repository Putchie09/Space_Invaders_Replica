package controller;

import view.InitialView;
import view.LogInView;
import view.SignUpView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Permite controlar los eventos de la ventana inicial.
 */
public class InitialController implements ActionListener {
    
    private InitialView initialScreen;
    
    private SignUpView signUpView;
    private SignUpController signUpController;
    
    private LogInView logInView;
    private LogInController logInController;
    
    /**
     * Constructor de la clase.
     * 
     * @param initialScreen La ventana de inicio.
     */
    public InitialController(InitialView initialScreen) {
        this.initialScreen = initialScreen;
        
        initialize();
    }
    
    /**
     * Inicializa la vista y configura los ActionListener para los botones.
     */
    public void initialize(){
        initialScreen.getSignUpBtn().addActionListener(this);
        initialScreen.getAuthenticateBtn().addActionListener(this);
        initialScreen.getExitBtn().addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //botón de iniciar sesión
        if(e.getSource()== initialScreen.getSignUpBtn()) {
            signUpView = new SignUpView();
            signUpController = new SignUpController(signUpView);
        }
        
        //botón de autenticar
        if (e.getSource() == initialScreen.getAuthenticateBtn()) {
            logInView = new LogInView();
            logInController = new LogInController(logInView);
        }
        
        //botón de salir
        if (e.getSource() == initialScreen.getExitBtn()) {
            System.exit(0);
        }
    }
}
