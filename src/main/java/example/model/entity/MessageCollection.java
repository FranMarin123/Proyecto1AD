package example.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Represents a collection of messages within a conversation.
 * Provides methods to manage and manipulate a list of messages.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "messageCollection")
public class MessageCollection implements Serializable {

    @XmlElement(name = "message", type = Message.class)
    private List<Message> messages;

    /**
     * Default constructor initializing an empty MessageCollection.
     */
    public MessageCollection() {

    }

    /**
     * Constructs a MessageCollection with the specified list of messages.
     *
     * @param messages The list of messages to initialize in this collection.
     */
    public MessageCollection(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Retrieves the list of messages in this collection.
     *
     * @return The list of messages.
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Sets the list of messages in this collection.
     *
     * @param messages The new list of messages.
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


    /**
     * Compares this MessageCollection to another object for equality.
     *
     * @param object The object to compare with.
     * @return {@code true} if the object is equal to this collection.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MessageCollection that = (MessageCollection) object;
        return Objects.equals(messages, that.messages);
    }

    /**
     * Computes a hash code for the collection.
     *
     * @return The hash code of the collection.
     */
    @Override
    public int hashCode() {
        return Objects.hash(messages);
    }

    /**
     * Returns a string representation of the MessageCollection, including its messages.
     *
     * @return The string representation of the MessageCollection.
     */
    @Override
    public String toString() {
        return "MessageCollection{" +
                "messages=" + messages +
                '}';
    }

    /**
     * Adds a message to the collection.
     *
     * @param messageToAdd The message to add.
     * @return {@code true} if the message was added successfully.
     */
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
