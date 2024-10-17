package com.hospital.controller.response;

import lombok.*;

@Builder //Ayuda para construir un objeto sin generar una instancia
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CentroAtencionResponse {

    private Long id;
    private String nit;
    private String razon_social;
    private Boolean estado_sistema;
}
