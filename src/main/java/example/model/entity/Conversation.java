package example.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="conversation")
public class Conversation implements Serializable {
    private String name;
    private UserCollection participants;
    private MessageCollection messages;

    public Conversation(String name, UserCollection participants, MessageCollection messages) {
        this.name = name;
        this.participants = participants;
        this.messages = messages;
    }

    public Conversation() {
        this("", null,null);
    }

    public Conversation(String name) {
        this.name=name;
        participants = new UserCollection(new ArrayList<>());
        messages = new MessageCollection(new ArrayList<>());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserCollection getParticipants() {
        return participants;
    }

    public void setParticipants(UserCollection participants) {
        this.participants = participants;
    }

    public MessageCollection getMessages() {
        return messages;
    }

    public void setMessages(MessageCollection messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Conversation that = (Conversation) object;
        return Objects.equals(name, that.name) && Objects.equals(participants, that.participants) && Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, participants, messages);
    }

    public boolean addUser(User userToAdd) {
        return participants.addUser(userToAdd);
    }

    public boolean removeUser(User userToRemove) {
        return participants.removeUser(userToRemove);
    }

    public boolean addMessage(Message messageToAdd) {
        return messages.addMessage(messageToAdd);
    }

    public boolean removeUser(Message messageToAdd) {
        return messages.removeUser(messageToAdd);
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "name='" + name + '\'' +
                ", participants=" + participants +
                ", messages=" + messages +
                '}';
    }
}
