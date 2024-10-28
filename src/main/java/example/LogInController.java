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
import example.utils.Serializator;
import example.utils.XMLManager;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class LogInController extends Controller implements Initializable {

    @FXML
    public TextField mailText;

    @FXML
    public TextField passwordText;

    @FXML
    public CheckBox cookie;

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

    public void comeBackClick() throws IOException {
        App.currentController.changeScene(Scenes.MAINMENU, null);
    }

    public static User browseUserInArray(UserCollection allUsers, User userToBrowse) {
        User userReturn = null;
        for (int i = 0; i < allUsers.getUsers().size(); i++) {
            if (allUsers.getUsers().get(i).equals(userToBrowse)) {
                userReturn = allUsers.getUsers().get(i);
            }
        }
        return userReturn;
    }

    @FXML
    public boolean logIn() {
        boolean result = false;
        if (mailText!=null && mailText.getText()!=null) {
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

    public void onActionLogIn() throws IOException {
        if (logIn()) {
            App.currentController.changeScene(Scenes.HOME, null);
        }
    }
}
