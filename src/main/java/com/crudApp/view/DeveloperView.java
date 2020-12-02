package com.crudApp.view;



import com.crudApp.controller.AccountController;
import com.crudApp.controller.DeveloperController;
import com.crudApp.controller.SkillController;
import com.crudApp.model.Account;
import com.crudApp.model.AccountStatus;
import com.crudApp.model.Developer;
import com.crudApp.model.Skill;
import com.crudApp.util.IOUtils;

import java.util.*;
import java.util.stream.Collectors;

public class DeveloperView extends IOUtils {
    private DeveloperController developerController = new DeveloperController();
    private static final String start="Press 1 to find developer\nPress 2 to get all developers\nPress 3 to delete developer\nPress 4 to create developer\nPress 5 to update developer\nPress 6 to exit";
    private static final String end="Successfully\n";
    private static final String text1="Enter developer's id: ";
    private static final String text2="Enter developer's name: ";
    private static final String text3="Enter developer's skills: \n1,pascal/\n2,maven/\n3,sql/\n4,python/\n5,go/\n0,Continue";
    private static final String text4="Now we need to create an account, please, enter account's name: ";
    private static final String text5="Enter account's status: \n1) Active \n2) Banned \n3) Deleted";
    private static final String text6 = "Select item: \n1) Change name \n2) Change skills \n3) Change account name/status \n4) Exit";
    private static final String text7 = "Select item: \n1) Add skill \n2) Delete skill \n3) Exit";



    public void showDeveloperMenu(){
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println(start);
            switch (choice = in.nextInt()){
                case 1:
                    System.out.println(text1);
                    long id = in.nextLong();
                    System.out.println(developerController.getById(id)+"\n");
                    break;
                case 2:
                    List<Developer> developers = developerController.getAllDevelopers();
                    System.out.println(developers+"\n");
                    break;
                case 3:
                    System.out.println(text1);
                    developerController.deleteById(in.nextLong());
                    System.out.println(end);
                    break;
                case 4:
                    System.out.println(text2);
                    String devName = in.next();
                    Set<Skill> skills = new HashSet<>();
                    SkillController skillController = new SkillController();
                    long choice1;
                    System.out.println(text3);
                    do {
                        choice1=in.nextInt();
                        if (choice1!=0)skills.add(skillController.getById(choice1));
                    }while (choice1!=0);
                    System.out.println(text4);
                    String accountName = in.next();
                    AccountView accountView = new AccountView();
                    AccountController accountController = new AccountController();
                    System.out.println(text5);
                    int choice2=in.nextInt();
                    Account account = new Account(accountName,accountView.chooseAccountStatus(choice2));
                    Account savedAccount = accountController.save(account);                                     //ID=0/ERROR
                    Developer dev = new Developer(devName,skills,account);
                    Developer savedDev = developerController.save(dev);
                    System.out.println("Saved developer: "+savedDev+"\n");
                    break;
                case 5:
                    //update name, skills, account
                    System.out.println(text1);
                    Developer developer = developerController.getById(in.nextLong());
                    int choice3;
                    do {
                        System.out.println(text6);
                        switch (choice3=in.nextInt()){
                            case 1://update name
                                System.out.println(text2);
                                developer.setName(in.next());
                                developerController.update(developer);
                                System.out.println(developer+" updated\n");
                                break;
                            case 2://update skills
                                int choice4;
                                do {
                                    System.out.println(text7);
                                    skillController = new SkillController();
                                    switch (choice4=in.nextInt()){
                                        case 1://add skill
                                            Set<Skill> skills1 = developer.getSkills();
                                            System.out.println(text3);
                                            do {
                                                choice1=in.nextInt();
                                                if (choice1!=0)skills1.add(skillController.getById(choice1));
                                            }while (choice1!=0);
//                                            Set<Skill> skills2 = skills1.stream().sorted(Comparator.comparingLong(Skill::getId)).collect(Collectors.toCollection(LinkedHashSet::new));
//                                            developer.setSkills(skills2);                                 SORTING/ERROR
                                            developerController.update(developer);
                                            System.out.println(skills1+" updated\n");
                                            break;
                                        case 2://delete skill
                                            skills1 = developer.getSkills();
                                            System.out.println("Enter skill's id: ");
                                            skills1.removeIf(skill -> skill.getId()==in.nextLong());
                                            break;
                                        case 3:
                                            break;
                                    }
                                }while (choice4!=3);
                                break;
                            case 3://account

                            case 4:
                                break;
                        }
                    }while (choice3!=4);
                case 6:
                    break;
            }
        }while (choice!=6);
    }
}
