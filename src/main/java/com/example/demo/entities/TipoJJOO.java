package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tipo_jjoo", schema = "juegosolimpicos")
public class TipoJJOO {
    @Id
    @Column(name = "id_tipo_jjoo")
    private Integer id_tipo_jjoo;

    @Column(name = "descripcion_tipo")
    private String descripcionTipo;
}

