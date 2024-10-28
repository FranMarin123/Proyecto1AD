package example.controller;

import example.App;
import example.controller.Controller;
import example.model.entity.Conversation;
import example.model.entity.Message;
import example.model.entity.MessageCollection;
import example.model.singleton.SelectedConversation;
import example.model.singleton.UserSigned;
import example.utils.Serializator;
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

/**
 * Controller class to manage the conversation view, handling message display,
 * message sending, and participant view interactions.
 */
public class ConversationController extends Controller implements Initializable {

    @FXML
    public Label userName=new Label();

    @FXML
    public TextField message;

    @FXML
    public VBox allMessages = new VBox();

    /**
     * Called when the controller is opened, setting up the username and displaying messages.
     *
     * @param input Input data for the controller, unused in this implementation.
     * @throws IOException If an I/O error occurs during initialization.
     */
    @Override
    public void onOpen(Object input) throws IOException {
        userName.setText(detectOtherUsername());
        showMessages();
    }

    /**
     * Detects and retrieves the username of the conversation participant other than the signed-in user.
     *
     * @return The username of the other conversation participant.
     */
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

    /**
     * Sends the message entered in the `message` TextField. If a message is entered,
     * it creates a `Message` object, adds it to the current conversation, and serializes the conversation state.
     */
    public void sendMessage(){
        if (message != null && message.getText() != null){
            Message messageToSave = new Message(message.getText(), UserSigned.getInstance().getCurrentUser());
            SelectedConversation.getInstance().getCurrentConversation().addMessage(messageToSave);
            Serializator.serializeObject(SelectedConversation.getInstance().getCurrentConversation(),
                    SelectedConversation.getInstance().getCurrentFilename());
        }
        showMessages();
    }

    /**
     * Displays all messages in the current conversation, formatting each message depending on the sender.
     * Messages from the signed-in user are aligned to the right, while messages from others are aligned to the left.
     */
    public void showMessages(){
        allMessages.getChildren().clear();
        List<Message> messagesToShow = SelectedConversation.getInstance().getCurrentConversation().getMessages().getMessages();

        for (int i = 0; i < messagesToShow.size(); i++){
            Label labelMessage = new Label(messageFormatter(messagesToShow.get(i)));
            labelMessage.setStyle("-fx-padding: 10; -fx-background-radius: 10; -fx-border-radius: 10;");
            labelMessage.setWrapText(true);
            labelMessage.setMaxWidth(300);
            labelMessage.autosize();
            labelMessage.setMinHeight(75);
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

    /**
     * Formats a message for display, including the sender's name, content, and timestamp.
     *
     * @param messageToFormatter The message to format.
     * @return A formatted string representing the message.
     */
    public String messageFormatter(Message messageToFormatter){
        String messageToReturn = "";
        messageToReturn = messageToFormatter.getTransmitter().getName() + ": " + messageToFormatter.getContent() + "\n" +
                messageToFormatter.getMessageDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return messageToReturn;
    }

    /**
     * Handles the action of viewing the participants in the current conversation.
     *
     * @throws IOException If an error occurs while changing the scene to display participants.
     */
    public void seeParticipantsClick() throws IOException {
        App.currentController.changeScene(Scenes.GROUP_PARTICIPANTS, null);
    }

    /**
     * Handles the action of returning to the home screen from the conversation view.
     *
     * @throws IOException If an error occurs while changing the scene to the home screen.
     */
    public void comeBackClick() throws IOException {
        App.currentController.changeScene(Scenes.HOME, null);
    }
}