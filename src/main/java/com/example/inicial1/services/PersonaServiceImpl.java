package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

//indicamos que esta clase es un servicio
@Service
public class PersonaServiceImpl extends BaseServiceImpl <Persona, Long> implements PersonaService {
    @Autowired
    private PersonaRepository personaRepositorio;

    public PersonaServiceImpl(BaseRepository <Persona, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try{
            //QUERY
            //List<Persona> personas = personaRepositorio.findByNombreContainingOrApellidoContaining (filtro, filtro);
            //QUERY JPQL
            //List<Persona> personas = personaRepositorio.search(filtro);
            //QUERY SQL - SEARCH NATIVO

            List<Persona> personas = personaRepositorio.searchNativo(filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Persona> personas = personaRepositorio.searchNativo(filtro, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}







