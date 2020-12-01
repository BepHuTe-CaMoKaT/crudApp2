package com.crudApp.view;



import com.crudApp.controller.AccountController;
import com.crudApp.controller.DeveloperController;
import com.crudApp.controller.SkillController;
import com.crudApp.model.Account;
import com.crudApp.model.Developer;
import com.crudApp.model.Skill;
import com.crudApp.util.IOUtils;

import java.util.*;

public class DeveloperView extends IOUtils {
    private DeveloperController developerController = new DeveloperController();
    private static final String start="Press 1 to find developer\nPress 2 to get all developers\nPress 3 to delete developer\nPress 4 to create developer\nPress 5 to update developer";
    private static final String end="Successfully";
    private static final String text1="Enter developer's id: ";
    private static final String text2="Enter developer's name: ";
    private static final String text3="Enter developer's skills: \n1,pascal/\n2,maven/\n3,sql/\n4,python/\n5,go/\n0,Continue";
    private static final String text4="";



    public void showDeveloperMenu(){
        System.out.println(start);
        Scanner in = new Scanner(System.in);
        int choice= in.nextInt();
        switch (choice){
            case 1:
                System.out.println(text1);
                long id = in.nextLong();
                System.out.println(developerController.getById(id));
                break;
            case 2:
                List<Developer> developers = developerController.getAllDevelopers();
                System.out.println(developers);
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
                    skills.add(skillController.getById(choice1));
                }while (choice1!=0);
                Account account = new Account();
                Developer dev = new Developer(devName,skills,account);
                Developer savedDev = developerController.save(dev);
                System.out.println("Saved developer: "+savedDev);
                break;
        }
    }





}
