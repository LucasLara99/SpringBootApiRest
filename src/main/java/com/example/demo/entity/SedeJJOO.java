package com.example.demo.entity;

import com.example.demo.models.ConsultaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

@Entity
@Getter
@Setter
@Table(name = "sede_jjoo")
public class SedeJJOO {
    @Id
    int año;
    @Id
    int id_tipo_jjoo;
    int sede;


}
