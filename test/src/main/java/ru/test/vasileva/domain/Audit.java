package ru.test.vasileva.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tAudit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int auditID;
    private int userID;
    private byte actionType;
    private Timestamp actionDate;

    public int getAuditID() {
        return auditID;
    }

    public void setAuditID(int auditID) {
        this.auditID = auditID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public byte getActionType() {
        return actionType;
    }

    public void setActionType(byte actionType) {
        this.actionType = actionType;
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }
}
