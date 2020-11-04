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
        Set<Skill> skills = new HashSet<>();
        Skill skill = new Skill(4L,"Java");
        Skill skill1 = new Skill(3L,"Pascal");
        skills.add(skill);
        skills.add(skill1);
        DeveloperRepository developerRepository = new DeveloperRepository();
        Account account = new Account(2L,"dev",AccountStatus.ACTIVE);

//        System.out.println(developerRepository.getById(1L));
        System.out.println(developerRepository.getAll());
//        System.out.println(developerRepository.save(new Developer(2L,"Bruce",skills,account)));
        developerRepository.deleteById(1L);
        System.out.println(developerRepository.getAll());








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
