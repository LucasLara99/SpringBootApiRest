package com.example.demo.models;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "ConsultaDTO",
        classes = {
                @ConstructorResult(
                        targetClass = ConsultaDTO.class,
                        columns = {
                                @ColumnResult(name = "id_pais", type = Long.class),
                                @ColumnResult(name = "nombre_pais", type = String.class),
                                @ColumnResult(name = "id_ciudad", type = Long.class),
                                @ColumnResult(name = "nombre_ciudad", type = String.class),
                                @ColumnResult(name = "valor", type = Integer.class),
                                @ColumnResult(name = "descripcion_tipo_jjoo", type = String.class),
                                @ColumnResult(name = "numero_veces_sede", type = Long.class)
                        }
                )
        }
)
public class ConsultaDTO {
    private Long id_pais;
    private String nombre_pais;
    private Long id_ciudad;
    private String nombre_ciudad;
    private Integer valor;
    private String descripcion_tipo_jjoo;
    private Long numero_veces_sede;
}
