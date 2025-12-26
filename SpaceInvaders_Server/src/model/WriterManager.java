package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

/**
 * Permite guardar (o escribir) la información en la lista de usuarios, en los archivos properties.
 */
public class WriterManager {

    private static final String FILE_NAME = "src/dataFiles/playersData.properties";
    private static final String REGEX_TO_SPLIT = "#";
    private Properties properties;

    /**
     * Carga el archivo playerData, en la instancia de Properties.
     *
     */
    public void openFile() {
        properties = new Properties();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            createFile();
        }

        try (FileInputStream in = new FileInputStream(file)) {
            properties.load(in);

        } catch (IOException ex) {
            System.err.println("Error a abrir el archivo: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Guarda los datos de la instancia de Properties en el archivo playerData.
     */
    public void saveFile() {
        try {
            properties.store(new FileWriter(FILE_NAME), "Player Data");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + FILE_NAME + ": " + e.getMessage());
        }
    }

    /**
     * Permite añadir un usuario al archivo playerData.
     *
     * @param player jugar que se agregará.
     */
    public void writePlayer(Player player) {
        openFile();

        //Obtiene el valor actual de cada propiedad del archivo
        StringBuilder nameValue = new StringBuilder(properties.getProperty("name"));
        StringBuilder passwordValue = new StringBuilder(properties.getProperty("password"));
        StringBuilder scoreValue = new StringBuilder(properties.getProperty("score"));

        //Si ya hay jugadores se agrega el regex para separar los datos
        if (nameValue.length() > 0) {
            nameValue.append(REGEX_TO_SPLIT);
            passwordValue.append(REGEX_TO_SPLIT);
            scoreValue.append(REGEX_TO_SPLIT);
        }
        nameValue.append(player.getName());
        passwordValue.append(player.getPassword());
        scoreValue.append(player.getScore());

        //guardar la información de los usuarios
        properties.setProperty("name", nameValue.toString());
        properties.setProperty("password", passwordValue.toString());
        properties.setProperty("score", scoreValue.toString());

        saveFile();
    }

    /**
     * Recorre la lista de jugadores, obtiene sus propiedades y las agrega al archivo playerData.
     *
     * @param list lista de usuarios a almacenar.
     */
    public void writeList(ArrayList<Player> list) {
        openFile();

        StringBuilder namesInfo = new StringBuilder();
        StringBuilder passwordsInfo = new StringBuilder();
        StringBuilder scoresInfo = new StringBuilder();

        //Obtiene la información de cada jugador y la agrega a un string con el regex
        Iterator<Player> iterator = list.iterator();
        while (iterator.hasNext()) {
            Player currentPlayer = iterator.next();

            //si ya hay usuarios se agrega el regex para separar los datos
            if (namesInfo.length() > 0) {
                namesInfo.append(REGEX_TO_SPLIT);
                passwordsInfo.append(REGEX_TO_SPLIT);
                scoresInfo.append(REGEX_TO_SPLIT);
            }
            namesInfo.append(currentPlayer.getName());
            passwordsInfo.append(currentPlayer.getPassword());
            scoresInfo.append(currentPlayer.getScore());
        }

        //guardar la información de los usuarios
        properties.setProperty("name", namesInfo.toString());
        properties.setProperty("password", passwordsInfo.toString());
        properties.setProperty("score", scoresInfo.toString());

        saveFile();
    }

    public void createFile() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            try {
                file.createNewFile();
                properties.load(new FileReader(file));

                properties.setProperty("name", "");
                properties.setProperty("password", "");
                properties.setProperty("score", "");
                properties.store(new FileWriter(file), "Actualizado");
            } catch (IOException ex) {
                System.out.println("Error al crear el archivo: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
