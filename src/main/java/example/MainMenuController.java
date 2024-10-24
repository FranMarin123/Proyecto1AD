package example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import example.controller.Controller;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainMenuController extends Controller implements Initializable {

    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void registerClick() throws IOException {
        App.currentController.changeScene(Scenes.REGISTER,null);
    }

    public void loginClick() throws IOException {
        App.currentController.changeScene(Scenes.LOGIN,null);
    }

    public void exitClick(){
        System.exit(0);
    }
}
