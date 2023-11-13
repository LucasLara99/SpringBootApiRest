package com.example.demo.services;

import com.example.demo.dtos.CiudadDto;
import com.example.demo.entities.Ciudad;
import com.example.demo.mappers.CiudadMapper;
import com.example.demo.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CiudadService {
    private final CiudadRepository ciudadRepository;
    private final CiudadMapper ciudadMapper;

    @Autowired
    public CiudadService(CiudadRepository ciudadRepository, CiudadMapper ciudadMapper) {
        this.ciudadRepository = ciudadRepository;
        this.ciudadMapper = ciudadMapper;
    }

    /**
     * Obtiene una lista de ciudades
     *
     * @return Lista de ciudades
     */
    @Transactional(readOnly = true)
    public List<CiudadDto> obtenerTodasLasCiudades() {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        return ciudadMapper.ListModelToDto(ciudades);
    }
}
