package example.tests;

import example.model.entity.Conversation;
import example.model.entity.Message;
import example.model.entity.User;
import example.utils.XMLManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestXML {
    public static void main(String[] args) {
        List<User> usuarios=new ArrayList<>();
        usuarios.add(new User("Juan","juan@gmail.com","1234"));
        usuarios.add(new User("Pedro","pedro@gmail.com","1234"));
        Conversation prueba=new Conversation("ChatPrueba", LocalDateTime.now());
        prueba.addUser(usuarios.get(0));
        prueba.addUser(usuarios.get(1));
        prueba.addMessage(new Message("Guerola maric",usuarios.get(1),prueba));
        XMLManager.writeXML(prueba, "pruebaConversacion.xml");
        XMLManager.writeXML(usuarios, "usuarios.xml");
    }
}
