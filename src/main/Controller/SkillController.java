package main.Controller;

import main.Model.Skill;
import main.Repository.SkillRepository;

public class SkillController {
    private SkillRepository skillRepository = new SkillRepository();
    public Skill getById(long id){
        return skillRepository.getById(id);
    }
    public void getAllSkills(){
        System.out.println(skillRepository.getAll());
    }
    public Skill save(Skill skill){
        return skillRepository.save(skill);
    }
    public void deleteById(long id){
        skillRepository.deleteById(id);
    }
    public Skill update(Skill skill){
        return skillRepository.update(skill);
    }
}
