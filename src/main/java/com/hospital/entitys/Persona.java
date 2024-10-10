package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "apellidos")
    private String apellido;

    @ManyToOne //En este caso muchas "personas" a uno "ID"
    @JoinColumn(name = "fk_tipo_documento", referencedColumnName = "id") //Él se va a relacionar con la columna en comillas
    private Tipo_documentos fk_tipo_documento; //Nombre de la variable en Java

}
