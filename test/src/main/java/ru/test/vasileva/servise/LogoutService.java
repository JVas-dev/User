package ru.test.vasileva.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.vasileva.commons.ActionType;
import ru.test.vasileva.domain.AccessToken;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.repo.UserRepo;

@Service
public class LogoutService {

    @Autowired
    AuditService auditService;
    @Autowired
    UserRepo userRepo;
    @Autowired
    AccessTokenService accessTokenService;

    public void saveToAudit(AccessToken token) {

        accessTokenService.getToken(token);
        User user = userRepo.findByUserId(token.getUserId());
        auditService.saveAudit(user, ActionType.LOGOUT);
        accessTokenService.deleteToken(token);
    }
}
