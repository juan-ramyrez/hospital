package com.hospital.controller.response;

import lombok.*;

import java.sql.Date;

@Builder //Ayuda para construir un objeto sin generar una instancia
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DiagnosticosResponse {

    private Long id;
    private String descripcion_diagnostico;
    private String enfermedades;
    private Date fecha_creacion;
    private Date fecha_actualizacion;
}

