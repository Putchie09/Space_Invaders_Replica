package model;

/**
 * Clase para el acceso a datos de jugadores. 
 * Esta clase proporciona métodos para agregar y buscar jugadores en la lista de jugadores.
 */
public class DAOInformation {

    private PlayerList playerList = new PlayerList();
    private ReaderManager reader = new ReaderManager();
    private WriterManager writer = new WriterManager();

    /**
     * Carga los jugadores del archivo a la lista.
     */
    public synchronized void loadPlayers() {
        playerList.setPlayerList(reader.readPlayers());
    }

    /**
     * Guarda los jugadores de la lista en el archivo.
     */
    public synchronized void savePlayers() {
        writer.writeList(playerList.getPlayerList());
    }

    /**
     * Agrega un nuevo jugador a la lista de jugadores.
     *
     * @param name Nombre del jugador.
     * @param password Contraseña del jugador.
     * @return true si se agrega el jugador correctamente, false si el nombre de usuario ya existe o es inválido.
     */
    public synchronized String addPlayer(String name, String password) {
        if (!name.isBlank() && !playerList.playerExist(name) 
                && validateName(name) && validatePassword(password)) {
            
            Player newPlayer = new Player(name, password, 0);
            playerList.addPlayer(newPlayer);
            writer.writePlayer(newPlayer);
            return "¡Usuario registrado correctamente!";
        }
        
        // Mensajes de error en la validación
        if (playerList.playerExist(name)) {
            return "Error: Ese nombre de jugador ya está siendo utilizado.";
        }
        
        if(!validateName(name)) {
            return "Error: Nombre de usuario no válido.\nDebe contener caracteres alfanuméricos, mí­nimo 4 máximo 20.";
        } 
        
        if(!validatePassword(password)) {
            return "Error: Contraseña no válida.\nDebe contener mínimo una minúscula, una mayúscula, un caracter especial y tener entre 4 y 10 caracteres.";
        }
        return "Error.";
    }
    
    

    /**
     * Verifica que el nombre esté formado por caracteres alfanuméricos (letras y dí­gitos) 
     * con una longitud mí­nima de 4 caracteres y una longitud máxima de 20 caracteres.
     *
     * @param name el nombre a validar
     * @return true si el nombre cumple con los requisitos, false en caso contrario
     */
    public boolean validateName(String name) {
        boolean correctName;
        String reqName = "^[a-zA-Z0-9]{4,20}$";
        correctName = name.matches(reqName);
        return correctName;
    }

    /**
     * Verifica que la contraseña contenga al menos una letra minúscula, al menos una letra mayúscula 
     * al menos un dí­gito, al menos un caracter especial, una longitud entre 4 y 10 caracteres.
     *
     * @param contrasena la contraseña a validar
     * @return true si la contraseña cumple con los requisitos, false en caso contrario
     */
    public boolean validatePassword(String contrasena) {
        boolean passwordCorrect;
        String reqPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%?&*])[A-Za-z\\d@$!%?&*]{4,10}$";
        passwordCorrect = contrasena.matches(reqPassword); // Verifica si la contraseÃ±a cumple con los requisitos
        return passwordCorrect;
    }

    /**
     * Busca un jugador en la lista de jugadores.
     *
     * @param name Nombre del jugador a buscar.
     * @param password Contraseña del jugador a buscar.
     * @return El la informacion del jugador encontrado, o vacío si no se encontró.
     */
    public String searchPlayer(String name, String password) {
        return playerList.searchPlayer(name, password);
    }

    /**
     * Obtiene y retorna los jugadores con mejor puntaje.
     *
     * @return string con los jugadores (nombre - puntaje).
     */
    public String getBestScores() {
        loadPlayers();
        return playerList.getBestScores();
    }

    /**
     * Obtiene y retorna las instrucciones del juego.
     *
     * @return string con las instrucciones.
     */
    public String getInstructions() {
        return reader.readInstructions();
    }

    /**
    * Obtiene un jugador por su nombre.
    *
    * @param name el nombre del jugador a buscar
    * @return el objeto Player correspondiente al nombre proporcionado, o null si no se encuentra
    */
    public Player getPlayerByName(String name) {
        return playerList.getPlayerByName(name);
    }

    /**
    * Actualiza el puntaje de un jugador si el nuevo puntaje es mayor que el puntaje actual.
    * Esta operación está sincronizada para evitar condiciones de carrera.
    *
    * @param name el nombre del jugador cuyo puntaje se actualizará
    * @param newScore el nuevo puntaje a asignar
    */
    public synchronized void updatePlayerScore(String name, int newScore) {
        Player player = playerList.getPlayerByName(name);
        if (player != null) {
            if (player.getScore() < newScore) {
                player.setScore(newScore);
                savePlayers();
            }

        }
    }
    
    /**
    * Obtiene el valor de una configuración específica.
    *
    * @param settingName el nombre de la configuración a obtener
    * @return el valor de la configuración solicitada
    */
    public int getSetting(String settingName){
        return reader.getSetting(settingName);
    }
    
}
