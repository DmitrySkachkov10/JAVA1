package by.dmitry.messager.core.dto;

import by.dmitry.messager.dao.entity.MessageEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {
    private String login;
    private String password;
    private LocalDate brDate;

    private String fullName;

    private UUID id; //todo насколько нормально его сюда выводить?

    private String role;

    private LocalDate registrationDate;

    private List<Message> receivedMessages;

    private List<Message> sentMessages;

    public User() {
    }

    public User(String login, String password, LocalDate brDate, String fullName, UUID id, String role, LocalDate registrationDate, List<Message> receivedMessages, List<Message> sentMessages) {
        this.login = login;
        this.password = password;
        this.brDate = brDate;
        this.fullName = fullName;
        this.id = id;
        this.role = role;
        this.registrationDate = registrationDate;
        this.receivedMessages = receivedMessages;
        this.sentMessages = sentMessages;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public LocalDate getBrDate() {
        return brDate;
    }

    public void setBrDate(LocalDate brDate) {
        this.brDate = brDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(brDate, user.brDate) && Objects.equals(fullName, user.fullName) && Objects.equals(id, user.id) && Objects.equals(role, user.role) && Objects.equals(registrationDate, user.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, brDate, fullName, id, role, registrationDate);
    }
}

