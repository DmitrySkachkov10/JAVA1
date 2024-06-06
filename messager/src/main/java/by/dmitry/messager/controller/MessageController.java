package by.dmitry.messager.controller;

import by.dmitry.messager.core.dto.Message;
import by.dmitry.messager.core.dto.User;
import by.dmitry.messager.core.dto.UserRegistration;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @GetMapping("/get")
    public List<Message> get(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            return user.getSentMessages();
        } else {
            return null;
        }
    }
}
