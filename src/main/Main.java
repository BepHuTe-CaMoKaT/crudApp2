package main;

import main.Controller.AccountController;
import main.Controller.DeveloperController;
import main.Controller.SkillController;
import main.Model.Account;
import main.Model.AccountStatus;
import main.Model.Developer;
import main.Model.Skill;
import main.Repository.AccountRepository;
import main.Repository.DeveloperRepository;
import main.Repository.SkillRepository;
import main.View.DeveloperView;

import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) {


        DeveloperView developerView = new DeveloperView();
        developerView.run();

//        Set<Skill> skills = new HashSet<>();
//        Skill skill = new Skill(4L,"python");
//        Skill skill1 = new Skill("go");
//        skills.add(skill);
//        skills.add(skill1);

        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account("developer",AccountStatus.ACTIVE);
        Account account1 = new Account(2L,"developer",AccountStatus.ACTIVE);
//        System.out.println(accountRepository.save(account));
//        System.out.println(accountRepository.getAll());
//        System.out.println(accountRepository.update(account));
//        System.out.println(accountRepository.getAll());
        AccountController accountController = new AccountController();
//        accountController.getAllAccounts();
//        System.out.println(accountController.getById(1L));
//        accountController.deleteById(1L);
//        accountController.save(account);
//        accountController.update(account1);
//        accountController.getAllAccounts();

        DeveloperController developerController = new DeveloperController();
//        Developer developer = new Developer(1L,"Bruce",skills,account);
//        developerController.getAllDevelopers();
//        System.out.println(developerController.getById(1L));
//        developerController.deleteById(1L);
//        developerController.save(new Developer("Bruce",skills,account));
//        developerController.update(developer);
//        developerController.getAllDevelopers();

        SkillController skillController = new SkillController();
//        skillController.getAllSkills();
//        System.out.println(skillController.getById(1L));
//        skillController.deleteById(1L);
//        skillController.save(skill1);
//        skillController.update(skill);
//        skillController.getAllSkills();

        DeveloperRepository developerRepository = new DeveloperRepository();
//        System.out.println(developerRepository.getById(1L));
//        System.out.println(developerRepository.getAll());
//        System.out.println(developerRepository.save(new Developer("Bruce",skills,account)));
//        developerRepository.deleteById(3L);
//        Developer developer = new Developer(1L,"Nick",skills,account);
//        System.out.println(developerRepository.update(developer));
//        System.out.println(developerRepository.getAll());










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
