package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tipo_documentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "descripcion")
    private String descripcion;

}
