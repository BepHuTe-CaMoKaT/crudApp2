package main.Controller;

import main.Model.Account;
import main.Repository.AccountRepository;

public class AccountController {
    private AccountRepository accountRepository = new AccountRepository();
    public Account getById(long id){
        return accountRepository.getById(id);
    }
    public void getAllAccounts(){
        System.out.println(accountRepository.getAll());
    }
    public Account save(Account account){
        return accountRepository.save(account);
    }
    public void deleteById(long id){
        accountRepository.deleteById(id);
    }
    public Account update(Account account){
        return accountRepository.update(account);
    }
}
