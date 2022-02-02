package com.econotravel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {
    private ExperienceRepository experienceRepository;

    @Autowired
    public SampleDataLoader(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        experienceRepository.saveAll(List.of(
                new Experience("Paseo en bicicleta por el Montseny", "250", "5h", "montaña, bicicleta, excursión larga",),
                new Experience("Descubre la costa en barco de vela", "280", "4h", "playa, barco, excursion larga"),
                new Experience("Descubre la Barcelona Modernista de noche", "200")
                new Experience("Wii Sports Resort", "9,99", "Sports", "https://uvejuegos.com/img/caratulas/31529/wii_sports_resort.jpg"),
                new Experience("Pokemon Red/Pokemon Blue", "29,99", "Role-Playing", "https://romsjuegos.com/wp-content/uploads/pokemon-red-and-blue-version-gameboy-cover.png"),
        ));
    }
}
}
