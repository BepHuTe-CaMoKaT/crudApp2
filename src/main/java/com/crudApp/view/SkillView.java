package com.crudApp.view;

import com.crudApp.controller.SkillController;
import com.crudApp.model.Skill;

import java.util.List;
import java.util.Scanner;

public class SkillView {
    private SkillController skillController = new SkillController();
    private static final String start = "Press 1 to find skill\nPress 2 to get all skills\nPress 3 to delete skill\nPress 4 to create skill\nPress 5 to update skill \nPress 6 to exit";
    private static final String end = "Successfully";
    private static final String text1 = "Enter skill's id: ";
    private static final String text2 = "Enter skill's name: ";
    private static final String text3 = "Enter skill's name to update: ";


    public void showSkillMenu() {

        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println(start);
            switch (choice = in.nextInt()) {
                case 1:
                    System.out.println(text1);
                    long id = in.nextLong();
                    System.out.println(skillController.getById(id) + "\n");
                    break;
                case 2:
                    List<Skill> skills = skillController.getAllSkills();
                    System.out.println(skills + "\n");
                    break;
                case 3:
                    System.out.println(text1);
                    skillController.deleteById(in.nextLong());
                    System.out.println(end + "\n");
                    choice = 6;
                    break;

                case 4:
                    System.out.println(text2);
                    String skillName = in.next();
                    Skill skill = new Skill(null, skillName);
                    Skill savedSkill = skillController.save(skill);
                    System.out.println("Saved skill: " + savedSkill + "\n");
                    break;
                case 5:
                    System.out.println(text1);
                    long choice1 = in.nextLong();
                    Skill skill1 = skillController.getById(choice1);
                    System.out.println(text3);
                    skill1.setName(in.next());
                    skillController.update(skill1);
                    System.out.println(skill1 + " updated\n");
                    break;
                case 6:
                    break;
            }
        } while (choice != 6);


    }
}
