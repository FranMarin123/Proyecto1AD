package example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
