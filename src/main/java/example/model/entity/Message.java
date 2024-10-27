package example.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="message")
public class Message {
    private String content;
    private LocalDateTime messageDate;
    private User transmitter;


    public Message(String content, User transmitter) {
        this.content = content;
        this.messageDate = LocalDateTime.now();
        this.transmitter = transmitter;
    }

    public Message() {
        this("",null);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDateTime messageDate) {
        this.messageDate = messageDate;
    }

    public User getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(User transmitter) {
        this.transmitter = transmitter;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", messageDate=" + messageDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                ", transmitter=" + transmitter +
                '}';
    }
}
