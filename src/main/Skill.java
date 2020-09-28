package main;

public class Skill {
    private long id;
    private String name;

    public Skill(long parseLong, String s) {
        this.id=parseLong;
        this.name=s;
    }



    public Skill(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
