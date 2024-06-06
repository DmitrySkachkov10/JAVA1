package by.dmitry.messager.dao.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "messages", schema = "messager")
public class MessageEntity {

    @Id
    private int id;

//    @Column(name = "from_user_id")
//    private UUID fromUserUuid;
//
//    @Column(name = "to_user_id")
//    private UUID toUserUuid;

    private String message;

    @Column(name = "sent_at")
    private LocalDateTime sentTime;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private UserEntity fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private UserEntity toUser;

    public MessageEntity() {
    }

    public MessageEntity(int id, UUID fromUserUuid, UUID toUserUuid, String message, LocalDateTime sentTime) {
        this.id = id;

        this.message = message;
        this.sentTime = sentTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public UserEntity getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserEntity fromUser) {
        this.fromUser = fromUser;
    }

    public UserEntity getToUser() {
        return toUser;
    }

    public void setToUser(UserEntity toUser) {
        this.toUser = toUser;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageEntity that)) return false;
        return id == that.id && Objects.equals(message, that.message) && Objects.equals(sentTime, that.sentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, sentTime);
    }
}
