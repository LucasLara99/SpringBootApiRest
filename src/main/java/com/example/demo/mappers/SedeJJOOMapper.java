package com.example.demo.mappers;

import com.example.demo.dtos.SedeJJOODto;
import com.example.demo.entities.SedeJJOO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SedeJJOOMapper {
    SedeJJOOMapper INSTANCE = Mappers.getMapper(SedeJJOOMapper.class);

    @Mappings({
            @Mapping(source = "id.año", target = "año"),
            @Mapping(source = "tipoJJOO.descripcionTipo", target = "description"),
            @Mapping(source = "sede.nombreCiudad", target = "nombreCiudad")
    })
    SedeJJOODto ModelToDto(SedeJJOO sedeJJOO);
}

