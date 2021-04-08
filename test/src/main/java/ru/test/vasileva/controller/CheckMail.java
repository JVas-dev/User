package ru.test.vasileva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.vasileva.servise.CheckMailService;

@RestController
public class CheckMail {
    @Autowired
    CheckMailService checkMailService;

    @PostMapping("/mail:{mail}")
    public void checkMail(@PathVariable String mail) {
        checkMailService.saveToAudit(mail);
    }
}
