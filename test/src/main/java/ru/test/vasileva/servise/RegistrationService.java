package ru.test.vasileva.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.vasileva.commons.ActionType;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.repo.UserRepo;

@Service
public class RegistrationService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuditService auditService;
    @Autowired
    CheckMailService checkMailService;

    public String saveUser(User user) {
        User userFromDb = userRepo.findByName(user.getName());
        if (userFromDb != null) {
            return "false";
        } else {
            userRepo.save(user);
            auditService.saveAudit(user, ActionType.REGISTARTION);
            if (user.getMail() != null) checkMailService.sendPost(user);
        }
        return "true";
    }

}
