package ru.test.vasileva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.vasileva.domain.AccessToken;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.servise.LoginService;

@RestController
public class Login {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public AccessToken login(User user) {
        return loginService.findUser(user);
    }
}
