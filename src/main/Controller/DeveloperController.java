package main.Controller;

import main.Model.Developer;
import main.Repository.DeveloperRepository;

public class DeveloperController {

    private DeveloperRepository developerRepository = new DeveloperRepository();
    public Developer getById(long id){
        return developerRepository.getById(id);
    }
    public void getAllDevelopers(){
        System.out.println(developerRepository.getAll());
    }
    public Developer save(Developer developer){
        return developerRepository.save(developer);
    }
    public void deleteById(long id){
        developerRepository.deleteById(id);
    }
    public Developer update(Developer developer){
        return developerRepository.update(developer);
    }


}
