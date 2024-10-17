package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TipoPersonas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

}
