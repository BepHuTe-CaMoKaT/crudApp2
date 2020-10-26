package main.Repository;

import main.util.IOUtils;
import main.Model.Account;
import main.Model.AccountStatus;

public class AccountRepository extends IOUtils {

    private String path = "C:/Users/Никита/IdeaProjects/crudApp1/src/main/resources/accounts.txt";

    public Account getById(Long id) {
        try {
            String[] accountAllRecords = readFromFile(path).split("/");
            for (String s : accountAllRecords) {
                String[] accountRecords = s.split(",");
                if (Long.parseLong(accountRecords[0]) == id) {
                    return new Account(Long.parseLong(accountRecords[0]), accountRecords[1], AccountStatus.valueOf(accountRecords[2]));
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in getById method " + e.getMessage());
        }
    }
}
