package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "diagnosticos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Diagnosticos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion_diagnostico")
    private String descripcion_diagnostico;

    @Column(name = "fk_enfermedades")
    private String enfermedades;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "fecha_actualizacion")
    private Date fecha_actualizacion;

}
