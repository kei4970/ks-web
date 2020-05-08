package com.sangkon.app;

import com.sangkon.app.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.sangkon.app.entity.*;

import java.util.List;

@Controller
public class IndexController {

    private final PersonRepository personRepository;
    private final SocialMediaRepository socialMediaRepository;
    private final InterestsRepository interestsRepository;
    private final SkillRepository skillRepository;
    private final WorkRepository workRepository;

    public IndexController(PersonRepository personRepository, SocialMediaRepository
                           socialMediaRepository, InterestsRepository interestsRepository, SkillRepository skillRepository, WorkRepository workRepository){
        this.personRepository = personRepository;
        this.socialMediaRepository = socialMediaRepository;
        this.interestsRepository = interestsRepository;
        this.skillRepository = skillRepository;
        this.workRepository = workRepository;

    }

    @GetMapping("/")
    public String index(Model model){
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        SocialMedia socialMedia = socialMediaRepository.findAll().stream().findFirst().orElse(null);
        List<SocialMedia> interests = interestsRepository.findAll();
        List<Person> skills = skillRepository.findAll();
        List<SocialMedia> works = workRepository.findAll();
        model.addAttribute("works", works);
        model.addAttribute("skills", skills);
        model.addAttribute("interests", interests);
        model.addAttribute("socialMedia", socialMedia);
        model.addAttribute("person",person);
        return "resume";
    }
}
