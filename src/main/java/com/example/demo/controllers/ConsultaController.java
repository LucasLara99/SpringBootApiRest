package com.example.demo.controllers;

import com.example.demo.entities.Consulta;
import com.example.demo.exceptions.ConsultaException;
import com.example.demo.services.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(ConsultaException.class)
    public ResponseEntity<String> handleConsultaException(ConsultaException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}