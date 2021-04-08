package ru.test.vasileva.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tAccessToken")
public class AccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tokenId;
    private int auditId;
    private int userId;
    private Timestamp expireDate;

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }
}
