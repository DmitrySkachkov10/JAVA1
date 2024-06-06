package by.dmitry.messager.controller;

import by.dmitry.messager.core.ValidationException;
import by.dmitry.messager.core.dto.User;
import by.dmitry.messager.core.dto.UserRegistration;
import by.dmitry.messager.service.api.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody UserRegistration userRegistration) {
        try {
            userService.save(userRegistration);
            return new ResponseEntity<>("Регистрация выполнена успешно", HttpStatus.ACCEPTED);
        } catch (ValidationException e) {
            return new ResponseEntity<>("Пользователь не был сохранен в базу", HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/signIn")
    public ResponseEntity<User> signIn(@RequestBody UserRegistration UserRegistration, HttpSession session){
        User user = userService.readUser(UserRegistration);
        if (user != null){
            session.setAttribute("user", user);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

}
