package com.example.demo.repositories;

import com.example.demo.entities.SedeJJOO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeJJOORepository extends JpaRepository<SedeJJOO, Integer> {
    //Aquí se accede a las operaciones CRUD estándar proporcionadas por JpaRepository (save, findById, etc.)
}
