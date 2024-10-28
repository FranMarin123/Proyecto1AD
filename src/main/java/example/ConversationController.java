package example;

import example.controller.Controller;
import example.model.entity.Message;
import example.model.entity.MessageCollection;
import example.model.singleton.SelectedConversation;
import example.model.singleton.UserSigned;
import example.view.Scenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class ConversationController extends Controller implements Initializable {

    @FXML
    public Label userName=new Label();

    @FXML
    public TextField message;

    @FXML
    public VBox allMessages = new VBox();

    @Override
    public void onOpen(Object input) throws IOException {
        userName.setText(detectOtherUsername());
        System.out.println(SelectedConversation.getInstance().getCurrentConversation());
        showMessages();
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

    public void sendMessage(){
        if (message != null && message.getText() != null){
            Message messageToSave = new Message(message.getText(), UserSigned.getInstance().getCurrentUser());
            SelectedConversation.getInstance().getCurrentConversation().addMessage(messageToSave);
        }
        showMessages();
    }

    public void showMessages(){
        allMessages.getChildren().clear();
        List<Message> messagesToShow = SelectedConversation.getInstance().getCurrentConversation().getMessages().getMessages();

        for (int i = 0; i < messagesToShow.size(); i++){
            Label labelMessage = new Label(messageFormatter(messagesToShow.get(i)));
            labelMessage.setStyle("-fx-padding: 10; -fx-background-radius: 10; -fx-border-radius: 10;");
            labelMessage.setWrapText(true);
            labelMessage.setMaxWidth(300);
            HBox hbox = new HBox();
            hbox.setPadding(new Insets(5));

            if (messagesToShow.get(i).getTransmitter().equals(UserSigned.getInstance().getCurrentUser())){
                labelMessage.setStyle("-fx-text-fill: white; -fx-background-color: #2d87f0; -fx-padding: 10; -fx-background-radius: 10; -fx-border-radius: 10;");
                hbox.setAlignment(Pos.BOTTOM_RIGHT);
                hbox.getChildren().add(labelMessage);
            } else {
                labelMessage.setStyle("-fx-text-fill: white; -fx-background-color: #777; -fx-padding: 10; -fx-background-radius: 10; -fx-border-radius: 10;");
                hbox.setAlignment(Pos.BOTTOM_LEFT);
                hbox.getChildren().add(labelMessage);
            }
            allMessages.getChildren().add(hbox);
        }
    }

    public String messageFormatter(Message messageToFormatter){
        String messageToReturn = "";
        messageToReturn = messageToFormatter.getTransmitter().getName() + ": " + messageToFormatter.getContent() + "\n" +
                messageToFormatter.getMessageDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return messageToReturn;
    }

    public void seeParticipantsClick() throws IOException {
        App.currentController.changeScene(Scenes.GROUP_PARTICIPANTS, null);
    }

    public void comeBackClick() throws IOException {
        App.currentController.changeScene(Scenes.HOME, null);
    }
}