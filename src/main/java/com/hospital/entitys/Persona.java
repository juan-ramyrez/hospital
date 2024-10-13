package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "apellidos")
    private String apellido;

    @ManyToOne //En este caso muchas "personas" a un "ID"
    @JoinColumn(name = "fk_tipo_documento", referencedColumnName = "id") //Él se va a relacionar con la columna en comillas
    private TipoDocumento fk_tipo_documento; //Nombre de la variable en Java

}
