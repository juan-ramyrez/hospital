package com.hospital.controller;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Persona;
import com.hospital.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Permite que las apps usen la lógica de la app
@RequestMapping("persona/v1") //Ruta base de los demás métodos. "v1" es la versión 1 de la API
@RequiredArgsConstructor //Crear constructores pero en tiempo de ejecución

public class PersonaRestController {

    private final PersonaService personaService;

    @GetMapping("/list") //Trae la lista que se crea abajo
    public ResponseEntity<List<Persona>> listPersonsApi(){
        List<Persona> personaList = personaService.getListPerson();
        return new ResponseEntity<>(personaList, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePersonsApi(@RequestParam(name = "id") Long id){
        personaService.deletePerson(id);
        return ResponseEntity.accepted().body("La acción solicitada se realizo");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<PersonaResponse> searchPersonsApi(@PathVariable Long id){
        PersonaResponse personaResponse = personaService.searchPerson(id);
        return ResponseEntity.accepted().body(personaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePersonsApi(@RequestBody PersonaRequest personaRequest){//Enviara un objeto
        personaService.savePerson(personaRequest);
        return ResponseEntity.accepted().body("La acción solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePersonsApi(@RequestBody PersonaRequest personaRequest){
        personaService.updatePerson(personaRequest);
        return ResponseEntity.accepted().body("La acción solicitada se realizo");
    }
}
