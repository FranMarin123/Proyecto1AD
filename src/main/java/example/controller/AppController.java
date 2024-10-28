package example.controller;

import example.App;
import example.controller.Controller;
import example.view.Scenes;
import example.view.View;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The main application controller responsible for handling scene transitions and initialization
 * of the main UI layout.
 */
public class AppController extends Controller implements Initializable {
    @FXML
    private BorderPane borderPane;

    private Controller centerController;

    /**
     * This method is called upon opening the controller, initializing the main scene.
     *
     * @param input The input data for initializing the controller.
     * @throws IOException If an input or output exception occurs while loading the scene.
     */
    @Override
    public void onOpen(Object input) throws IOException {
        changeScene(Scenes.MAINMENU, null);
    }

    /**
     * This method can change scene
     *
     * @param scene scene to change
     * @param data
     * @throws IOException
     */
    public void changeScene(Scenes scene, Object data) throws IOException {
        View view = loadFXML(scene);
        borderPane.setCenter(view.scene);
        this.centerController = view.controller;
        this.centerController.onOpen(data);
    }

    /**
     * This method load fxml file from scene
     *
     * @param scenes Scene to read
     * @return View object with scene information
     * @throws IOException
     */
    public static View loadFXML(Scenes scenes) throws IOException {
        String url = scenes.getPath();
        FXMLLoader loader = new FXMLLoader(App.class.getResource(url));
        Parent p = loader.load();
        Controller c = loader.getController();
        View view = new View();
        view.scene = p;
        view.controller = c;
        return view;
    }

    /**
     * Called when the controller is closed, providing a point for cleanup if needed.
     *
     * @param output Output data for the controller, unused in this implementation.
     */
    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
