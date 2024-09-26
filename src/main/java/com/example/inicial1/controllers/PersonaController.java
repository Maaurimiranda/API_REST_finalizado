package com.example.inicial1.controllers;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin (origins = "*")//permite el acceso a la API desde distintos clientes
@RequestMapping(path = "/api/v1/personas") //desde esta URl vamos a poder acceder a los metodos de persona
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{
    //CONTROLADOR GENERICO
    //YA NO ES NECESARIO DECLARAR TODOS LOS METODOS CRUD POR LA IMPLEMENTACION DE BASECONTROLLERIMPL
    //ACA SE IMPLEMENTAN LOS METODOS PERSONALIZADOS DE LA CLASE PERSONA

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ \"error\": \"" + e.getMessage() + "\" }");
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ \"error\": \"" + e.getMessage() + "\" }");
        }
    }

}











