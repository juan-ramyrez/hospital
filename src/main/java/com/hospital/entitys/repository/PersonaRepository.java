package com.hospital.entitys.repository;

import com.hospital.entitys.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Long> {

    @Query(value = "SELECT * FROM personas", nativeQuery = true) //Pasa el valor de la query de SQL
    List<Persona> listPersons();

    @Override //Sobreescribir
    List<Persona> findAll(); //"Findall para buscar toodo lo de la tabla
}
