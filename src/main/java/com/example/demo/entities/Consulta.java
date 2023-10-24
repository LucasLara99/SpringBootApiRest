package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Consulta {
    @Id
    private Long id_pais;
    private String nombre_pais;
    private Long id_ciudad;
    private String nombre_ciudad;
    private Integer valor;
    private String descripcion_tipo_jjoo;
    private Long numero_veces_sede;
}
