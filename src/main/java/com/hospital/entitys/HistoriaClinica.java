package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

import javax.tools.Diagnostic;
import java.sql.Date;

@Entity
@Table(name = "historia_clinica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_persona", referencedColumnName = "id")
    private Persona fk_persona; //Persona

    //@Column(name = "fk_persona")                  //WORKING WITHOUT FK
    //private Long fk_persona; //Persona

    @ManyToOne
    @JoinColumn(name = "fk_profesional", referencedColumnName = "id")
    private Persona fk_profesional; //Persona

    //@Column(name = "fk_profesional")              //WORKING WITHOUT FK
    //private Long fk_profesional; //Persona

    @ManyToOne
    @JoinColumn(name = "fk_diagnostico", referencedColumnName = "id")
    private Diagnosticos fk_diagnostico; //Diagnostico

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @ManyToOne
    @JoinColumn(name = "fk_centro_atencion", referencedColumnName = "id")
    private CentrosAtencion fk_centro_atencion; //CentroAtencion

    @Column(name = "estado_sistema")
    private Boolean estado_sistema;

}
