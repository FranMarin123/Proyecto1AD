package example.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name="message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
    private String content;
    private LocalDateTime messageDate;
    private User transmitter;
    private Conversation conversation;

    public Message(String content, User transmitter, Conversation conversation) {
        this.content = content;
        this.messageDate = LocalDateTime.now();
        this.transmitter = transmitter;
        this.conversation = conversation;
    }

    public Message() {
        this("",null,null);
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

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

}
