package ru.test.vasileva.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.vasileva.commons.ActionType;
import ru.test.vasileva.domain.Audit;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.repo.AuditRepo;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class AuditService {
    @Autowired
    AuditRepo auditRepo;

    public void saveAudit(User user, ActionType actionType) {
        Audit audit = new Audit();
        audit.setUserID((user.getUserId()));
        audit.setActionType(actionType.getActionType());
        audit.setActionDate(new Timestamp(new Date().getTime()));

        auditRepo.save(audit);
    }

    public Audit getAudit(User user) {
        return auditRepo.getAuditByActionType(user.getUserId(), ActionType.LOGINPASS.getActionType());
    }

}
