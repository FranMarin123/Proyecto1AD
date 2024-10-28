package example.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import example.App;
import example.controller.Controller;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Controller for the Main Menu screen, providing navigation options for
 * registration, login, and exit actions.
 */
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

    /**
     * Handles the action when the user clicks the Register button.
     * Redirects the user to the Sign-In screen.
     *
     * @throws IOException If an error occurs while changing the scene.
     */
    public void registerClick() throws IOException {
        App.currentController.changeScene(Scenes.SIGNIN,null);
    }

    /**
     * Handles the action when the user clicks the Login button.
     * Redirects the user to the Login screen.
     *
     * @throws IOException If an error occurs while changing the scene.
     */
    public void loginClick() throws IOException {
        App.currentController.changeScene(Scenes.LOGIN,null);
    }

    /**
     * Handles the action when the user clicks the Exit button.
     * Terminates the application.
     */
    public void exitClick(){
        System.exit(0);
    }
}
