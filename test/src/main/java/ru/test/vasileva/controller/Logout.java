package ru.test.vasileva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.test.vasileva.domain.AccessToken;
import ru.test.vasileva.servise.LogoutService;

@RestController
public class Logout {
    @Autowired
    LogoutService logoutService;

    @PostMapping("/logout")
    public void logout(@RequestHeader AccessToken token) {
        logoutService.saveToAudit(token);
    }
}
