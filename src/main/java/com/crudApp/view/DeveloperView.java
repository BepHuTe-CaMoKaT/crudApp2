package com.crudApp.view;



import com.crudApp.controller.AccountController;
import com.crudApp.controller.DeveloperController;
import com.crudApp.controller.SkillController;
import com.crudApp.model.Developer;
import com.crudApp.util.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperView extends IOUtils {
    private DeveloperController developerController = new DeveloperController();
    private static final String start="Press 1 to find developer\nPress 2 to get all developers\nPress 3 to delete developer\nPress 4 to create developer\nPress 5 to update developer";
    private static final String end="Successfully";
    private static final String text1="Enter developer's id: ";
    private static final String text2="Enter developer's name: ";
    private static final String text3="Enter developer's skills: ";
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
            case 2:
                List<Developer> developers = developerController.getAllDevelopers();
                System.out.println(developers);
                break;
            case 3:
                System.out.println(text1);
                developerController.deleteById(in.nextLong());
                System.out.println(end);
            case 4:

        }
    }





}
