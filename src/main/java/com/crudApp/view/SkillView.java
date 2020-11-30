package com.crudApp.view;

import com.crudApp.controller.SkillController;
import com.crudApp.model.Skill;

import java.util.List;
import java.util.Scanner;

public class SkillView {
    private SkillController skillController = new SkillController();
    private static final String start="Press 1 to find skill\nPress 2 to get all skills\nPress 3 to delete skill\nPress 4 to create skill\nPress 5 to update skill";
    private static final String end="Successfully";
    private static final String text1="Enter skill's id: ";
    private static final String text2="Enter skill's name: ";
    private static final String text4="";


    public void showSkillMenu(){
        System.out.println(start);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice){
            case 1:
                System.out.println(text1);
                long id = in.nextLong();
                System.out.println(skillController.getById(id));
            case 2:
                List<Skill> skills = skillController.getAllSkills();
                System.out.println(skills);
                break;
            case 3:
                System.out.println(text1);
                skillController.deleteById(in.nextLong());
                System.out.println(end);
            case 4:
                String skillName = in.next();
                Skill skill = new Skill(null, skillName);
                Skill savedSkill = skillController.save(skill);
                System.out.println("Saved skill: "+savedSkill);
            case 5:
                skills = skillController.getAllSkills();
                skills.removeIf(skill1 -> skill1.getId() == in.nextLong());


            default:
                throw new IllegalStateException("Unaccepted value: "+choice);

        }

    }
}
