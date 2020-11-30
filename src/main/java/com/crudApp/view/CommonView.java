package com.crudApp.view;

import java.util.Scanner;

public class CommonView {
    private AccountView accountView = new AccountView();
    private SkillView skillView = new SkillView();
    private DeveloperView developerView = new DeveloperView();

    public void run(){
        System.out.println("Select item: ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice){
            case 1:
                developerView.showDeveloperMenu();
            case 2:
                skillView.showSkillMenu();
            case 3:
                accountView.showAccountMenu();

        }
    }
}
