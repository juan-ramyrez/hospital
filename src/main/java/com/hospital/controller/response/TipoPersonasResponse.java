package com.hospital.controller.response;

import lombok.*;

@Builder //Ayuda para construir un objeto sin generar una instancia
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TipoPersonasResponse {

    private Long id;
    private String titulo;
    private String descripcion;
}
