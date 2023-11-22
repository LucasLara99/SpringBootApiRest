package com.example.demo.controllers;

import com.example.demo.entities.Consulta;
import com.example.demo.services.ConsultaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ConsultaController {
    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }


    /**
     * Obtiene una consulta
     *
     * @return Consulta
     */
    @GetMapping
    public List<Consulta> getRealizarConsulta() {
        return consultaService.realizarConsulta();
    }
}
