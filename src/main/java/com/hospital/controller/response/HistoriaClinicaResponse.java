package com.hospital.controller.response;

import lombok.*;

import java.sql.Date;

@Builder //Ayuda para construir un objeto sin generar una instancia
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HistoriaClinicaResponse {

    private Long id;
    private Long fk_persona;
    private Long fk_profesional;
    private DiagnosticosResponse diagnosticosResponse;
    private CentroAtencionResponse centroAtencionResponse;
    private Date fecha_creacion;
    private Boolean estado_sistema;
    private PersonaResponse personaResponse;
}
