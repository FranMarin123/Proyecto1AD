package example.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a message within a conversation, including its content,
 * timestamp, and the user who sent it.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="message")
public class Message implements Serializable {
    private String content;
    private LocalDateTime messageDate;
    private User transmitter;


    /**
     * Constructs a Message with the specified content and transmitter.
     * The message date is set to the current date and time.
     *
     * @param content The text content of the message.
     * @param transmitter The user who sent the message.
     */
    public Message(String content, User transmitter) {
        this.content = content;
        this.messageDate = LocalDateTime.now();
        this.transmitter = transmitter;
    }

    /**
     * Default constructor initializing fields with default values.
     */
    public Message() {
        this("",null);
    }

    /**
     * Gets the content of the message.
     *
     * @return The message content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the message.
     *
     * @param content The new content for the message.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the date and time the message was created.
     *
     * @return The message creation date.
     */
    public LocalDateTime getMessageDate() {
        return messageDate;
    }

    /**
     * Sets the date and time of the message.
     *
     * @param messageDate The new message date.
     */
    public void setMessageDate(LocalDateTime messageDate) {
        this.messageDate = messageDate;
    }

    /**
     * Gets the user who sent the message.
     *
     * @return The transmitting user.
     */
    public User getTransmitter() {
        return transmitter;
    }

    /**
     * Sets the transmitter of the message.
     *
     * @param transmitter The new transmitter user.
     */
    public void setTransmitter(User transmitter) {
        this.transmitter = transmitter;
    }

    /**
     * Returns a string representation of the message, including content,
     * date, and the transmitter's details.
     *
     * @return The string representation of the message.
     */
    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", messageDate=" + messageDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                ", transmitter=" + transmitter +
                '}';
    }
}
