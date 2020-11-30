package com.crudApp.controller;

import com.crudApp.model.Developer;
import com.crudApp.repository.DeveloperRepository;
import com.crudApp.repository.io.JavaIODeveloperRepositoryImpl;

import java.util.List;


public class DeveloperController {

    private DeveloperRepository javaIODeveloperRepository = new JavaIODeveloperRepositoryImpl();
    public Developer getById(long id){
        return javaIODeveloperRepository.getById(id);
    }
    public List<Developer> getAllDevelopers(){
        return javaIODeveloperRepository.getAll();
    }
    public Developer save(Developer developer){
        return javaIODeveloperRepository.save(developer);
    }
    public void deleteById(Long id){
        javaIODeveloperRepository.deleteById(id);
    }
    public Developer update(Developer developer){
        return javaIODeveloperRepository.update(developer);
    }


}
