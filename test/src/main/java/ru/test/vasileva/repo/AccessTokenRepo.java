package ru.test.vasileva.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.vasileva.domain.AccessToken;

public interface AccessTokenRepo extends JpaRepository<AccessToken, Integer> {
    AccessToken getByTokenId(int tokenId);
}
