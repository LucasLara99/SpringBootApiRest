package com.example.demo.mappers;

import com.example.demo.dtos.CrearSedeJJOODto;
import com.example.demo.dtos.SedeJJOODto;
import com.example.demo.entities.SedeJJOO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SedeJJOOMapper {
    @Mappings({
            @Mapping(source = "id.año", target = "año"),
            @Mapping(source = "tipoJJOO.descripcionTipo", target = "description"),
            @Mapping(source = "sede.idCiudad", target = "idCiudad"),
            @Mapping(source = "sede.nombreCiudad", target = "nombreCiudad")
    })
    SedeJJOODto ModelToDto(SedeJJOO sedeJJOO);

    @Mappings({
            @Mapping(source = "año", target = "id.año"),
            @Mapping(source = "id_tipo_jjoo", target = "tipoJJOO.id_tipo_jjoo"),
            @Mapping(source = "idCiudad", target = "sede.idCiudad"),
    })
    SedeJJOO DtoToModel(CrearSedeJJOODto crearSedeJJOODto);

    @Mappings({
            @Mapping(source = "idCiudad", target = "sede.idCiudad"),
    })
    SedeJJOO UpdateDtoToModel(SedeJJOODto sedeJJOODto);

    List<SedeJJOODto> ListaModelToDto(List<SedeJJOO> sedes);
}
