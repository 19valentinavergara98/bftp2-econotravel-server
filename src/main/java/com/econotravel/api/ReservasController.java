package com.econotravel.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/reservas")
// NO INCLUIR NUNCA LA CABECERA CrossOrigin en un proyecto real
@CrossOrigin
public class ReservasController {
    private final ReservasRepository reservasRepository;

    @Autowired
    public ReservasController(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    @GetMapping
    public List<Reservas> allReservas() {
        return reservasRepository.findAll();
    }

    @PostMapping
    public Reservas createReservas(@RequestBody Reservas reservas) {
        return reservasRepository.save(reservas);

    }

}