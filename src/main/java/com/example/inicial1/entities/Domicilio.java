package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "Domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Domicilio extends Base {

    @Column (name = "Calle")
    private String calle;
    @Column (name = "Numero")
    private int numero;

    //RELACIONES
    @ManyToOne(optional = false) //esta relacion no puede ser opcional/nula
    @JoinColumn(name = "fk_Localidad")
    private Localidad localidad;
}
