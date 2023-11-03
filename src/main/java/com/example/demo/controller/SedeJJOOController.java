package com.example.demo.controller;

import com.example.demo.dtos.SedeJJOODto;
import com.example.demo.services.SedeJJOOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sedejjoo")
public class SedeJJOOController {
    private final SedeJJOOService sedeJJOOService;

    @Autowired
    public SedeJJOOController(SedeJJOOService sedeJJOOService) {
        this.sedeJJOOService = sedeJJOOService;
    }

    //Endpoint para crear una sede de unos JJOO.
//    @PostMapping
//    public ResponseEntity<SedeJJOO> crearSedeJJOO(@RequestBody SedeJJOO sedeJJOO) {
//        SedeJJOO nuevaSede = sedeJJOOService.crearSedeJJOO(sedeJJOO);
//        return ResponseEntity.ok(nuevaSede);
//    }

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
//    @PutMapping("/{id}")
//    public ResponseEntity<SedeJJOO> actualizarSedeJJOO(@PathVariable Integer id, @RequestBody SedeJJOO sedeActualizada) {
//        SedeJJOO sede = sedeJJOOService.actualizarSedeJJOO(id, sedeActualizada);
//        if (sede != null) {
//            return ResponseEntity.ok(sede);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    // Endpoint para eliminar una sede de JJOO por su ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> borrarSedeJJOO(@PathVariable Integer id) {
//        sedeJJOOService.borrarSedeJJOO(id);
//        return ResponseEntity.noContent().build();
//    }
}
