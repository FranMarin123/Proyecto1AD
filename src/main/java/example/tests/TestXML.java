package example.tests;

import example.model.entity.Conversation;
import example.model.entity.Message;
import example.model.entity.User;
import example.model.entity.UserCollection;
import example.utils.XMLManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestXML {
    public static void main(String[] args) {
        List<User> usuarios=new ArrayList<>();
        UserCollection userCollection=new UserCollection(usuarios);
        userCollection.addUser(new User("Juan","juan@gmail.com","1234"));
        userCollection.addUser(new User("Pedro","pedro@gmail.com","1234"));
        Conversation prueba=new Conversation("ChatPrueba");
        prueba.setParticipants(userCollection);
        prueba.addMessage(new Message("Prueba de mensaje",userCollection.getUsers().get(1)));
        XMLManager.writeXML(prueba, "pruebaConversacion.xml");
        XMLManager.writeXML(userCollection, "usuarios.xml");
    }
}
