package main.Repository;

import main.util.IOUtils;
import main.Model.Skill;

import java.util.*;
import java.util.stream.Collectors;

public class SkillRepository extends IOUtils{

    private String path = "C:/Users/Никита/IdeaProjects/crudApp1/src/main/resources/skills.txt";

    public Skill       getById(Long id) {
        try {
            String[] skillsAllRecords = readFromFile(path).split("/");
            for (String s : skillsAllRecords) {
                String[] skillsRecords = s.split(",");
                if (Long.parseLong(skillsRecords[0]) == id) {
                    return new Skill(Long.parseLong(skillsRecords[0]), skillsRecords[1]);
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in getById method " + e.getMessage());
        }
    }
    public List<Skill> getAll() {
        List<Skill> skillList = new ArrayList<>();
        try {
            getSkillCollection(skillList);
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in getAll method " + e.getMessage());
        }
        return skillList;
    }
    public Skill       save(Skill skill) {
        List<Skill> skillList = new ArrayList<>();
        try {
            getSkillCollection(skillList);
            skillList.add(skill);
            writeToFile(path,idGenerator() + "," + skill.getName() + "/", true);


        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in save method" + e.getMessage());
        }
        return skill;
    }
    public Skill       update(Skill skill) {
        List<Skill> skillList = new ArrayList<>();
        try {
            getSkillCollection(skillList);
            skillList.removeIf(skill1 -> skill1.getId() == skill.getId());
            skillList.add(skill);
            List<Skill> skillList1 = (skillList.stream()
                    .sorted(Comparator.comparingLong(Skill::getId))
                    .collect(Collectors.toList()));


            writeToFile(path, "", false);
            for (Skill o : skillList1) {
                writeToFile(path, o.getId() + "," + o.getName() + "/\n", true);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in update method " + e.getMessage());
        }
        return skill;
    }
    public void        deleteById(Long id) {
        List<Skill> skillList = new ArrayList<>();

        try {
            getSkillCollection(skillList);
            skillList.removeIf(skill -> skill.getId() == id);


            writeToFile(path, "", false);
            for (Skill o : skillList) {
                writeToFile(path, o.getId() + "," + o.getName() + "/\n", true);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in delete method " + e.getMessage());
        }
    }
    private long       idGenerator() {
        try {
            String[] skillsAllRecords = readFromFile(path).split("/");
            return skillsAllRecords.length + 1;
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in idGenerator method " + e.getMessage());
        }
    }
    private void       getSkillCollection(List<Skill> skillList) {
        try {
            String[] skillsAllRecords = readFromFile(path).split("/");
            for (String s : skillsAllRecords) {
                String[] skillsRecords = s.split(",");
                skillList.add(new Skill(Long.parseLong(skillsRecords[0]), skillsRecords[1]));
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error is occurred in getSkillCollection method " + e.getMessage());
        }
    }

}
