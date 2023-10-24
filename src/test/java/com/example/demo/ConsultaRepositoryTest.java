package com.example.demo;
import com.example.demo.entities.Consulta;
import com.example.demo.repositories.ConsultaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ConsultaRepositoryTest {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Test
    public void testRealizarConsulta() {
        // Primer se ejecuta la consulta
        List<Consulta> resultados = consultaRepository.realizarConsulta();

        // Realizamos afirmaciones (assertions) sobre los resultados
        // Por ejemplo, verificar que se hayan obtenido resultados
        assertNotEquals(0, resultados.size());

        // Afirmaciones sobre los datos que se esperan
        // En este caso verificar que el primer resultado tenga ciertos valores
        Consulta primerResultado = resultados.get(0);
        assertEquals(1L, primerResultado.getId_pais());
        assertEquals("ESPAÑA", primerResultado.getNombre_pais());
    }
}
