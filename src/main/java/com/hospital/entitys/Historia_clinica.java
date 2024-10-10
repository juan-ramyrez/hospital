package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "historia_clinica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Historia_clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "fk_persona")
    private Integer fk_persona;

    @Column(name = "fk_profesional")
    private Integer fk_profesional;

    @Column(name = "fk_diagnostico")
    private Integer fk_diagnostico;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "fk_centro_atencion")
    private Integer fk_centro_atencion;

    @Column(name = "estado_sistema")
    private Boolean estado_sistema;

}
