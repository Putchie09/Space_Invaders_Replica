package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/**
 * Hilo principal para recibir las solicitudes del "cliente" y enviar los datos.
 */
public class ConnectionThread extends Thread {

    private Socket player;
    private DataOutputStream output;
    private DataInputStream input;

    public ConnectionThread(Socket player) {
        this.player = player;
    }

    @Override
    public void run() {
        try {
            getStreams();
            processConnection();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally{
            closeConnection();
        }
    }

    /**
     * Procesa las solicitudes del cliente de forma continua hasta que la conexión se cierra.
     */
    private void processConnection() {
        String playerName;
        String playerPassword;

        try {
            while (true) {

                //El cliente cerró la conexión
                if (input == null || output == null) {
                    return;
                }

                //recibe las solicitudes hechas por el cliente
                String clientRequest = input.readUTF();
                if (clientRequest != null && !clientRequest.isBlank()) {

                    //Verifica qué dato se está solicitando y envia la respuesta
                    switch (clientRequest) {
                        case "updatePlayerScore":
                            playerName = input.readUTF();
                            int playerScore = input.readInt();
                            MainServer.model.updatePlayerScore(playerName, playerScore);
                            break;
                        case "getInstructions":
                            output.writeUTF(MainServer.model.getInstructions());
                            break;
                        case "searchPlayer":
                            playerName = input.readUTF();
                            playerPassword = input.readUTF();
                            output.writeUTF(MainServer.model.searchPlayer(playerName, playerPassword));
                            break;
                        case "addPlayer":
                            playerName = input.readUTF();
                            playerPassword = input.readUTF();
                            output.writeUTF(MainServer.model.addPlayer(playerName, playerPassword));
                            break;
                        case "getBestScores":
                            output.writeUTF(MainServer.model.getBestScores());
                            break;
                        case"getSetting":
                            String settingName = input.readUTF();
                            output.writeInt(MainServer.model.getSetting(settingName));
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            }// fin while

        } catch (SocketException se){
            
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            ioe.printStackTrace();
        }

    }

    /**
     * Obtener flujos de entrada y salida.
     *
     * @throws IOException.
     */
    private void getStreams() throws IOException {
        output = new DataOutputStream(player.getOutputStream());
        output.flush();
        input = new DataInputStream(player.getInputStream());
    }

    /**
     * Cierra la conexión con el cliente y libera los recursos.
     */
    private void closeConnection() {
        System.out.println("\nTerminando conexión con: " + player.getInetAddress().getHostName() +"\n");
        try {
            if (output != null) {
                output.close();
            }
            if (input != null) {
                input.close();
            }
            if (player != null) {
                player.close();
            }
        } catch (IOException ex) {
            System.err.println("Error al cerrar conexión: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
