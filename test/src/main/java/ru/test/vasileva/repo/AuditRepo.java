package ru.test.vasileva.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.test.vasileva.domain.Audit;

public interface AuditRepo extends JpaRepository<Audit, Integer> {
    @Query(value = "select * from t_audit where userid = ?1 and action_type = ?2 order by action_date desc fetch first 1 rows only", nativeQuery = true)
    Audit getAuditByActionType(int userId, byte actionType);
}
