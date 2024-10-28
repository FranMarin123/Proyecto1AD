package example.view;

/**
 * Enumeration for managing FXML scene paths in the application.
 * Each enum constant represents a scene and stores the path to its FXML file.
 */
public enum Scenes {
    ROOT("root.fxml"),
    MAINMENU("mainMenu.fxml"),
    SIGNIN("signin.fxml"),
    LOGIN("login.fxml"),
    HOME("home.fxml"),
    GROUP_PARTICIPANTS("groupParticipants.fxml"),
    CONVERSATION("conversation.fxml"),
    CREATEGROUP("createGroup.fxml"),
    EXPORT("exportConversation.fxml")
    ;

    /** The file path of the FXML file associated with the scene. */
    private String path;

    /**
     * Constructor for a Scenes enum constant, initializing with the specified FXML path.
     *
     * @param path The path to the FXML file corresponding to the scene.
     */
    Scenes(String path){
        this.path=path;
    }

    /**
     * Returns the file path of the FXML associated with the scene.
     *
     * @return A string representing the path of the FXML file.
     */
    public String getPath(){
        return path;
    }
}
