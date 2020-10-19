package main;

import main.Model.Account;
import main.Model.AccountStatus;
import main.Model.Developer;
import main.Model.Skill;
import main.Repository.DeveloperRepository;
import main.Repository.SkillRepository;

import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        DeveloperRepository developerRepository = new DeveloperRepository();
        System.out.println(developerRepository.getById(1L));







//        SkillRepository skillRepository = new SkillRepository();
//        System.out.println(skillRepository.getById(2L));
//        System.out.println(skillRepository.getAll());
//        System.out.println(skillRepository.save(skill1));
//        System.out.println(skillRepository.getAll());
//        skillRepository.deleteById(1L);
//        System.out.println(skillRepository.getAll());
//        System.out.println(skillRepository.update(skill));
//        System.out.println(skillRepository.getAll());
    }
}
