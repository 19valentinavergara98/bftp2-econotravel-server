package com.econotravel.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataReserve {


    private final ReservasRepository reservasRepository;

    @Autowired
    public SampleDataReserve(ReservasRepository reservasRepository) {

        this.reservasRepository = reservasRepository;
    }

    @PostConstruct
    public void addSampleReservas() {
        if (reservasRepository.findAll().isEmpty()) {
            List<Reservas> reservas = List.of(
                    new Reservas("Luis Escobar Garcia",
                            "654444444",
                            2,
                            "lescobargmail.com",
                            "Paseo en bicicleta por el Montseny",
                            "nada"),
                    new Reservas("Carla Bruni",
                            "645886688",
                            1,
                            "cbruni@gmail.com",
                            "Arte en la montaña sagrada",
                            "guia privado")
            );

            reservasRepository.saveAll(reservas);
        }
    }
}