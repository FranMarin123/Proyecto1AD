package example.tests;

import example.model.entity.Conversation;
import example.model.entity.Message;
import example.model.entity.User;
import example.utils.Serializator;

public class TestConversation {
    public static void main(String[] args) {
        Conversation conversation=Serializator.deserializeObject("antonioguerola@gmail.comjuan@gmail.com");
        conversation.addMessage(new Message("Ejemplo",new User("Antonio Guerola","antonioguerola@gmail.com","1234")));
        Serializator.serializeObject(conversation,"antonioguerola@gmail.comjuan@gmail.com");
    }
}
