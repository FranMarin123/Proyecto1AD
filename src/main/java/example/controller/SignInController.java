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
import example.utils.XMLManager;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * Controller for the Sign-In screen, handling the registration process for new users.
 */
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

    /**
     * Handles the save button click event to register a new user.
     * Validates input fields, checks for email format, and verifies that passwords match.
     * If successful, registers the user and navigates to the home screen. Displays error alerts
     * for invalid inputs or if the user already exists.
     *
     * @throws IOException If an error occurs while saving data or changing the scene.
     */
    public void saveClick() throws IOException {
        if (nameText != null && mailText != null && passwordText != null && confirmPasswordText != null) {
            if (JavaFXUtils.validateEmail(mailText.getText())) {
                if (passwordText.getText().equals(confirmPasswordText.getText())) {
                    User userToRegister = new User(nameText.getText(), mailText.getText(), confirmPasswordText.getText());
                    if (!proveIfUserExists(userToRegister)) {
                        UserCollection allUsers = XMLManager.readXML(new UserCollection(), "usuarios.xml");
                        allUsers.addUser(userToRegister);
                        XMLManager.writeXML(allUsers, "usuarios.xml");
                        UserSigned.getInstance(userToRegister);
                        App.currentController.changeScene(Scenes.HOME, null);
                    } else {
                        JavaFXUtils.showErrorAlert("ERROR: USUARIO REGISTRADO", "Los datos " +
                                "introducidos corresponden a un usuario registrado");
                    }
                } else {
                    JavaFXUtils.showErrorAlert("ERROR: CONTRASEÑA DIFERENTE", "La contraseña no concuerda en ambos campos");
                }
            }else {
                JavaFXUtils.showErrorAlert("ERROR: CORREO NO VALIDO","Introduce un correo valido");
            }
        } else {
            JavaFXUtils.showErrorAlert("ERROR: CAMPO NECESARIO", "Alguno de los campos está incompleto");
        }
    }

    /**
     * Checks if a user already exists in the user collection based on the provided user data.
     *
     * @param userToProve The user object to check for existence.
     * @return true if the user already exists, false otherwise.
     */
    public boolean proveIfUserExists(User userToProve) {
        boolean result = false;
        UserCollection allUsers = XMLManager.readXML(new UserCollection(), "usuarios.xml");
        if (allUsers.getUsers().contains(userToProve)){
            result=true;
        }
        return result;
    }

    /**
     * Handles the action for the back button, navigating back to the main menu.
     *
     * @throws IOException If an error occurs while changing the scene.
     */
    public void comeBackClick() throws IOException {
        App.currentController.changeScene(Scenes.MAINMENU, null);
    }
}
