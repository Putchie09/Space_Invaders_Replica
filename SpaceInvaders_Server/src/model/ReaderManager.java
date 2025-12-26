package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Permite cargar (o leer) la información almacenada en los archivos properties,
 * como los datos de los jugadores y las instrucciones del juego.
 */
public class ReaderManager {
    
    private static final String FILE_NAME = "src/dataFiles/playersData.properties";
    private static final String INSTRUCTIONS_FILE_NAME = "dataFiles/instructions.properties";
    private static final String CONF_FILE_NAME ="dataFiles/settings.properties";
    private static final String REGEX_TO_SPLIT = "#";
    private Properties properties;
    private Properties confFile;

    
    /**
     * Carga el archivo playerData, en la instancia de Properties.
     * */
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
     * Lee el archivo y carga en una lista los usuarios con los valores dentro del archivo.
     * @return usersList lista de usuarios en el archivo.
     */
    public synchronized ArrayList<Player> readPlayers(){
        openFile();
        
        ArrayList<Player> usersList = new ArrayList<>();
        
        String namesProperty = properties.getProperty("name");
        if(namesProperty.isBlank()){ // No hay registros
            return usersList;
        }
        
        // formato en archivo: nombre1-nombre2-nombre3
        String[] names = namesProperty.split(REGEX_TO_SPLIT);
        String[] passwords = properties.getProperty("password").split(REGEX_TO_SPLIT);
        String[] scores = properties.getProperty("score").split(REGEX_TO_SPLIT);
        
        loadPlayers(names, passwords, scores, usersList);
        
        return usersList;
    }
    
    /**
     * Permite cargar las configuraciones escenciales del programa, como el tamaño de las ventanas,
     * configuraciones de los enemigos, láseres etc...
     */
    public void loadConfiguration(){
        confFile = new Properties();
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(CONF_FILE_NAME)) {
            if (inputStream != null) {
                confFile.load(inputStream);
            } else {
                System.err.println("Configuraciones no encontradas");
                System.exit(0);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuración " + CONF_FILE_NAME);
            e.printStackTrace();
        }
    }
    
    /**
     * Permite obtener las configuraciones int cargadas en el loadConfiguration
     */
    public int getSetting(String settingName){
        if(confFile == null){
            loadConfiguration();
        }
        
        int result = -1;
        try{
            result = Integer.parseInt(confFile.getProperty(settingName));
        }catch( Exception e){
            System.err.println("Error al obtener " + settingName);
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Crea los jugadores con la información del archivo y los almacena en la lista.
     * @param names lista de nombres en el archivo.
     * @param passwords lista de constraseñas en el archivo.
     * @param scores lista de puntajes en el archivo.
     * @param list lista donde añadir los jugadores.
     */
    private void loadPlayers(String[] names, String[] passwords, String[] scores, ArrayList<Player> list){
        for(int i = 0; i < names.length; i++){
            list.add(new Player(names[i], passwords[i], Integer.parseInt(scores[i])));
        }
    }
    
    
    public String readInstructions() {
        Properties instructionsFile = new Properties();
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(INSTRUCTIONS_FILE_NAME)) {
            if (inputStream != null) {
                instructionsFile.load(inputStream);
            } else {
                System.out.println("Error al cargar archivo " + INSTRUCTIONS_FILE_NAME);
                return "Archivo de instrucciones no encontrado";
            }
        } catch (IOException e) {
            System.out.println("Error al cargar archivo " + INSTRUCTIONS_FILE_NAME);
            return "Archivo de instrucciones no encontrado";
        }

        String instructions = "";
        String gameplay = instructionsFile.getProperty("gameplay"); // cómo jugar
        String gameOver = instructionsFile.getProperty("gameOver"); // cómo ganar

        // puntos por derrotar enemigos
        String enemyInfo = "Puntos al derrotar enemigos:\n" + instructionsFile.getProperty("enemyPoints");

        instructions += gameplay + gameOver + "\n" + enemyInfo;

        return instructions;
    }

    
    /**
     * Crea el archivo y le agrega las propiedades sin valores.
     */
    public void createFile(){
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
