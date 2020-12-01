package com.crudApp.repository.io;


import com.crudApp.model.Account;
import com.crudApp.model.AccountStatus;
import com.crudApp.repository.AccountRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static com.crudApp.util.IOUtils.*;

public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private String path = "C:/Users/Никита/IdeaProjects/crudApp1/src/main/java/com/crudApp/resources/accounts.txt";

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
    public List<Account> getAll(){
        List<Account> accountList = new ArrayList<>();
        try {
            getAccountCollection(accountList);
        }catch (Exception e) {
            throw new RuntimeException("Error is occurred in getAll method " + e.getMessage());
        }
        return accountList;
    }
    public Account       save(Account account){
        List<Account> accountList = new ArrayList<>();
        try {
            getAccountCollection(accountList);
            accountList.add(account);
            writeToFile(path,idGenerator() + "," + account.getDevName() + "," + account.getStatus() + "/\n",true);
        }catch (Exception e) {
            throw new RuntimeException("Error is occurred in save method" + e.getMessage());
        }
        return account;
    }
    public void          deleteById(Long id){
        List<Account> accountList = new ArrayList<>();

        try {
            getAccountCollection(accountList);
            accountList.removeIf(account -> account.getId() == id);

            writeToFile(path, "", false);
            for (Account a : accountList){
                writeToFile(path, a.getId() + "," + a.getDevName() + "," + a.getStatus() +"/\n",true);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in delete method " + e.getMessage());
        }
    }
    public Account       update(Account account){
        List<Account> accountList = new ArrayList<>();
        try {
            getAccountCollection(accountList);
            accountList.removeIf(account1 -> account1.getId()==account.getId());
            accountList.add(account);
            List<Account> accountList1 = accountList.stream()
                    .sorted(Comparator.comparingLong(Account::getId))
                    .collect(Collectors.toList());

            writeToFile(path,"",false);
            for (Account a:accountList1){
                writeToFile(path,a.getId()+","+a.getDevName()+","+a.getStatus()+"/\n",true);
            }
        }catch (Exception e){
            throw new RuntimeException("Error is occurred in update method " + e.getMessage());
        }
        return account;
    }
    private long         idGenerator() {
        try {
            String[] accountsAllRecords = readFromFile(path).split("/");
            return accountsAllRecords.length + 1;
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in idGenerator method " + e.getMessage());
        }
    }
    private void         getAccountCollection(List<Account> accountList){
        try {
            String[] accountsAllRecords = readFromFile(path).split("/");
            for (String a:accountsAllRecords){
                String[] accountsRecords = a.split(",");
                accountList.add(new Account(Long.parseLong(accountsRecords[0]),accountsRecords[1],AccountStatus.valueOf(accountsRecords[2])));
            }
        }catch (NumberFormatException e){
            throw new RuntimeException("Error is occurred in getAccountCollection " + e.getMessage());
        }
    }
}
