package com.example.demo.services;

import com.example.demo.entity.ConsultaEntity;
import com.example.demo.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<ConsultaEntity> realizarConsulta() {
        return consultaRepository.realizarConsulta();
    }
}
