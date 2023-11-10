package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ciudad", schema = "juegosolimpicos")
public class Ciudad {
    @Id
    @Column(name = "id_ciudad")
    private Integer idCiudad;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    // Esta columna se refiere a la clave foránea en la tabla ciudad
    private Pais pais;

    @Column(name = "valor_ciudad")
    private Integer valorCiudad;
}