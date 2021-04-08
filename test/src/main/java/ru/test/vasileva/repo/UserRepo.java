package ru.test.vasileva.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.vasileva.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByName(String name);

    User findByMail(String mail);

    User findByUserId(int userId);
}
