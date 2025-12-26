package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import model.DAOInformation;

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
 * Esta clase inicializa y ejecuta el servidor
 * El servidor acepta conexiones de clientes (jugadores) y maneja cada conexión en un hilo separado.
 */

public class MainServer {

    private ServerSocket server;
    private final int PORT = 12345;
    public static DAOInformation model;

    public void runServer() {
        try {
            server = new ServerSocket(PORT);
            while (true) {
                try {
                    Socket player = waitForConnection();
                    System.out.println("Conexión establecida con: " + player.getInetAddress().getHostName());
                    //transferir la conexión con el jugador a un hilo aparte
                    ConnectionThread thread = new ConnectionThread(player);
                    thread.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
        closeServer();
    }

    private Socket waitForConnection() throws IOException {
        System.out.println("\nEsperando conexión...");
        Socket connection = server.accept();
        return connection;
    }

    private void closeServer() {
        System.out.println("\nCerrando servidor...");
        try {
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
     public static void main(String[] args) {
        model = new DAOInformation();
        model.loadPlayers(); // cargar usuarios
        new MainServer().runServer();
    }
}
