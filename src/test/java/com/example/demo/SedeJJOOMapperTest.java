package com.example.demo;

import com.example.demo.dtos.SedeJJOODto;
import com.example.demo.entities.Ciudad;
import com.example.demo.entities.SedeJJOO;
import com.example.demo.entities.SedeJJOOKey;
import com.example.demo.entities.TipoJJOO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.demo.mappers.SedeJJOOMapper;

public class SedeJJOOMapperTest {

    private final SedeJJOOMapper mapper = SedeJJOOMapper.INSTANCE; // Así puedes acceder a tu instancia de mapper

    @Test
    public void sedeJJOOMapperTest() {
        // Crea una instancia de SedeJJOO con datos de prueba
        SedeJJOO sedeJJOO = new SedeJJOO();
        sedeJJOO.setId(new SedeJJOOKey(2023, 1));
        TipoJJOO tipoJJOO = new TipoJJOO();
        tipoJJOO.setDescripcionTipo("INVIERNO");
        sedeJJOO.setTipoJJOO(tipoJJOO);
        Ciudad ciudad = new Ciudad();
        ciudad.setNombreCiudad("TURIN");
        sedeJJOO.setSede(ciudad);

        // Mapea la entidad a un DTO
        SedeJJOODto sedeJJOODto = mapper.ModelToDto(sedeJJOO);

        // Realiza las aserciones
        assertEquals(sedeJJOO.getId().getAño(), sedeJJOODto.getAño());
        assertEquals(sedeJJOO.getTipoJJOO().getDescripcionTipo(), sedeJJOODto.getDescription());
        assertEquals(sedeJJOO.getSede().getNombreCiudad(), sedeJJOODto.getNombreCiudad());
    }
}

