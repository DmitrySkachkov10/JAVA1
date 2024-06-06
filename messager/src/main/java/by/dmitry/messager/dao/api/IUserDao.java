package by.dmitry.messager.dao.api;


import by.dmitry.messager.dao.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;
import java.util.UUID;

public interface IUserDao extends CrudRepository<UserEntity, UUID> {
    Optional<UserEntity> findByLoginAndPassword(String login, String password);
}
