package by.dmitry.messager.dao.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "users", schema = "messager")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String login;

    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birthday")
    private LocalDate birthDate;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "role")
    private String role;


    @OneToMany(mappedBy = "fromUser")
    private List<MessageEntity> sentMessages;

    @OneToMany(mappedBy = "toUser")
    private List<MessageEntity> receivedMessages;

    public UserEntity() {
    }

    public UserEntity(String login, String password, String fullName, LocalDate birthDate, LocalDate registrationDate, String role) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.role = role;
    }

    public List<MessageEntity> getSentMessages() {
        return sentMessages;
    }

    public List<MessageEntity> getReceivedMessages() {
        return receivedMessages;
    }

    public void setSentMessages(List<MessageEntity> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public void setReceivedMessages(List<MessageEntity> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity that)) return false;
        return Objects.equals(id, that.id)
                && Objects.equals(login, that.login)
                && Objects.equals(fullName, that.fullName)
                && Objects.equals(birthDate, that.birthDate)
                && Objects.equals(registrationDate, that.registrationDate)
                && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, fullName, birthDate, registrationDate, role);
    }
}
