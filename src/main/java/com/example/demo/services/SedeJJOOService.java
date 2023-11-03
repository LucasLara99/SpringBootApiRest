package com.example.demo.services;

import com.example.demo.dtos.SedeJJOODto;
import com.example.demo.entities.SedeJJOO;
import com.example.demo.entities.SedeJJOOKey;
import com.example.demo.mappers.SedeJJOOMapper;
import com.example.demo.repositories.SedeJJOORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SedeJJOOService {
    private final SedeJJOORepository sedeJJOORepository;
    private final SedeJJOOMapper sedeJJOOMapper;

    @Autowired
    public SedeJJOOService(SedeJJOORepository sedeJJOORepository,
                           SedeJJOOMapper sedeJJOOMapper) {
        this.sedeJJOORepository = sedeJJOORepository;
        this.sedeJJOOMapper = sedeJJOOMapper;
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
    public SedeJJOODto obtenerSedeJJOO(Integer año, Integer id_tipo_jjoo) {
        SedeJJOO sedeJJOO = sedeJJOORepository.findById(new SedeJJOOKey(año, id_tipo_jjoo)).orElse(null);
        if (sedeJJOO != null) {
            return sedeJJOOMapper.ModelToDto(sedeJJOO);
        } else {
            return null;
        }
    }

    // UPDATE
    @Transactional
    public SedeJJOO actualizarSedeJJOO(Integer año, Integer idTipoJJOO, SedeJJOO sedeRequest) {
        SedeJJOO sedeExistente = sedeJJOORepository.findById(new SedeJJOOKey(año, idTipoJJOO)).orElse(null);

        if (sedeExistente != null) {
            //Actualizamos los datos que vengan en la request
            if (sedeRequest.getSede() != null) {
                sedeExistente.setSede(sedeRequest.getSede());
            }
            return sedeJJOORepository.save(sedeExistente);
        } else {
            return null;
        }
    }


    // DELETE
//
//    @Transactional
//    public void borrarSedeJJOO(Integer id) {
//        sedeJJOORepository.deleteById(id);
//    }
}
