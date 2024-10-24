package example.view;

public enum Scenes {
    ROOT("root.fxml"),
    MAINMENU("mainMenu.fxml");

    private String path;

    Scenes(String path){
        this.path=path;
    }

    public String getPath(){
        return path;
    }
}
