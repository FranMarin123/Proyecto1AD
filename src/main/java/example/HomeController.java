package example;

import example.controller.Controller;
import example.model.entity.Conversation;
import example.model.entity.User;
import example.model.entity.UserCollection;
import example.model.singleton.SelectedConversation;
import example.model.singleton.UserSigned;
import example.utils.JavaFXUtils;
import example.utils.Serializator;
import example.utils.XMLManager;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class HomeController extends Controller implements Initializable {

    @FXML
    public ComboBox<String> users = new ComboBox<>();

    @Override
    public void onOpen(Object input) throws IOException {
        UserCollection allUsers = XMLManager.readXML(new UserCollection(), "usuarios.xml");
        for (int i = 0; i < allUsers.getUsers().size(); i++) {
            if (!allUsers.getUsers().get(i).getMail().equals(UserSigned.getInstance().getCurrentUser().getMail())) {
                users.getItems().add(allUsers.getUsers().get(i).getMail());
            }
        }
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void selectUserToCreateConversation() throws IOException {
        if (users != null && users.getValue() != null) {
            File conversationFileName1 = new File(UserSigned.getInstance().getCurrentUser().getMail() + users.getValue());
            File conversationFileName2 = new File(users.getValue() + UserSigned.getInstance().getCurrentUser().getMail());
            if (conversationFileName1.exists()) {
                SelectedConversation.getInstance(Serializator.deserializeObject(conversationFileName1.toString()),conversationFileName1.toString());
                App.currentController.changeScene(Scenes.CONVERSATION, null);
            } else if (conversationFileName2.exists()) {
                SelectedConversation.getInstance(Serializator.deserializeObject(conversationFileName2.toString()),conversationFileName1.toString());
                App.currentController.changeScene(Scenes.CONVERSATION, null);
            } else {
                Conversation conversationToSave = new Conversation(conversationFileName1.toString());
                conversationToSave.addUser(UserSigned.getInstance().getCurrentUser());
                conversationToSave.addUser(browseUserInUsersArray(users.getValue()));
                Serializator.serializeObject(conversationToSave,conversationFileName1.toString());
                SelectedConversation.getInstance(conversationToSave,conversationFileName1.toString());
                App.currentController.changeScene(Scenes.CONVERSATION, null);
            }
        } else {
            JavaFXUtils.showErrorAlert("ERROR: USUARIO NO SELECCIONADO", "Por favor, selecciona un usuario para poder " +
                    "acceder a su conversación");
        }
    }

    public static User browseUserInUsersArray(String userToBrowse) {
        User userReturn = null;
        UserCollection allUsers = XMLManager.readXML(new UserCollection(), "usuarios.xml");
        for (int i = 0; i < allUsers.getUsers().size(); i++) {
            if (allUsers.getUsers().get(i).getMail().equals(userToBrowse)) {
                userReturn = allUsers.getUsers().get(i);
            }
        }
        return userReturn;
    }

    public void groupCreateClick() throws IOException {
        App.currentController.changeScene(Scenes.CREATEGROUP, null);
    }

    public void exitClick() {
        File cookie = new File("cookie");
        if (cookie.exists()) {
            cookie.delete();
        }
        System.exit(0);
    }
}
