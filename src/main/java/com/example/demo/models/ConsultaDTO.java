package com.example.demo.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor(access= AccessLevel.PUBLIC)
public class ConsultaDTO {
    @Setter
    private Long id_pais;
    @Setter
    private String nombre_pais;
    @Setter
    private Long id_ciudad;
    @Setter
    private String nombre_ciudad;
    @Setter
    private Integer valor;
    @Setter
    private String descripcion_tipo_jjoo;
    @Setter
    private Long numero_veces_sede;
}
