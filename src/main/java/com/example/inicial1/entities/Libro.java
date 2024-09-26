package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = "Libro")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Libro extends Base {

    @Column(name = "Fecha")
    private int fecha;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Paginas")
    private int paginas;
    @Column(name = "Titulo")
    private String titulo;

    //RELACIONES
    @ManyToMany(cascade = CascadeType.REFRESH) //refresh actualiza los autores al momento de persistir un libro
    //si ocurrio un cambio en un autor, se va a actualizar para libros
    @JoinTable()
    private List<Autor> autores;

}
