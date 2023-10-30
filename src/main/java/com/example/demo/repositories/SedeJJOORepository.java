package com.example.demo.repositories;

import com.example.demo.entities.SedeJJOO;
import com.example.demo.entities.SedeJJOOKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeJJOORepository extends JpaRepository<SedeJJOO, SedeJJOOKey> {
    //Aquí se accede a las operaciones CRUD estándar proporcionadas por JpaRepository (save, findById, etc.)

    //Definimos un método para buscar por ambas claves primarias, año y tipoJJOO.
}
