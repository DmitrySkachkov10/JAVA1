package by.dmitry.messager.core.dto;

import by.dmitry.messager.dao.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {

    private String message;

    private LocalDateTime sentTime;

    private String fromUser;    //login

    private String toUser;  //login

    public Message(String message, LocalDateTime sentTime, String fromUser, String toUser) {
        this.message = message;
        this.sentTime = sentTime;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}
