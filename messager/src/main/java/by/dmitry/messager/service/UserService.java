package by.dmitry.messager.service;

import org.springframework.dao.DataAccessException;
import by.dmitry.messager.core.ValidationException;
import by.dmitry.messager.core.dto.Message;
import by.dmitry.messager.core.dto.User;
import by.dmitry.messager.core.dto.UserRegistration;
import by.dmitry.messager.dao.entity.MessageEntity;
import by.dmitry.messager.dao.entity.UserEntity;
import by.dmitry.messager.dao.api.IUserDao;
import by.dmitry.messager.service.api.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(UserRegistration userRegistration) throws ValidationException {
        loginValidation(userRegistration.getLogin());
        passwordValidation(userRegistration.getPassword());
        fioValidation(userRegistration.getFio());
        LocalDate localDate = LocalDate.now();

        try {
            userDao.save(new UserEntity(userRegistration.getLogin(), userRegistration.getPassword(), userRegistration.getFio(), userRegistration.getBrDate(), localDate, "user"));
        } catch (Exception e){
            throw new IllegalArgumentException("Пользователь с таким логином уже существует", e);
        }
    }

    @Override
    public User readUser(UserRegistration userRegistration) {
        Optional<UserEntity> userEntityOpt = userDao.findByLoginAndPassword(userRegistration.getLogin(), userRegistration.getPassword());


        if (userEntityOpt.isPresent()) {
            UserEntity userEntity = userEntityOpt.get();

            List<Message> receivedMessage = userEntity.getReceivedMessages()
                    .stream()
                    .map(m -> mapper(m))
                    .toList();

            List<Message> sentMessages = userEntity.getSentMessages()
                    .stream()
                    .map(m -> mapper(m))
                    .toList();

            User user = new User(userEntity.getLogin(),
                    userEntity.getPassword(),
                    userEntity.getBirthDate(),
                    userEntity.getFullName(),
                    userEntity.getId(),
                    userEntity.getRole(),
                    userEntity.getRegistrationDate(),
                    receivedMessage,
                    sentMessages);
            return user;

        } else {
            throw new IllegalArgumentException("Неверно ввели данные");
        }
    }


    private void passwordValidation(String password) throws ValidationException {
        if (password.length() < 8 || password.length() > 32) {
            throw new ValidationException("Длина пароля должна составлять от 8 до 32 символов");
        }
        if (!password.matches("[a-zA-Z0-9_-]{8,32}")) {
            throw new ValidationException("Пароль может содержать латинские буквы, цифры 0-9, а также символы '_' и '-'");
        }
    }

    private void loginValidation(String login) throws ValidationException {
        if (login.length() < 8 || login.length() > 16) {
            throw new ValidationException("Длина логина должна составлять от 8 до 16 символов");
        }
        if (!login.matches("[a-zA-Z0-9_-]{4,16}")) {
            throw new ValidationException("Логин может содержать латинские буквы, цифры 0-9, а также символы '_' и '-'");
        }
    }

    private void fioValidation(String fio) throws ValidationException {
        if (!fio.matches("[A-Za-zа-яА-я]+ [A-Za-zа-яА-я]+ [A-Za-zа-яА-я]+$")) {
            throw new ValidationException("Неверный формат ФИО. ФИО должно состоять из букв и пробелов");
        }
    }

    private void brDayValidation(Date brDay) throws ValidationException {
        Date currentDate = new Date();

        if (brDay == null) {
            throw new ValidationException("Не указана дата дня рождения");
        }
        if (brDay.after(currentDate)) {
            throw new ValidationException("Дата дня рождения не может быть в будущем времени");
        }
    }

    private Message mapper(MessageEntity messageEntity) {
        Message message = new Message();
        message.setToUser(messageEntity.getToUser().getLogin());
        message.setFromUser(messageEntity.getFromUser().getLogin());
        message.setMessage(messageEntity.getMessage());
        message.setSentTime(messageEntity.getSentTime());
        return message;
    }
}
