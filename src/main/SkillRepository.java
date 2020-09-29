package main;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SkillRepository {
    String path = "C:/Users/Никита/IdeaProjects/crudApp1/src/main/resources/skills.txt";

    public Skill getById(Long id) {
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
            throw new RuntimeException("Error is occurred in readFromFile " + e.getMessage());
        }

    }
    private String readFromFile(String path) {
        try {
            File file = new File(path);
            StringBuilder stringBuilder = new StringBuilder();
            try (FileInputStream in = new FileInputStream(file)) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                }
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in readFromFile" + e.getMessage());
        }
    }
    private void writeToFile(String text, boolean appendOrOverwriteTheFile) {
        try (FileWriter writer = new FileWriter(path, appendOrOverwriteTheFile)) {

            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Skill> getAll() {
        List<Skill> skillList = new ArrayList<>();
        try {
            String[] skillsAllRecords = readFromFile(path).split("/");
            for (String s : skillsAllRecords) {
                String[] skillsRecords = s.split(",");
                skillList.add(new Skill(Long.parseLong(skillsRecords[0]), skillsRecords[1]));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in getAll method" + e.getMessage());
        }
        return skillList;
    }
    private long idGenerator() {

        try {
            String[] skillsAllRecords = readFromFile(path).split("/");
            return skillsAllRecords.length + 1;
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in idGenerator method " + e.getMessage());
        }
    }

    public Skill save(Skill skill) {
        List<Skill> skillList = new ArrayList<>();
        try {
            String[] skillsAllRecords = readFromFile(path).split("/");
            for (String s : skillsAllRecords) {
                String[] skillsRecords = s.split(",");
                skillList.add(new Skill(Long.parseLong(skillsRecords[0]), skillsRecords[1]));
            }
            skillList.add(skill);
            writeToFile(idGenerator() + "," + skill.getName() + "/", true);


        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in save method" + e.getMessage());
        }
        return skill;
    }

    public Skill update(Skill skill) {
        List<Skill> skillList = new ArrayList<>();
        try {
            String[] skillsAllRecords = readFromFile(path).split("/");
            for (String s : skillsAllRecords) {
                String[] skillsRecords = s.split(",");
                skillList.add(new Skill(Long.parseLong(skillsRecords[0]), skillsRecords[1]));
            }


            skillList.removeIf(skill1 -> skill1.getId()==skill.getId());
            skillList.add(skill);
            List<Skill> skillList1 = (skillList.stream().sorted(Comparator.comparingLong(Skill::getId)).collect(Collectors.toList()));




            writeToFile("", false);
            for (Skill o : skillList1) {
                writeToFile(o.getId() + "," + o.getName() + "/\n", true);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in update method " + e.getMessage());
        }
        return skill;
    }
    public void deleteById(Long id) {
        List<Skill> skillList = new ArrayList<Skill>();

        try {
            String[] skillsAllRecords = readFromFile(path).split("/");
            for (String s : skillsAllRecords) {
                String[] skillsRecords = s.split(",");
                skillList.add(new Skill(Long.parseLong(skillsRecords[0]), skillsRecords[1]));
            }
            skillList.removeIf(skill -> skill.getId() == id);

            Skill[] skills = new Skill[skillList.size()];
            skills = skillList.toArray(skills);
            writeToFile("", false);
            for (Skill o : skills) {
                writeToFile(o.getId() + "," + o.getName() + "/\n", true);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in delete method " + e.getMessage());
        }
    }
}
