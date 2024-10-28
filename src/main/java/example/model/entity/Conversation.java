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

/**
 * Represents a conversation between participants, holding a collection of users and messages.
 * This class allows for adding/removing users and messages and supports serialization and XML binding.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="conversation")
public class Conversation implements Serializable {
    private String name;
    private UserCollection participants;
    private MessageCollection messages;

    /**
     * Constructor with all fields initialized.
     *
     * @param name The name of the conversation.
     * @param participants The collection of participants in the conversation.
     * @param messages The collection of messages in the conversation.
     */
    public Conversation(String name, UserCollection participants, MessageCollection messages) {
        this.name = name;
        this.participants = participants;
        this.messages = messages;
    }

    /**
     * Default constructor initializing fields with default values.
     */
    public Conversation() {
        this("", null,null);
    }

    /**
     * Constructor with a specified conversation name.
     * Initializes empty collections for participants and messages.
     *
     * @param name The name of the conversation.
     */
    public Conversation(String name) {
        this.name=name;
        participants = new UserCollection(new ArrayList<>());
        messages = new MessageCollection(new ArrayList<>());
    }


    /**
     * Gets the name of the conversation.
     *
     * @return The conversation name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the conversation.
     *
     * @param name The new name for the conversation.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the participants of the conversation.
     *
     * @return A collection of participants.
     */
    public UserCollection getParticipants() {
        return participants;
    }

    /**
     * Sets the participants of the conversation.
     *
     * @param participants The new collection of participants.
     */
    public void setParticipants(UserCollection participants) {
        this.participants = participants;
    }

    /**
     * Gets the messages in the conversation.
     *
     * @return A collection of messages.
     */
    public MessageCollection getMessages() {
        return messages;
    }

    /**
     * Sets the messages in the conversation.
     *
     * @param messages The new collection of messages.
     */
    public void setMessages(MessageCollection messages) {
        this.messages = messages;
    }

    /**
     * Checks if this conversation is equal to another object, comparing name, participants, and messages.
     *
     * @param object The object to compare with.
     * @return true if they are equal; false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Conversation that = (Conversation) object;
        return Objects.equals(name, that.name) && Objects.equals(participants, that.participants) && Objects.equals(messages, that.messages);
    }


    /**
     * Generates a hash code based on name, participants, and messages.
     *
     * @return A hash code for the conversation.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, participants, messages);
    }

    /**
     * Adds a user to the conversation.
     *
     * @param userToAdd The user to add.
     * @return true if the user was successfully added; false otherwise.
     */
    public boolean addUser(User userToAdd) {
        return participants.addUser(userToAdd);
    }

    /**
     * Removes a user from the conversation.
     *
     * @param userToRemove The user to remove.
     * @return true if the user was successfully removed; false otherwise.
     */
    public boolean removeUser(User userToRemove) {
        return participants.removeUser(userToRemove);
    }

    /**
     * Adds a message to the conversation.
     *
     * @param messageToAdd The message to add.
     * @return true if the message was successfully added; false otherwise.
     */
    public boolean addMessage(Message messageToAdd) {
        return messages.addMessage(messageToAdd);
    }

    /**
     * Removes a message from the conversation.
     *
     * @param messageToAdd The message to remove.
     * @return true if the message was successfully removed; false otherwise.
     */
    public boolean removeUser(Message messageToAdd) {
        return messages.removeUser(messageToAdd);
    }

    /**
     * Returns a string representation of the conversation, including name, participants, and messages.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return "Conversation{" +
                "name='" + name + '\'' +
                ", participants=" + participants +
                ", messages=" + messages +
                '}';
    }
}
