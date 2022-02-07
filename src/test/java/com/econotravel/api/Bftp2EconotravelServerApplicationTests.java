package com.econotravel.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
@AutoConfigureMockMvc
class Bftp2EconotravelServerApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ExperienceRepository experienceRepository;

    @BeforeEach
    void setUp() {
        experienceRepository.deleteAll();
    }

    @Test
    void returnsTheExistingExperiences() throws Exception {

        addSampleExperiences();

        mockMvc.perform(get("/api/experiences"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].name", equalTo("Paseo por el Montseny")))
                .andExpect(jsonPath("$[1].name", equalTo("Visita a la sagrada familia")))
                .andDo(print());
    }

    private void addSampleExperiences() {
        List<Experience> experiences = List.of(
                new Experience("Paseo por el Montseny"),
                new Experience("Visita a la sagrada familia")
        );

        experienceRepository.saveAll(experiences);
    }

    @Test
    void createsNewExperiences() throws Exception {

        mockMvc.perform(post("/api/experiences")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Paseo en Bici por el Montseny\"}")
        ).andExpect(status().is(200));

        var experiences = experienceRepository.findAll();

        assertThat(experiences, contains(
                hasProperty("name", is("Paseo en Bici por el Montseny"))
        ));
    }

    @Test
    void editNewExperiences() throws Exception {
        // Dado que tenemos una experiencia que ya esta creada
        Experience experience = experienceRepository.save(new Experience("Paseo en Bici por el Montseny", "30", "4", "montaña, bicicleta, excursión larga"));
        //Cuando editamos la info enviandola al servidor
        mockMvc.perform(put("/experiences/" + experience.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Paseo en Bici por el Montseny\",\"price\": \"20\",\"duration\": \"4\",\"tag\": \"montaña, bicicleta, excursión larga\" }"))
                .andExpect(status().isOk());


        // entonces vere que la experiencia se ha actualizado en la base de datos

        var experiences = experienceRepository.findAll();
        assertThat(experiences, contains(allOf(
                hasProperty("name", is("Paseo en Bici por el Montseny")),
                hasProperty("price", is("20"))
        )));


    }

    // TEST DE DELETE
    // Dado que tengo una experiencia guardada con id "ïd"
    // cuando hago DELETE /experiences/"ïd"
    // entonces esta experiencia ya no debe salir en la lista de experiencias


}


