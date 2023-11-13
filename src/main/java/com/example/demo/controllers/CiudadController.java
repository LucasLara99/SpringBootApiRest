package com.example.demo.controllers;

import com.example.demo.dtos.CiudadDto;
import com.example.demo.services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {
    private final CiudadService ciudadService;

    @Autowired
    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public ResponseEntity<List<CiudadDto>> obtenerCiudades() {
        List<CiudadDto> ciudades = ciudadService.obtenerTodasLasCiudades();
        if (ciudades != null) {
            return ResponseEntity.ok(ciudades);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
