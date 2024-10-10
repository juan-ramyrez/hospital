package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tipo_documentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tipo_documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "descripcion")
    private String descripcion;

}
