package example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import example.App;
import example.controller.Controller;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class SignInController extends Controller implements Initializable {

    @FXML
    private TextField nameText;

    @FXML
    private TextField mailText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField confirmPasswordText;

    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void saveClick() throws IOException {
        App.currentController.changeScene(Scenes.HOME,null);
    }

    public void comeBackClick() throws IOException {
        App.currentController.changeScene(Scenes.MAINMENU,null);
    }
}
