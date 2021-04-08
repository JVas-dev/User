package ru.test.vasileva.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.vasileva.domain.AccessToken;
import ru.test.vasileva.domain.Audit;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.repo.AccessTokenRepo;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class AccessTokenService {
    @Autowired
    AccessTokenRepo accessTokenRepo;
    @Autowired
    AuditService auditService;

    public AccessToken saveAccessToken(User user) {
        Audit audit = auditService.getAudit(user);
        AccessToken accessToken = new AccessToken();
        accessToken.setUserId(user.getUserId());
        accessToken.setAuditId(audit.getAuditID());
        accessToken.setExpireDate(new Timestamp(new Date().getTime() + 1000000));
        accessTokenRepo.save(accessToken);
        return accessToken;
    }

    public void deleteToken(AccessToken token) {
        accessTokenRepo.delete(token);
    }

    public AccessToken getToken(AccessToken token) {
        return accessTokenRepo.getByTokenId(token.getTokenId());
    }
}
