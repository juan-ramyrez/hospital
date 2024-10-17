package com.hospital.entitys.repository;

import com.hospital.entitys.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Long> {

    @Query(value = "SELECT * FROM personas", nativeQuery = true) //Pasa el valor de la query de SQL
    List<Persona> listPersons();

    @Query(value = "SELECT * FROM personas WHERE id=:id", nativeQuery = true) //Pasa el valor de la query de SQL por el ID
    Persona searchPerson(@Param(value = "id") Long id);
}
