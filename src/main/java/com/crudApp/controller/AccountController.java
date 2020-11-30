package com.crudApp.controller;


import com.crudApp.model.Account;
import com.crudApp.repository.AccountRepository;
import com.crudApp.repository.io.JavaIOAccountRepositoryImpl;

import java.util.List;

public class AccountController {
    private AccountRepository javaIOAccountRepositoryImpl = new JavaIOAccountRepositoryImpl();
    public Account getById(long id){
        return javaIOAccountRepositoryImpl.getById(id);
    }
    public List<Account> getAllAccounts(){
        return javaIOAccountRepositoryImpl.getAll();
    }
    public Account save(Account account){
        return javaIOAccountRepositoryImpl.save(account);
    }
    public void deleteById(Long id){
        javaIOAccountRepositoryImpl.deleteById(id);
    }
    public Account update(Account account){
        return javaIOAccountRepositoryImpl.update(account);
    }
}
