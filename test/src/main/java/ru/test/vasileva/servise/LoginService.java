package ru.test.vasileva.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.vasileva.commons.ActionType;
import ru.test.vasileva.domain.AccessToken;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.repo.UserRepo;

@Service
public class LoginService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuditService auditService;
    @Autowired
    AccessTokenService accessTokenService;

    public AccessToken findUser(User name) {
        User user = userRepo.findByName(name.getName());

        if (user == null) return null;

        if (!user.getPass().equals(name.getPass())) {
            auditService.saveAudit(user, ActionType.LOGINFAIL);
            return null;
        }

        auditService.saveAudit(user, ActionType.LOGINPASS);
        return accessTokenService.saveAccessToken(user);
    }
}
