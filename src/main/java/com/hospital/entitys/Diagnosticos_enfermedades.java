package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "diagnostico_enfermedades")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Diagnosticos_enfermedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "fk_diagnostico")
    private Integer fk_diagnostico;

    @Column(name = "fk_enfermedades")
    private Integer fk_enfermedades;

}
