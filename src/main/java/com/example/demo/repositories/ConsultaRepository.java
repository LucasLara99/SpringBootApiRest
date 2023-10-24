package com.example.demo.repositories;

import com.example.demo.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query(value = "SELECT " +
            "P.id_pais AS id_pais, " +
            "P.nombre_pais AS nombre_pais, " +
            "C.id_ciudad AS id_ciudad, " +
            "C.nombre_ciudad AS nombre_ciudad, " +
            "COALESCE(C.valor_ciudad, P.valor_pais) AS valor, " +
            "TJ.descripcion_tipo AS descripcion_tipo_jjoo, " +
            "COUNT(SJ.año) AS numero_veces_sede " +
            "FROM pais AS P " +
            "LEFT JOIN ciudad AS C ON P.id_pais = C.id_pais " +
            "LEFT JOIN sede_jjoo AS SJ ON C.id_ciudad = SJ.sede " +
            "LEFT JOIN tipo_jjoo AS TJ ON SJ.id_tipo_jjoo = TJ.id_tipo_jjoo " +
            "GROUP BY P.id_pais, C.id_ciudad, TJ.descripcion_tipo", nativeQuery = true)
    List<Consulta> realizarConsulta();
}