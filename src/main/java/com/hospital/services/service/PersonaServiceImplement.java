package com.hospital.services.service;

import com.hospital.entitys.Persona;
import com.hospital.entitys.repoRepository;
import com.hospital.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Validar que la app está bien creada. También se usa "@Component"
@RequiredArgsConstructor
public class PersonaServiceImplement implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public List<Persona> getListPerson() {
        var listPersons = personaRepository.listPersons();
        return listPersons;
    }
}
