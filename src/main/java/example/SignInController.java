package example;

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
        if (nameText != null && mailText != null && passwordText != null && confirmPasswordText != null) {
            if (passwordText.equals(confirmPasswordText)) {
                User userToRegister=new User(nameText.getText(), mailText.getText(), confirmPasswordText.getText());
                if (!proveIfUserExists(userToRegister)){
                    UserCollection allUsers = XMLManager.readXML(new UserCollection(), "usuarios.xml");
                    allUsers.addUser(userToRegister);
                    XMLManager.writeXML(allUsers,"usuarios.xml");
                    UserSigned.getInstance(userToRegister);
                    App.currentController.changeScene(Scenes.HOME, null);
                }else {
                    JavaFXUtils.showErrorAlert("ERROR: USUARIO REGISTRADO","Los datos " +
                            "introducidos corresponden a un usuario registrado");
                }
            } else {
                JavaFXUtils.showErrorAlert("ERROR: CONTRASEÑA DIFERENTE", "La contraseña no concuerda en ambos campos");
            }
        } else {
            JavaFXUtils.showErrorAlert("ERROR: CAMPO NECESARIO", "Alguno de los campos está incompleto");
        }
    }

    public boolean proveIfUserExists(User userToProve) {
        boolean result = false;
        UserCollection allUsers = XMLManager.readXML(new UserCollection(), "usuarios.xml");
        if (allUsers.getUsers().contains(userToProve)){
            result=true;
        }
        return result;
    }

    public void comeBackClick() throws IOException {
        App.currentController.changeScene(Scenes.MAINMENU, null);
    }
}
