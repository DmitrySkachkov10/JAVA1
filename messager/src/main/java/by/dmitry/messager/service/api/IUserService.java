package by.dmitry.messager.service.api;

import by.dmitry.messager.core.ValidationException;
import by.dmitry.messager.core.dto.User;
import by.dmitry.messager.core.dto.UserRegistration;

import java.sql.SQLException;

public interface IUserService {
    void save(UserRegistration userRegistration) throws ValidationException;

    User readUser(UserRegistration userRegistration);
}
