package com.example.demo.controllers;

import com.example.demo.dtos.CrearSedeJJOODto;
import com.example.demo.dtos.SedeJJOODto;
import com.example.demo.entities.SedeJJOO;
import com.example.demo.services.SedeJJOOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sedejjoo")
public class SedeJJOOController {
    private final SedeJJOOService sedeJJOOService;

    @Autowired
    public SedeJJOOController(SedeJJOOService sedeJJOOService) {
        this.sedeJJOOService = sedeJJOOService;
    }


    /**
     * Crea una sede de unos JJOO
     *
     * @param crearSedeDto Sede de los JJOO
     * @return Sede de los JJOO creada
     */
    @PostMapping
    public ResponseEntity<SedeJJOODto> crearSedeJJOO(@RequestBody CrearSedeJJOODto crearSedeDto) {
        SedeJJOO nuevaSede = sedeJJOOService.crearSedeJJOO(crearSedeDto);
        if (nuevaSede != null) {
            SedeJJOODto nuevaSedeDto = sedeJJOOService.obtenerSedeJJOO(nuevaSede.getId().getAño(), nuevaSede.getId().getId_tipo_jjoo());
            // Construimos una URI que representa la ubicación del nuevo recurso
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{año}/{id_tipo_jjoo}")
                    .buildAndExpand(nuevaSede.getId().getAño(), nuevaSede.getId().getId_tipo_jjoo())
                    .toUri();
            return ResponseEntity.created(location).body(nuevaSedeDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    /**
     * Obtiene una sede de unos JJOO
     *
     * @param año          Año de los JJOO
     * @param id_tipo_jjoo Id del tipo de JJOO
     * @return Sede de los JJOO
     */
    @GetMapping("/{año}/{id_tipo_jjoo}")
    public ResponseEntity<SedeJJOODto> obtenerSedeJJOO(@PathVariable Integer año, @PathVariable Integer id_tipo_jjoo) {
        SedeJJOODto sede = sedeJJOOService.obtenerSedeJJOO(año, id_tipo_jjoo);
        if (sede != null) {
            return ResponseEntity.ok(sede);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Obtiene todas las sedes de los JJOO
     *
     * @return Lista de sedes de los JJOO
     */
    @GetMapping
    public ResponseEntity<List<SedeJJOODto>> obtenerSedesJJOO() {
        List<SedeJJOODto> sedes = sedeJJOOService.obtenerTodasLasSedesJJOO();
        if (!sedes.isEmpty()) {
            return ResponseEntity.ok(sedes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Actualiza una sede de unos JJOO
     *
     * @param año
     * @param idTipoJJOO
     * @param sedeRequest
     * @return
     */
    @PutMapping("/{año}/{idTipoJJOO}")
    public ResponseEntity<SedeJJOODto> actualizarSedeJJOO(
            @PathVariable Integer año,
            @PathVariable Integer idTipoJJOO,
            @RequestBody SedeJJOODto sedeRequest) {

        SedeJJOO sedeActualizada = sedeJJOOService.actualizarSedeJJOO(año, idTipoJJOO, sedeRequest);

        if (sedeActualizada != null) {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(año, idTipoJJOO)
                    .toUri();
            return ResponseEntity.ok().location(location).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Elimina una sede de unos JJOO
     *
     * @param año
     * @param id_tipo_jjoo
     * @return
     */
    @DeleteMapping("/{año}/{id_tipo_jjoo}")
    public ResponseEntity<String> eliminarSedeJJOO(@PathVariable Integer año, @PathVariable Integer id_tipo_jjoo) {
        boolean eliminado = sedeJJOOService.eliminarSedeJJOO(año, id_tipo_jjoo);
        if (eliminado) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sede eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la sede para eliminar");
        }
    }
}
