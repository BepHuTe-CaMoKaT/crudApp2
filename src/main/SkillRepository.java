package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository {
    String path = "C:/Users/Никита/IdeaProjects/crudApp/src/main/resources/skills.txt";

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
            throw new RuntimeException("Error is occurred in readFromFile" + e.getMessage());
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
    }// буфер не закрывается(вроде)

    private String writeToFile(String text, boolean appendOrOverwriteTheFile) {
        try (FileWriter writer = new FileWriter(path, appendOrOverwriteTheFile)) {

            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public long idGenerator() {
        return 0;
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

            for (String s : skillsAllRecords) {
                String[] skillsRecords = s.split(",");
                if (Long.parseLong(skillsRecords[0])==skill.getId()) {
                    skillsRecords[1] = skill.getName();
                }

            }

        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in save method" + e.getMessage());
        }
        return null;
    }

    public boolean deleteById(Long id) {
        List<Skill> skillList = new ArrayList<>();

        try {
            String[] skillsAllRecords = readFromFile(path).split("/");
            for (String s : skillsAllRecords) {
                String[] skillsRecords = s.split(",");
                skillList.add(new Skill(Long.parseLong(skillsRecords[0]), skillsRecords[1]));
            }
            skillList.removeIf(skill -> skill.getId() == id);

            Skill[] skills = (Skill[]) skillList.toArray();
            for(Skill o:skills){
                writeToFile(o.getId()+o.getName(),false);

            }

        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in delete method" + e.getMessage());
        }
        return false;
    }
}
