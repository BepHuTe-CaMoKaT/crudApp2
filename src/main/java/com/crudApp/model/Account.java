package com.crudApp.model;

public class Account {
    private long id;
    private String devName;
    private AccountStatus status;

    public Account(long id, String devName, AccountStatus status) {
        this.id = id;
        this.devName = devName;
        this.status = status;
    }

    public Account(String devName, AccountStatus status) {
        this.devName = devName;
        this.status = status;
    }

    public Account() {

    }

    public long getId() {
        return id;
    }

    public String getDevName() {
        return devName;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", DevName='" + devName + '\'' +
                ", status=" + status +
                '}';
    }
}
