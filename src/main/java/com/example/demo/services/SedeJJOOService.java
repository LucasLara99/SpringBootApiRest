package com.example.demo.services;

import com.example.demo.entities.SedeJJOO;
import com.example.demo.repositories.SedeJJOORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SedeJJOOService {
    private final SedeJJOORepository sedeJJOORepository;

    @Autowired // Inyección de dependencias.
    public SedeJJOOService(SedeJJOORepository sedeJJOORepository) {
        this.sedeJJOORepository = sedeJJOORepository;
    }

    // CRUD de SedeJJOO
    // CREATE
    @Transactional // Indica que este método es transaccional.
    public SedeJJOO crearSedeJJOO(SedeJJOO sedeJJOO) {
        if (sedeJJOO.getAño() <= 0 || sedeJJOO.getTipoJJOO() == null || sedeJJOO.getSede() == null) {
            throw new IllegalArgumentException("Los datos de la sede no son válidos.");
        }
        return sedeJJOORepository.save(sedeJJOO);
    }

    // READ
    @Transactional(readOnly = true)
    public SedeJJOO obtenerSedeJJOO(Integer id) {
        return sedeJJOORepository.findById(id).orElse(null);
    }

    // UPDATE
    @Transactional
    public SedeJJOO actualizarSedeJJOO(Integer id, SedeJJOO sedeJJOO) {
        SedeJJOO sedeExistente = sedeJJOORepository.findById(id).orElse(null);
        if (sedeExistente != null) {
            // Actualiza los campos de la sede existente con los nuevos datos.
            sedeExistente.setAño(sedeJJOO.getAño());
            sedeExistente.setTipoJJOO(sedeJJOO.getTipoJJOO());
            sedeExistente.setSede(sedeJJOO.getSede());
            return sedeJJOORepository.save(sedeExistente);
        } else {
            // Maneja el caso en el que la sede no existe.
            return null;
        }
    }

    // DELETE
    @Transactional
    public void borrarSedeJJOO(Integer id) {
        // Agrega lógica de validación y procesamiento de datos aquí.
        sedeJJOORepository.deleteById(id);
    }

    // Puedes agregar más métodos y lógica según tus necesidades.
}
