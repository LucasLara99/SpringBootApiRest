package com.example.demo.services;

import com.example.demo.entities.SedeJJOO;
import com.example.demo.entities.SedeJJOOKey;
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

//    @Transactional // Indica que este método es transaccional.
//    public SedeJJOO crearSedeJJOO(SedeJJOO sedeJJOO) {
//        if (sedeJJOO.getAño() <= 0 || sedeJJOO.getId_tipo_jjoo() == null || sedeJJOO.getSede() == null) {
//            throw new IllegalArgumentException("Los datos de la sede no son válidos.");
//        }
//        return sedeJJOORepository.save(sedeJJOO);
//    }

    // READ

    @Transactional(readOnly = true)
    public SedeJJOO obtenerSedeJJOO(Integer año, Integer id_tipo_jjoo) {
        return sedeJJOORepository.findById(new SedeJJOOKey(año, id_tipo_jjoo)).orElse(null);
    }

    // UPDATE

//    @Transactional
//    public SedeJJOO actualizarSedeJJOO(Integer id, SedeJJOO sedeActualizada) {
//        SedeJJOO sedeExistente = sedeJJOORepository.findById(id).orElse(null);
//
//        if (sedeExistente != null) {
//            if (sedeActualizada.getAño() != null) {
//                sedeExistente.setAño(sedeActualizada.getAño());
//            }
//            if (sedeActualizada.getId_tipo_jjoo() != null) {
//                sedeExistente.getId_tipo_jjoo(sedeActualizada.getTipoJJOO());
//            }
//            if (sedeActualizada.getSede() != null) {
//                sedeExistente.setSede(sedeActualizada.getSede());
//            }
//            return sedeJJOORepository.save(sedeExistente);
//        } else {
//            // Maneja el caso en el que la sede no existe.
//            return null;
//        }
//    }

    // DELETE
//
//    @Transactional
//    public void borrarSedeJJOO(Integer id) {
//        sedeJJOORepository.deleteById(id);
//    }
}
