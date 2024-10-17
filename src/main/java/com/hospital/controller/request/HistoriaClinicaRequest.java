package com.hospital.controller.request;

import lombok.*;

import java.sql.Date;

@Builder //Ayuda para construir un objeto sin generar una instancia
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HistoriaClinicaRequest {

    private Long id;
    private Long fk_persona;
    private Long fk_profesional;
    private Long fk_diagnostico;
    private Date fecha_creacion;
    private Long fk_centro_atencion;
    private Boolean estado_sistema;
}
