package example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import example.App;
import example.controller.Controller;
import example.view.Scenes;
import javafx.fxml.Initializable;

public class LogInController extends Controller implements Initializable {

    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void comeBackClick() throws IOException {
        App.currentController.changeScene(Scenes.MAINMENU,null);
    }
}
