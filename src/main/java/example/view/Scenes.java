package example.view;

public enum Scenes {
    ROOT("root.fxml"),
    MAINMENU("mainMenu.fxml"),
    REGISTER("register.fxml"),
    LOGIN("login.fxml"),
    ;

    private String path;

    Scenes(String path){
        this.path=path;
    }

    public String getPath(){
        return path;
    }
}
