    package com.crudApp.model;

public class Skill {
    private Long id;
    private String name;

    public Skill(Long parseLong, String s) {
        this.id=parseLong;
        this.name=s;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Skill(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
