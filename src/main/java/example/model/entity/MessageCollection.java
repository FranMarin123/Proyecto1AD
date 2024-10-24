package example.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "messages")
public class MessageCollection {

    @XmlElement(name = "message", type = Message.class)
    private List<Message> messages;

    public MessageCollection() {
        this(null);
    }

    public MessageCollection(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MessageCollection that = (MessageCollection) object;
        return Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messages);
    }

    @Override
    public String toString() {
        return "MessageCollection{" +
                "messages=" + messages +
                '}';
    }

    public boolean addMessage(Message messageToAdd) {
        boolean result = false;
        messages.add(messageToAdd);
        result = true;
        return result;
    }

    public boolean removeUser(Message messageToAdd) {
        boolean result = false;
        messages.remove(messageToAdd);
        result = true;
        return result;
    }
}
