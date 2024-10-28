package example.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import example.App;
import example.controller.Controller;
import example.model.entity.User;
import example.model.entity.UserCollection;
import example.model.singleton.UserSigned;
import example.utils.JavaFXUtils;
import example.utils.Serializator;
import example.utils.XMLManager;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Controller for the Login screen, managing user authentication and optional session persistence.
 */
public class LogInController extends Controller implements Initializable {

    @FXML
    public TextField mailText;

    @FXML
    public TextField passwordText;

    @FXML
    public CheckBox cookie;

    /**
     * Initializes the login controller by checking for a saved session ("cookie").
     * If a previous session exists, the user is redirected to the home screen.
     *
     * @param input Input data for initializing the controller, unused in this implementation.
     * @throws IOException If an error occurs during deserialization of the saved session.
     */
    @Override
    public void onOpen(Object input) throws IOException {
        User userSigned = Serializator.deserializeObject("cookie");
        if (userSigned != null) {
            UserSigned.getInstance(userSigned);
            App.currentController.changeScene(Scenes.HOME, null);
        }
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Navigates back to the main menu screen.
     *
     * @throws IOException If an error occurs while changing the scene.
     */
    public void comeBackClick() throws IOException {
        App.currentController.changeScene(Scenes.MAINMENU, null);
    }

    /**
     * Searches for a user in the provided user collection by matching with the given user data.
     *
     * @param allUsers    The collection of all users.
     * @param userToBrowse The user data to search for.
     * @return The matching User object if found, otherwise null.
     */
    public static User browseUserInArray(UserCollection allUsers, User userToBrowse) {
        User userReturn = null;
        for (int i = 0; i < allUsers.getUsers().size(); i++) {
            if (allUsers.getUsers().get(i).equals(userToBrowse)) {
                userReturn = allUsers.getUsers().get(i);
            }
        }
        return userReturn;
    }

    /**
     * Attempts to log the user in by validating the email and password input.
     * If successful, saves the user session if the "Remember Me" option is selected.
     *
     * @return true if login is successful, false otherwise.
     */
    @FXML
    public boolean logIn() {
        boolean result = false;
        if (mailText!=null && mailText.getText()!=null && JavaFXUtils.validateEmail(mailText.getText())) {
            if (passwordText!=null && passwordText.getText()!=null) {
                User userToLogin = new User("", mailText.getText(), passwordText.getText());
                UserCollection allUsers = XMLManager.readXML(new UserCollection(), "usuarios.xml");
                if (allUsers.getUsers().contains(userToLogin)) {
                    userToLogin = browseUserInArray(allUsers, userToLogin);
                    UserSigned.getInstance(userToLogin);

                    if (cookie.isSelected()) {
                        Serializator.serializeObject(userToLogin, "cookie");
                    }

                    result = true;
                } else {
                    JavaFXUtils.showErrorAlert("FAILED TO LOGIN", "There is any user with this mail or the mail or password is incorrect.");
                }
            }else {
                JavaFXUtils.showErrorAlert("ERROR: CONTRASEÑA NO INTRODUCIDA","Introduce una contraseña");
            }
        }else {
            JavaFXUtils.showErrorAlert("ERROR: MAIL NO INTRODUCIDO","El mail no ha sido introducido");
        }
        return result;
    }

    /**
     * Handles the login action. If login is successful, redirects the user to the home screen.
     *
     * @throws IOException If an error occurs while changing the scene.
     */
    public void onActionLogIn() throws IOException {
        if (logIn()) {
            App.currentController.changeScene(Scenes.HOME, null);
        }
    }
}
