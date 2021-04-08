package ru.test.vasileva.commons;

public enum ActionType {
    REGISTARTION(1),
    CHECKMAIL(2),
    LOGINPASS(3),
    LOGOUT(4),
    LOGINFAIL(5);

    int actionType;

    ActionType(int i) {
        this.actionType = i;
    }

    public byte getActionType() {
        return (byte) actionType;
    }
}
