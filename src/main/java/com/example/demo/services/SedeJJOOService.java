package com.example.demo.services;

import com.example.demo.dtos.SedeJJOODto;
import com.example.demo.entities.Ciudad;
import com.example.demo.entities.SedeJJOO;
import com.example.demo.entities.SedeJJOOKey;
import com.example.demo.mappers.SedeJJOOMapper;
import com.example.demo.repositories.SedeJJOORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


/**
 * Clase SedeJJOOService que contiene los métodos para crear, obtener, actualizar y eliminar una sede de unos JJOO
 *
 * @version 09/11/2023
 */
@Service
public class SedeJJOOService {
    private final SedeJJOORepository sedeJJOORepository;
    private final SedeJJOOMapper sedeJJOOMapper;


    @Autowired
    public SedeJJOOService(SedeJJOORepository sedeJJOORepository, SedeJJOOMapper sedeJJOOMapper) {
        this.sedeJJOORepository = sedeJJOORepository;
        this.sedeJJOOMapper = sedeJJOOMapper;
    }


    /**
     * Crea una sede de unos JJOO
     *
     * @param sedeJJOO Sede de los JJOO
     * @return Sede de los JJOO creada
     */
    @Transactional
    public SedeJJOO crearSedeJJOO(SedeJJOO sedeJJOO) {
        SedeJJOOKey id = sedeJJOO.getId();
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id de la sede no puede ser nulo");
        }

        Integer ciudadId = sedeJJOO.getSede().getIdCiudad();
        if (ciudadId != null) {
            Ciudad ciudad = new Ciudad();
            ciudad.setIdCiudad(ciudadId);
            sedeJJOO.setSede(ciudad);
        }

        return sedeJJOORepository.save(sedeJJOO);
    }


    /**
     * Obtiene una sede de unos JJOO
     *
     * @param año          Año de los JJOO
     * @param id_tipo_jjoo Id del tipo de JJOO
     * @return Sede de los JJOO
     */
    @Transactional(readOnly = true)
    public SedeJJOODto obtenerSedeJJOO(Integer año, Integer id_tipo_jjoo) {
        SedeJJOO sedeJJOO = sedeJJOORepository.findById(new SedeJJOOKey(año, id_tipo_jjoo)).orElse(null);
        if (sedeJJOO != null) {
            return sedeJJOOMapper.ModelToDto(sedeJJOO);
        } else {
            return null;
        }
    }


    /**
     * Actualiza una sede de unos JJOO
     *
     * @param año         Año de los JJOO
     * @param idTipoJJOO  Id del tipo de JJOO
     * @param sedeRequest Sede de los JJOO con los datos actualizados
     * @return Sede de los JJOO actualizada
     */
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


    /**
     * Elimina una sede de unos JJOO
     *
     * @param año        Año de los JJOO
     * @param idTipoJjoo Id del tipo de JJOO
     * @return true si se ha eliminado, false si no se ha encontrado
     */
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
