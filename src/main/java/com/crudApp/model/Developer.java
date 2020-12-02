package com.crudApp.model;

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

    public Developer(String name, Set<Skill> skills, Account account) {
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

    public Account getAccount() {
        return account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public void setAccount(Account account) {
        this.account = account;
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
