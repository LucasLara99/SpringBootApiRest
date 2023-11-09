package com.example.demo.services;

import com.example.demo.dtos.SedeJJOODto;
import com.example.demo.entities.Ciudad;
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
    public SedeJJOOService(SedeJJOORepository sedeJJOORepository, SedeJJOOMapper sedeJJOOMapper) {
        this.sedeJJOORepository = sedeJJOORepository;
        this.sedeJJOOMapper = sedeJJOOMapper;
    }

    // CRUD de SedeJJOO
    // CREATE
    @Transactional
    public SedeJJOO crearSedeJJOO(SedeJJOO sedeJJOO) {
        SedeJJOOKey id = sedeJJOO.getId();
        if (id == null) {
            throw new IllegalArgumentException("La clave primaria (ID) no puede ser nula.");
        }

        Integer ciudadId = sedeJJOO.getSede().getIdCiudad();
        if (ciudadId != null) {
            Ciudad ciudad = new Ciudad();
            ciudad.setIdCiudad(ciudadId);
            sedeJJOO.setSede(ciudad);
        }

        return sedeJJOORepository.save(sedeJJOO);
    }


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
    @Transactional
    public boolean eliminarSedeJJOO(Integer año, Integer idTipoJjoo) {
        SedeJJOO sedeExistente = sedeJJOORepository.findById(new SedeJJOOKey(año, idTipoJjoo)).orElse(null);
        if (sedeExistente != null) {
            sedeJJOORepository.delete(sedeExistente);
            return true;
        } else {
            return false;
        }
    }
}
