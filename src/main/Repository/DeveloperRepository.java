package main.Repository;

import main.util.IOUtils;
import main.Model.Account;
import main.Model.Developer;
import main.Model.Skill;

import java.util.*;
import java.util.stream.Collectors;


public class DeveloperRepository extends IOUtils {
    private String path = "C:/Users/Никита/IdeaProjects/crudApp1/src/main/resources/developers.txt";

    public Developer getById(Long id) {
        Developer result = null;
        SkillRepository skillRepository = new SkillRepository();
        AccountRepository accountRepository = new AccountRepository();
        Set<Skill> skills = new HashSet<>();
        Account account;

        try {
            String[] devAllRecords = readFromFile(path).split("/");
            for (String d : devAllRecords) {
                String[] devRecords = d.split(",");
                if (Long.parseLong(devRecords[0]) == id) {
                    String[] skillsRecord = devRecords[2].split("-");
                    for (String stringSkillId : skillsRecord) {
                        Skill skill = skillRepository.getById(Long.valueOf(stringSkillId));
                        skills.add(skill);
                    }
                    account = accountRepository.getById(Long.valueOf(devRecords[3]));

                    result = new Developer(Long.parseLong(devRecords[0]), devRecords[1], skills, account);

                }
            }
            return result;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error is occurred in readFromFile " + e.getMessage());
        }
    }
    public List<Developer> getAll() {
        List<Developer> developerList = new ArrayList<>();
        try {
            getDevCollection(developerList);
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in getAll method " + e.getMessage());
        }
        return developerList;
    }
    public Developer save(Developer developer) {
        List<Developer> developerList = new ArrayList<>();
        AccountRepository accountRepository = new AccountRepository();
        SkillRepository skillRepository = new SkillRepository();
        Set<Skill> skills = new HashSet<>();
        Account account = new Account();
        try {
            getDevCollection(developerList);
            developerList.add(developer);

            String[] devAllRecords = readFromFile(path).split("/");
            long[] skillsId = new long[developer.getSkills().size()];
            int index=0;
            for (String d : devAllRecords) {
                String[] devRecords = d.split(",");
                    for (Skill skill : developer.getSkills()) {
                        skillsId[index] = skill.getId();
                        index++;
                    }

                    account = accountRepository.getById(Long.parseLong(devRecords[3])+1);

            }


            String sKillsId = Arrays.toString(skillsId);
            writeToFile(path, idGenerator() + "," + developer.getName() + "," + sKillsId + "," + account.getId() + "/", true);
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in save method " + e.getMessage());
        }
        return developer;
    }

    public Developer update(Developer developer) {
        List<Developer> developerList = new ArrayList<>();
        try {
            getDevCollection(developerList);
            developerList.removeIf(developer1 -> developer1.getId() == developer.getId());
            developerList.add(developer);
            List<Developer> developerList1 = (developerList.stream()
                    .sorted(Comparator.comparingLong(Developer::getId))
                    .collect(Collectors.toList()));

            writeToFile(path, "", false);
            for (Developer d : developerList1) {
                writeToFile(path, d.getId() + "," + d.getName() + d.getSkills() + d.getAccount() + "/\n", true);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in update method " + e.getMessage());
        }
        return developer;
    }

    public void deleteById(Long id) {
        List<Developer> developerList = new ArrayList<>();
        try {
            getDevCollection(developerList);
            developerList.removeIf(developer -> developer.getId() == id);

            writeToFile(path, "", false);
            for (Developer d : developerList) {
                writeToFile(path, d.getId() + "," + d.getName() + d.getSkills() + d.getAccount() + "/\n", true);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in delete method " + e.getMessage());
        }
    }

    private long idGenerator() {

        try {
            String[] devAllRecords = readFromFile(path).split("/");
            return devAllRecords.length + 1;
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in idGenerator method " + e.getMessage());
        }
    }

    private void getDevCollection(List<Developer> developerList) {
        Developer result;
        SkillRepository skillRepository = new SkillRepository();
        AccountRepository accountRepository = new AccountRepository();
        Set<Skill> skills = new HashSet<>();
        Account account;

        try {
            String[] devAllRecords = readFromFile(path).split("/");
            for (String d : devAllRecords) {
                String[] devRecords = d.split(",");

                String[] skillsRecord = devRecords[2].split("-");
                for (String stringSkillId : skillsRecord) {
                    Skill skill = skillRepository.getById(Long.valueOf(stringSkillId));
                    skills.add(skill);
                }
                account = accountRepository.getById(Long.valueOf(devRecords[3]));

                result = new Developer(Long.parseLong(devRecords[0]), devRecords[1], skills, account);
                developerList.add(result);
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error is occurred in getDevCollection method " + e.getMessage());
        }
    }


}
