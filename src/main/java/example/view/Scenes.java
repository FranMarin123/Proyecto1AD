package example.view;

public enum Scenes {
    ROOT("root.fxml"),
    MAINMENU("mainMenu.fxml"),
    SIGNIN("signin.fxml"),
    LOGIN("login.fxml"),
    HOME("home.fxml"),
    GROUP_PARTICIPANTS("groupParticipants.fxml"),
    CONVERSATION("conversation.fxml"),
    CREATEGROUP("createGroup.fxml")
    ;

    private String path;

    Scenes(String path){
        this.path=path;
    }

    public String getPath(){
        return path;
    }
}
