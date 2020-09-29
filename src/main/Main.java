package main;

public class Main {

    public static void main(String[] args) {
        SkillRepository skillRepository = new SkillRepository();
        Skill skill = new Skill(1L,"Pascal");
        Skill skill1 = new Skill("Java");
        System.out.println(skillRepository.getById(2L));
        System.out.println(skillRepository.getAll());
        System.out.println(skillRepository.save(skill1));
        System.out.println(skillRepository.getAll());
        skillRepository.deleteById(1L);
        System.out.println(skillRepository.getAll());
        System.out.println(skillRepository.update(skill));
        System.out.println(skillRepository.getAll());
    }
}
