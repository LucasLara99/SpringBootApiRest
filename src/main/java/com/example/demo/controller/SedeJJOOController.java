package com.example.demo.controller;

import com.example.demo.dtos.SedeJJOODto;
import com.example.demo.entities.SedeJJOO;
import com.example.demo.services.SedeJJOOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/sedejjoo")
public class SedeJJOOController {
    private final SedeJJOOService sedeJJOOService;

    @Autowired
    public SedeJJOOController(SedeJJOOService sedeJJOOService) {
        this.sedeJJOOService = sedeJJOOService;
    }


    //Endpoint para crear una sede de unos JJOO.
    @PostMapping
    public ResponseEntity<SedeJJOO> crearSedeJJOO(@RequestBody SedeJJOO sedeJJOO) {
        SedeJJOO nuevaSede = sedeJJOOService.crearSedeJJOO(sedeJJOO);
        if (nuevaSede != null) {
            // Construimos una URI que representa la ubicación del nuevo recurso
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{año}/{id_tipo_jjoo}")
                    .buildAndExpand(nuevaSede.getId().getAño(), nuevaSede.getId().getId_tipo_jjoo())
                    .toUri();
            return ResponseEntity.created(location).body(nuevaSede);
        } else {
            return ResponseEntity.badRequest().build(); // Cambiado a HttpStatus.BAD_REQUEST
        }
    }


    // Endpoint para obtener una sede de JJOO por su año y id_tipo_jjoo
    @GetMapping("/{año}/{id_tipo_jjoo}")
    public ResponseEntity<SedeJJOODto> obtenerSedeJJOO(@PathVariable Integer año, @PathVariable Integer id_tipo_jjoo) {
        SedeJJOODto sede = sedeJJOOService.obtenerSedeJJOO(año, id_tipo_jjoo);
        if (sede != null) {
            return ResponseEntity.ok(sede);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Endpoint para actualizar una sede de JJOO por su ID
    @PutMapping("/{año}/{idTipoJJOO}")
    public ResponseEntity<SedeJJOO> actualizarSedeJJOO(
            @PathVariable Integer año,
            @PathVariable Integer idTipoJJOO,
            @RequestBody SedeJJOO sedeRequest) {

        SedeJJOO sedeActualizada = sedeJJOOService.actualizarSedeJJOO(año, idTipoJJOO, sedeRequest);

        if (sedeActualizada != null) {
            return ResponseEntity.ok(sedeActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Endpoint para eliminar una sede de JJOO por su ID
    @DeleteMapping("/{año}/{id_tipo_jjoo}")
    public ResponseEntity<String> eliminarSedeJJOO(@PathVariable Integer año, @PathVariable Integer id_tipo_jjoo) {
        boolean eliminado = sedeJJOOService.eliminarSedeJJOO(año, id_tipo_jjoo);
        if (eliminado) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sede eliminada exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la sede para eliminar");
        }
    }
}
