package com.crudApp.view;

import java.util.Scanner;

public class CommonView {
    private AccountView accountView = new AccountView();
    private SkillView skillView = new SkillView();
    private DeveloperView developerView = new DeveloperView();
    private static final String text = "Select item: \n1) Developer menu \n2) Skill menu \n3) Account menu \n4) Exit program";

    public void run() {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println(text);
            switch (choice = in.nextInt()) {
                case 1:
                    developerView.showDeveloperMenu();
                    break;
                case 2:
                    skillView.showSkillMenu();
                    break;
                case 3:
                    accountView.showAccountMenu();
                    break;

            }
        } while (choice != 4);

    }
}
