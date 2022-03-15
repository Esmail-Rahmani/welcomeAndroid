package model;

public class HardSkills {
    String name;
    int id;
    SubSkill subSkills[];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubSkill[] getSubSkills() {
        return subSkills;
    }

    public void setSubSkills(SubSkill[] subSkills) {
        this.subSkills = subSkills;
    }

    public HardSkills() {
    }

    public HardSkills(String name, int id, SubSkill[] subSkills) {
        this.name = name;
        this.id = id;
        this.subSkills = subSkills;
    }
}

