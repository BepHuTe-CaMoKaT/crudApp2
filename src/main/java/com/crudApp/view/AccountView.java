package com.crudApp.view;

import com.crudApp.controller.AccountController;
import com.crudApp.model.Account;
import com.crudApp.model.AccountStatus;

import java.util.List;
import java.util.Scanner;

public class AccountView {
    private AccountController accountController = new AccountController();
    private static final String start="Press 1 to find account\nPress 2 to get all accounts\nPress 3 to delete account\nPress 4 to create account\nPress 5 to update account";
    private static final String end="Successfully";
    private static final String text1="Enter account's id: ";
    private static final String text2="Enter account's name: ";
    private static final String text4="";

    public void showAccountMenu(){
        System.out.println(start);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice){
            case 1:
                System.out.println(text1);
                long id = in.nextLong();
                System.out.println(accountController.getById(id));
            case 2:
                List<Account> accounts = accountController.getAllAccounts();
                System.out.println(accounts);
                break;
            case 3:
                System.out.println(text1);
                accountController.deleteById(in.nextLong());
                System.out.println(end);
            case 4:
                String accountName = in.next();
                AccountStatus status = null;
                int choice1 = in.nextInt();
                switch (choice1){
                    case 1:
                        status=AccountStatus.ACTIVE;
                        break;
                    case 2:
                        status=AccountStatus.BANNED;
                        break;
                    case 3:
                        status=AccountStatus.DELETED;
                        break;
                    default:
                        throw new IllegalStateException("Unaccepted value: "+choice1);
                }
                Account account = new Account(accountName,status);
                Account savedAccount = accountController.save(account);
                System.out.println("Saved account: "+savedAccount);
            case 5:
                //
            default:
                throw new IllegalStateException("Unaccepted value: "+choice);
        }
    }
}
