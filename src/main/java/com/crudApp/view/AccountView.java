package com.crudApp.view;

import com.crudApp.controller.AccountController;
import com.crudApp.model.Account;
import com.crudApp.model.AccountStatus;

import java.util.List;
import java.util.Scanner;

public class AccountView {
    private AccountController accountController = new AccountController();
    private static final String start = "Press 1 to find account\nPress 2 to get all accounts\nPress 3 to delete account\nPress 4 to create account\nPress 5 to update account\nPress 6 to exit";
    private static final String end = "Successfully";
    private static final String text1 = "Enter account's id: ";
    private static final String text2 = "Enter account's name: ";
    private static final String text3 = "Select item: \n1) Change name \n2) Change status \n3) Exit";
    private static final String text4 = "Enter account's status: \n1) Active \n2) Banned \n3) Deleted";

    protected AccountStatus chooseAccountStatus(int choice) {
        AccountStatus status;
        switch (choice) {
            case 1:
                status = AccountStatus.ACTIVE;
                break;
            case 2:
                status = AccountStatus.BANNED;
                break;
            case 3:
                status = AccountStatus.DELETED;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        return status;
    }

    public void showAccountMenu() {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println(start);
            switch (choice = in.nextInt()) {
                case 1:
                    System.out.println(text1);
                    long id = in.nextLong();
                    System.out.println(accountController.getById(id)+"\n");
                    break;
                case 2:
                    List<Account> accounts = accountController.getAllAccounts();
                    System.out.println(accounts+"\n");
                    break;
                case 3:
                    System.out.println(text1);
                    accountController.deleteById(in.nextLong());
                    System.out.println(end+"\n");
                    break;
                case 4:
                    System.out.println(text2);
                    String accountName = in.next();
                    System.out.println(text4);
                    int choice1 = in.nextInt();
                    Account account = new Account(accountName, chooseAccountStatus(choice1));
                    Account savedAccount = accountController.save(account);
                    System.out.println("Saved account: " + savedAccount+"\n");
                    break;
                case 5:
                    System.out.println(text1);
                    Account account1 = accountController.getById(in.nextLong());
                    int choice3;
                    do {
                        System.out.println(text3);
                        switch (choice3=in.nextInt()) {
                            case 1:
                                System.out.println(text2);
                                account1.setDevName(in.next());
                                accountController.update(account1);
                                System.out.println(account1 + " updated\n");
                                break;
                            case 2:
                                System.out.println(text4);
                                int choice2 = in.nextInt();
                                account1.setStatus(chooseAccountStatus(choice2));
                                System.out.println(account1 + " updated\n");
                                break;
                            case 3:
                                break;
                        }
                    }while (choice3!=3);
                case 6:
                    break;
            }

        }while(choice!=6);


    }
}
