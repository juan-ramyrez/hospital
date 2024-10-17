package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="centro_atencion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CentrosAtencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name= "id")
    private Long id;

    @Column(name= "nit")
    private String nit;

    @Column(name= "razon_social")
    private String razon_social;

    @Column(name= "estado_sistema")
    private Boolean estado_sistema;

}
