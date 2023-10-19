package com.example.demo.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JuegosOlimpicos {

    @PersistenceContext
    private EntityManager entityManager; // Permite ejecutar consultas SQL nativas en la base de datos.

    public List<ResultadoConsulta> realizarConsulta() {
        String sql = "SELECT " +
                "    P.id_pais AS id_pais, " +
                "    P.nombre_pais AS nombre_pais, " +
                "    C.id_ciudad AS id_ciudad, " +
                "    C.nombre_ciudad AS nombre_ciudad, " +
                "    COALESCE(C.valor_ciudad, P.valor_pais) AS valor, " +
                "    TJ.descripcion_tipo AS descripción_tipo_jjoo, " +
                "    COUNT(SJ.año) AS número_veces_sede " +
                "FROM pais AS P " +
                "LEFT JOIN ciudad AS C ON P.id_pais = C.id_pais " +
                "LEFT JOIN sede_jjoo AS SJ ON C.id_ciudad = SJ.sede " +
                "LEFT JOIN tipo_jjoo AS TJ ON SJ.id_tipo_jjoo = TJ.id_tipo_jjoo " +
                "GROUP BY P.id_pais, C.id_ciudad";

        Query query = entityManager.createNativeQuery(sql, "ResultadoConsultaMapping");
        return query.getResultList();
    }
}