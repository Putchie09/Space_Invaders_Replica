
package controller;

import view.GameWindow;
import view.InstructionsView;
import view.ScoresView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuView;

/**
 * Permite controlar los eventos de la ventana menú, como jugar,
 * ver instrucciones, puntajes y volver.
 */
public class MenuController implements ActionListener{
    
    
    private MenuView menuScreen;
    
    private ScoresView scoresView;
    private ScoresController scoresController;
    
    private InstructionsView instructionsView;
    private InstructionsController instructionsController;
    
    private GameWindow game;

    /**
     * Constructor.
     * @param menuScreen ventana del menú.
     */
    public MenuController(MenuView menuScreen) {
        this.menuScreen = menuScreen;        
        initialize();
    }
    
    /**
     * Inicializa la vista y configura los ActionListener para los botones.
     */
    public void initialize(){
        this.menuScreen.getjButtonPlay().addActionListener(this);
        this.menuScreen.getjButtonInstructions().addActionListener(this);
        this.menuScreen.getjButtonScores().addActionListener(this);
        this.menuScreen.getjButtonReturn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuScreen.getjButtonReturn()) {
            menuScreen.dispose();
        }
        if (e.getSource() == menuScreen.getjButtonPlay()) {
            game = new GameWindow();
        }
        if (e.getSource() == menuScreen.getjButtonInstructions()) {
            instructionsView = new InstructionsView();
            instructionsController = new InstructionsController(instructionsView);
        }
        if (e.getSource() == menuScreen.getjButtonScores()) {
            scoresView = new ScoresView();
            scoresController = new ScoresController(scoresView);
        }
        

    }
}
