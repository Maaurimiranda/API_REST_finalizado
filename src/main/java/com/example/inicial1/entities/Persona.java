package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Persona")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Persona extends Base {

    @Column (name = "Nombre")
    private String nombre;
    @Column (name = "Apellido")
    private String apellido;
    @Column (name = "DNI", unique = true)
    private int dni;

    //RELACIONES
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Domicilio")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //al eliminar una persona, se eliminan todos los libros que le pertenencen
    @JoinTable(name = "Persona_Libro",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro>libros = new ArrayList<Libro>();

}

