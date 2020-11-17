package main.View;

import main.Controller.AccountController;
import main.Controller.DeveloperController;
import main.Controller.SkillController;
import main.Model.Account;
import main.Model.Developer;
import main.Model.Skill;
import main.util.IOUtils;

import java.util.Scanner;
import java.util.Set;

public class DeveloperView extends IOUtils {
    private String path = "C:/Users/Никита/IdeaProjects/crudApp1/src/main/resources/developers.txt";
    private DeveloperController developerController = new DeveloperController();
    private SkillController skillController = new SkillController();
    private AccountController accountController = new AccountController();
    private static final String start="Press 1 to find developer\nPress 2 to get all developers\nPress 3 to delete developer\nPress 4 to create developer\nPress 5 to update developer";
    private static final String end="Successfully";
    private static final String text1="Enter developer's id: ";
    private static final String text2="Enter developer's name: ";
    private static final String text3="Enter developer's skills: ";
    private static final String text4="";
    Scanner in = new Scanner(System.in);


    public void run(){
        System.out.println(start);
        int i= in.nextInt();
        switch (i){
            case 1:
                System.out.println(text1);
                long id = in.nextLong();
                System.out.println(developerController.getById(id));
            case 2:
                developerController.getAllDevelopers();
            case 3:
                System.out.println(text1);
                developerController.deleteById(in.nextLong());
                System.out.println(end);
            case 4:
                System.out.println(text2);
                String name = in.next();
                do {
                    String skillName = in.next();
                }while (!in.next().equals("1"));
                save(name);
        }
    }
    public boolean save(String name,){
        writeToFile(path,idGenerator() + "," + name + "," ,true);
        return true;
    }
    private long            idGenerator() {
        try {
            String[] devAllRecords = readFromFile(path).split("/");
            return devAllRecords.length + 1;
        } catch (Exception e) {
            throw new RuntimeException("Error is occurred in idGenerator method " + e.getMessage());
        }
    }




}
