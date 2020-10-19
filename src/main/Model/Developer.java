package main.Model;

import java.util.Set;

public class Developer {
    private long id;
    private String name;
    private Set<Skill> skills;
    private Account account;

    public Developer(long id, String name, Set<Skill> skills, Account account) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.account = account;
    }

    public Developer() {

    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public AccountStatus getAccount() {
        return account.getStatus();
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skills=" + skills +
                ", account=" + account +
                '}';
    }
}
