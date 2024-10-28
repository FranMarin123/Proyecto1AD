package example;

import example.controller.Controller;
import example.model.singleton.SelectedConversation;
import example.model.singleton.UserSigned;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConversationController extends Controller implements Initializable {

    @FXML
    public Label userName=new Label();

    @Override
    public void onOpen(Object input) throws IOException {
        userName.setText(detectOtherUsername());
    }

    public String detectOtherUsername() {
        String username = null;
        for (int i = 0; i < SelectedConversation.getInstance().getCurrentConversation().getParticipants().getUsers().size(); i++) {
            if (SelectedConversation.getInstance().getCurrentConversation().getParticipants().getUsers().get(i)
                    != UserSigned.getInstance().getCurrentUser()){
                username=SelectedConversation.getInstance().getCurrentConversation().getParticipants().getUsers().get(i).getName();
            }
        }
        return username;
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void seeParticipantsClick() throws IOException {
        App.currentController.changeScene(Scenes.GROUP_PARTICIPANTS, null);
    }

    public void comeBackClick() throws IOException {
        App.currentController.changeScene(Scenes.HOME, null);
    }
}