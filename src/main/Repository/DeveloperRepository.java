package main.Repository;

import main.IOUtils;
import main.Model.Account;
import main.Model.AccountStatus;
import main.Model.Developer;
import main.Model.Skill;

import java.util.HashSet;
import java.util.Set;


public class DeveloperRepository extends IOUtils {
    private String path = "C:/Users/Никита/IdeaProjects/crudApp1/src/main/resources/developers.txt";

    public Developer getById(Long id) {
        SkillRepository skillRepository = new SkillRepository();
        AccountRepository accountRepository = new AccountRepository();
        Set<Skill> skills = new HashSet<>();
        Account account = new Account();

        try {
            String[] devAllRecords = readFromFile(path).split("/");
            for (String d : devAllRecords) {
                String[] devRecords = d.split(",");
                if (Long.parseLong(devRecords[0]) == id) {
                    for (char ch : devRecords[2].toCharArray()) {

                        if (Character.isDigit(ch)) {
                            Skill skill = skillRepository.getById((long) ch);
                            skills.add(skill);

                            for (char ch1:devRecords[3].toCharArray()){
                                if (Character.isDigit(ch1)){
                                    account = accountRepository.getById((long)ch1);


                                }
                            }

                            return new Developer(Long.parseLong(devRecords[0]), devRecords[1], skills, account);
                        }
                    }
                }
            }
            return null;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error is occurred in readFromFile " + e.getMessage());
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


}
