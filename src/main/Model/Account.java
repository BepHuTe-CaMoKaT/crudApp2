package main.Model;

public class Account {
    private long id;
    private String DevName;
    private AccountStatus status;

    public Account(long id, String devName, AccountStatus status) {
        this.id = id;
        DevName = devName;
        this.status = status;
    }

    public Account() {

    }

    public long getId() {
        return id;
    }

    public String getDevName() {
        return DevName;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", DevName='" + DevName + '\'' +
                ", status=" + status +
                '}';
    }
}
