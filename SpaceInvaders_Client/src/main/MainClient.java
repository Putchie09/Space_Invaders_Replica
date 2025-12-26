package main;

import conf.Asset;
import controller.InitialController;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.InitialView;

/**
 * I Proyecto - Programación
 * II UCR - I SEMESTRE 2024
 *
 * @author Dayanara Campos
 * @author Keleny Zamora
 * @author Manuel Franco
 * @author Yoel Putchie
 *
 * @version 10-05-2024
 * 
 * Esta clase representa el cliente del juego. Se conecta al servidor, procesa la conexión,
 * y maneja las interacciones con el servidor, como enviar y recibir datos.
 */
public class MainClient {

    private static DataOutputStream output;
    private static DataInputStream input;
    private static Socket client;
    private final String HOST = "127.0.0.1";
    private final int PORT = 12345;
    private static boolean running; // para controlar si se corta la conexión
    
    /**
     * Se piden al servidor al iniciar el cliente, para no tener que pedirlo
     * cada vez que se ocupan.
     * ej, detectar enemigos fuera de pantalla se hace 60 veces por segundo
     */
    public static int width;
    public static int height;

    // Conectarse al servidor y manejar dicha conexión
    public void runClient() {
        running = true;

        try {
            connectToServer();
            getStreams();
            processConnection();
        } catch (IOException ex) {
            System.out.println("Conexión perdida, intentando reconectar...");
        }
        closeConnection();

    }

    // establecer la conexión con el servidor
    private void connectToServer() throws IOException {
        System.out.println("Envío de solicitud de conexión\n");
        client = new Socket(HOST, PORT);
        System.out.println("Conectado a: " + client.getInetAddress().getHostName());
    }

    // Obtener flujos de entrada y salida
    private void getStreams() throws IOException {
        output = new DataOutputStream(client.getOutputStream());
        output.flush();
        input = new DataInputStream(client.getInputStream());
    }

    /**
     * Realiza las peticiones iniciales al servidor y mantiene
     * la conexión
     */
    private void processConnection() {
        //Se piden justo después de hacer la conexión
        this.width  = getSetting("WIDTH");
        this.height = getSetting("HEIGHT");
        
        InitialView initialScreen = new InitialView();
        InitialController controller = new InitialController(initialScreen);
        
        //bucle infinito para mantener la conexión
        while (running) {

        }
    }

    private void closeConnection() {
        System.out.println("\nCerrando conexión");
        try {
            client.close();
            output.close();
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Permite enviar los datos del jugador actual, y recibir un resultado. Ej para inscribir un usuario.
     *
     * @param methodName nombre del método que se utilizará del lado del servidor.
     * @param name nombre del jugador.
     * @param password contrasena del jugador.
     * @return información retornada por el servidor, depende del methodName.
     */
    public static String playerManager(String methodName, String name, String password) {
        evaluateConnection();

        String player = "";
        try {
            output.writeUTF(methodName);
            output.writeUTF(name);
            output.writeUTF(password);
            player = input.readUTF();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return player;
    }

    /**
     * Permite hacer una solicitud de strings al servidor
     * Ej los datos del usuario en un cierto formato.
     *
     * @param methodName método que se utilizará en el servidor.
     * @return información retornada por el servidor.
     */
    public static String getText(String methodName) {
        evaluateConnection();

        String text = "";
        try {
            output.writeUTF(methodName);
            text = input.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;
    }

    /**
     * Verifica la conexión con el servidor.
     * Intenta hacer una petición al hilo de la conexión,
     * si hay una excepción quiere decir que hubo una interrupción con el servidor.
     */
    private static void evaluateConnection() {

        try {
            output.writeUTF(" ");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Conexión con el servidor perdida...");
            System.out.println("Conexión con el servidor perdida...");
            System.exit(0);
        }
    }

    /**
     * Envia la instrucción al servidor de actualizar el puntaje de un jugador.
     *
     * @param name nombre del jugador al que se le actualizará el puntaje.
     * @param newScore puntaje a almacenar.
     */
    public static void updatePlayerScore(String name, int newScore) {
        evaluateConnection();

        try {
            output.writeUTF("updatePlayerScore");
            output.writeUTF(name);
            output.writeInt(newScore);
        } catch (IOException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Main del cliente. Inicializa los assets,
     * la ventana principal y establece la conexión con el servidor.
     */
    public static void main(String[] args) {
        Asset.initAssets();
        

        new MainClient().runClient();
    }
    
    /**
     * Permite solicitarle al servidor una propiedad específica
     * del archivo de configuraciones del juego.
     * Si recibe un -1 no se pudo cargar la propiedad y cierra el programa.
     * 
     * @param settingName nombre de la propiedad a solicitar
     * @return valor obtenido de la propiedad
     */
    public static int getSetting(String settingName){
        evaluateConnection();
        int result = 0;
        
        try{
            output.writeUTF("getSetting");
            output.writeUTF(settingName);
            result = input.readInt();
        } catch (IOException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(result == -1){
            JOptionPane.showMessageDialog(null, "Error al cargar: " + settingName);
            System.exit(0);
        }
        
        return result;
    }
    
    
    
}
