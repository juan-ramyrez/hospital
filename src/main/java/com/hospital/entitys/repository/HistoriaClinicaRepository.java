package com.hospital.entitys.repository;

import com.hospital.entitys.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoriaClinicaRepository extends  JpaRepository<HistoriaClinica,Long> {

    @Query(value = "SELECT * FROM historia_clinica", nativeQuery = true) //Pasa el valor de la query de SQL
    List<HistoriaClinica> listHistoriasClinicas();

    @Query(value = "SELECT * FROM historia_clinica WHERE id=:id", nativeQuery = true) //Pasa el valor de la query de SQL por el ID
    HistoriaClinica searchHistoriaClinica(@Param(value = "id") Long id);
}