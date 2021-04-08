package ru.test.vasileva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.servise.RegistrationService;

@RestController
public class Registration {
    @Autowired
    RegistrationService registrationService;

    @PostMapping("/registration")
    public String registration(User user) {
        return registrationService.saveUser(user);
    }
}
