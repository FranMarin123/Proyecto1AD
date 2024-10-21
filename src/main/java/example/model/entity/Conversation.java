package example.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conversation {
    private LocalDateTime init;
    private LocalDateTime end;
    private List<User> participants;
    private List<Message> messages;

    public Conversation(LocalDateTime init, LocalDateTime end) {
        this.init = init;
        this.end = end;
        participants = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public LocalDateTime getInit() {
        return init;
    }

    public void setInit(LocalDateTime init) {
        this.init = init;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
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
        Conversation that = (Conversation) object;
        return Objects.equals(init, that.init) && Objects.equals(end, that.end) && Objects.equals(participants, that.participants) && Objects.equals(messages, that.messages);
    }

    public boolean addUser(User userToAdd) {
        boolean result = false;
        if (!participants.contains(userToAdd)) {
            participants.add(userToAdd);
            result = true;
        }
        return result;
    }

    public boolean removeUser(User userToRemove) {
        boolean result = false;
        if (participants.contains(userToRemove)) {
            participants.remove(userToRemove);
            result = true;
        }
        return result;
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
