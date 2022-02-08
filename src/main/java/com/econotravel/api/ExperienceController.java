package com.econotravel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
// NO INCLUIR NUNCA LA CABECERA CrossOrigin en un proyecto real
@CrossOrigin
public class ExperienceController {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @GetMapping
    public List<Experience> allExperiences() {

        return experienceRepository.findAll();

    }
    @GetMapping("/{id}")
    public Experience getExperience(@PathVariable Long id) {
        return experienceRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceRepository.save(experience);
    }


    @GetMapping("/experiences/{id}/edit")
    String editExperience(Model model, @PathVariable Long id) {
        Experience experience = experienceRepository.findById(id).get();
        model.addAttribute("experience", experience);
        model.addAttribute("name", "Edit experience");
        return "experiences/edit";
    }
}