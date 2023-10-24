package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "pais", schema = "juegosolimpicos")
public class Pais {
    @Id
    @Column(name = "id_pais")
    private Integer idPais;

    @Column(name = "nombre_pais")
    private String nombrePais;

    @Column(name = "codigo_pais")
    private String codigoPais;

    @Column(name = "valor_pais")
    private Integer valorPais;
}

