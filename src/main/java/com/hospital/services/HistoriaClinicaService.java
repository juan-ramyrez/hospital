package com.hospital.services;

import com.hospital.controller.request.HistoriaClinicaRequest;
import com.hospital.controller.response.HistoriaClinicaResponse;
import com.hospital.entitys.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaService {

    List<HistoriaClinica> getListHistoriasClinicas();
    void deleteHistorialClinico(Long id);
    HistoriaClinicaResponse searchHistorialClinico(Long id);
    void saveHistorialClinico(HistoriaClinicaRequest historiaClinicaRequest);
    void updateHistorialClinico(HistoriaClinicaRequest historiaClinicaRequest);
}

