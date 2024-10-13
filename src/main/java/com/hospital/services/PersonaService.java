package com.hospital.services;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> getListPerson();
    void deletePerson(Long id);
    PersonaResponse searchPerson(Long id);
    void savePerson(PersonaRequest personaRequest);
    void updatePerson(PersonaRequest personaRequest);
}
