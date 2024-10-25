package example;

import example.controller.Controller;
import example.view.Scenes;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController extends Controller implements Initializable {
    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void exitClick(){
        System.exit(0);
    }
}
