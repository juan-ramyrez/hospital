package com.hospital.controller.response;

import lombok.*;

@Builder //Ayuda para construir un objeto sin generar una instancia
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private TipoDocumentoResponse tipoDocumentoResponse; //FOREIGN KEY
}
