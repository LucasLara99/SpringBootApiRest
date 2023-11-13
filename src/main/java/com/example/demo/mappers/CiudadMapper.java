package com.example.demo.mappers;

import com.example.demo.dtos.CiudadDto;
import com.example.demo.entities.Ciudad;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CiudadMapper {
    List<CiudadDto> ListModelToDto(List<Ciudad> ciudades);
}
