package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name = "sede_jjoo", schema = "juegosolimpicos")
public class SedeJJOO {
    @EmbeddedId
    private SedeJJOOKey id;

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "id_tipo_jjoo")
//    private TipoJJOO id_tipo_jjoo;

    @ManyToOne
    @JoinColumn(name = "sede", referencedColumnName = "id_ciudad")
    private Ciudad sede;
}

