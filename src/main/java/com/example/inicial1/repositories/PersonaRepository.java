package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Esta interface permite separar la logica de negocio de la logica de la base de datos
//se deben crear los servicios que se van a comunicar conlos repositorios
@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

    List<Persona> findByNombreContainingOrApellidoContaining (String nombre, String apellido);

    //consultas
    //QUERY USANDO JPQL
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%" )
    List<Persona> search (@Param("filtro") String filtro);

    @Query( //QUERY USANDO SQL
            value = "SELECT * FROM Persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo (@Param("filtro") String filtro);



    //CONSULTAS - PAGINACION
    Page<Persona> findByNombreContainingOrApellidoContaining (String nombre, String apellido, Pageable pageable);

    //consultas
    //QUERY USANDO JPQL
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%" )
    Page<Persona> search (@Param("filtro") String filtro, Pageable pageable);

    @Query( //QUERY USANDO SQL
            value = "SELECT * FROM Persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count (*) FROM Persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo (@Param("filtro") String filtro, Pageable pageable);


}