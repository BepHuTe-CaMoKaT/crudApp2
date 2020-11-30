package com.crudApp.controller;

import com.crudApp.model.Skill;
import com.crudApp.repository.SkillRepository;
import com.crudApp.repository.io.JavaIOSkillRepositoryImpl;

import java.util.List;

public class SkillController {
    private SkillRepository javaIOSkillRepositoryImpl = new JavaIOSkillRepositoryImpl();
    public Skill getById(long id){
        return javaIOSkillRepositoryImpl.getById(id);
    }
    public List<Skill> getAllSkills(){
        return javaIOSkillRepositoryImpl.getAll();
    }
    public Skill save(Skill skill){
        return javaIOSkillRepositoryImpl.save(skill);
    }
    public void deleteById(Long id){
        javaIOSkillRepositoryImpl.deleteById(id);
    }
    public Skill update(Skill skill){
        return javaIOSkillRepositoryImpl.update(skill);
    }
}
