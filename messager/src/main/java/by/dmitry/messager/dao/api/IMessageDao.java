package by.dmitry.messager.dao.api;


import by.dmitry.messager.dao.entity.MessageEntity;
import by.dmitry.messager.dao.entity.UserEntity;
import org.aspectj.bridge.Message;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface IMessageDao extends ListCrudRepository<MessageEntity,  Integer> {
    List<MessageEntity> findByFromUser(UserEntity fromUser);

    List<MessageEntity> findByToUser(UserEntity toUser);
}
