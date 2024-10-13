package com.hospital.controller.response;


import com.hospital.entitys.TipoDocumento;
import lombok.*;

@Builder //Ayuda para construir un objeto sin generar una instancia
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumentoResponse {

    private Long id;
    private String sigla;
    private String descripcion;
}
