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
                new Experience("Paseo en bicicleta por el Montseny", "250", "5h", "montaña, bicicleta, excursión larga"),
                new Experience("Descubre la costa en barco de vela", "280", "4h", "playa, barco, excursion larga"),
                new Experience("Descubre la Barcelona Modernista de noche", "200", "4h", "ciudad, pie,excursion larga"),
                new Experience("Del huerto a la mesa", "145", "3h", "montaña, a pie, excursion corta" ),
                new Experience("Arte en la montaña sagrada", "2h", "125", "montaña, a pie, excursion corta")
        ));
    }
}

