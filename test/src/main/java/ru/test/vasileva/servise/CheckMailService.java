package ru.test.vasileva.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.test.vasileva.commons.ActionType;
import ru.test.vasileva.domain.User;
import ru.test.vasileva.repo.UserRepo;

@Service
public class CheckMailService {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    AuditService auditService;
    @Autowired
    UserRepo userRepo;
    @Value("${spring.mail.username}")
    String username;

    public void sendPost(User user) {
        String text = "Здравствуйте, " + user.getName() + "!\n" +
                "Для подтверждения регистрации, пожалуйста, перейдите по ссылке http://mail:" + user.getMail();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(user.getMail());
        message.setSubject("Подверждение регистарции");
        message.setText(text);
        emailSender.send(message);
    }

    public void saveToAudit(String mail) {
        User user = userRepo.findByMail(mail);
        auditService.saveAudit(user, ActionType.CHECKMAIL);
    }

}

