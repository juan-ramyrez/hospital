package com.hospital.controller.request;

import lombok.*;

@Builder //Ayuda para construir un objeto sin generar una instancia
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaRequest {

    private Long id;
    private String nombre;
    private String apellido;
    private Long fk_tipo_documento;
}
