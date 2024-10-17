package com.hospital.services.service;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.controller.response.TipoDocumentoResponse;
import com.hospital.controller.response.TipoPersonasResponse;
import com.hospital.entitys.Persona;
import com.hospital.entitys.TipoDocumento;
import com.hospital.entitys.TipoPersonas;
import com.hospital.entitys.repository.PersonaRepository;
import com.hospital.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //Validar que la app está bien creada. También se usa "@Component"
@RequiredArgsConstructor

public class PersonaServiceImplement implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public List<Persona> getListPerson() {
        var listPersons = personaRepository.listPersons();
        return listPersons;
    }

    @Override
    public void deletePerson(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public PersonaResponse searchPerson(Long id) {
        Persona persona = personaRepository.searchPerson(id);
        return Objects.nonNull(persona) ?
                buildPersonResponse(persona) :
                PersonaResponse.builder().build();
        //IF corto= "?" significa si da True. ":" significa que si da false
    }

    @Override
    public void savePerson(PersonaRequest personaRequest) {
        Persona persona = new Persona();
        TipoDocumento tipodocumento = new TipoDocumento();
        TipoPersonas tipopersonas = new TipoPersonas();

        if(Objects.nonNull(personaRequest)){
            tipodocumento.setId(personaRequest.getFk_tipo_documento());
            tipopersonas.setId(personaRequest.getFk_tipo_persona());
            persona.setApellido(personaRequest.getApellido());
            persona.setNombre(personaRequest.getNombre());
            persona.setFk_tipo_documento(tipodocumento);

            personaRepository.save(persona);
        }
    }

    @Override
    public void updatePerson(PersonaRequest personaRequest) {

        if(Objects.nonNull(personaRequest)){
            Optional<Persona> persona = personaRepository.findById(personaRequest.getId());
            // "Optional" nos indica que puede haber un dato o no (true or false)
            if(persona.isPresent()){
                // Con este IF se guarda la persona en dado caso que el OPTIONAL sea true
                Persona personaActualizar = buildPersonaEntity(personaRequest);
                personaRepository.save(personaActualizar);
            }else{
                // Con este ELSE se crea la persona en dado caso que el OPTIONAL sea false
                Persona personaGuardar = buildPersonaEntity(personaRequest);
                personaRepository.save(personaGuardar);
            }
        }
    }

    private static Persona buildPersonaEntity(PersonaRequest personaRequest) {
        return Persona.builder()
                .id(personaRequest.getId())
                .apellido(personaRequest.getApellido())
                .nombre(personaRequest.getNombre())
                .fk_tipo_documento(buildTipoDocumentoEntity(personaRequest))
                .fk_tipo_persona(buildTipoPersonasEntity(personaRequest))
                .build();
    }

    private static TipoDocumento buildTipoDocumentoEntity(PersonaRequest personaRequest) {
        return TipoDocumento.builder()
                .id(personaRequest.getFk_tipo_documento())
                .build();
    }

    private static TipoPersonas buildTipoPersonasEntity(PersonaRequest personaRequest) {
        return TipoPersonas.builder()
                .id(personaRequest.getFk_tipo_persona())
                .build();
    }

    private static PersonaResponse buildPersonResponse(Persona persona) {
        return PersonaResponse.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())

                .tipoDocumentoResponse(buildTipoDocumentoResponse(persona.getFk_tipo_documento()))
                .tipoPersonasResponse(buildTipoPersonasResponse(persona.getFk_tipo_persona()))

                .build();
    }

    private static TipoDocumentoResponse buildTipoDocumentoResponse(TipoDocumento tipoDocumento){
        return TipoDocumentoResponse.builder()
                .id(tipoDocumento.getId())
                .sigla(tipoDocumento.getSigla())
                .descripcion(tipoDocumento.getDescripcion())
                .build();
    }

    private static TipoPersonasResponse buildTipoPersonasResponse(TipoPersonas tipoPersonas){
        return TipoPersonasResponse.builder()
                .id(tipoPersonas.getId())
                .titulo(tipoPersonas.getTitulo())
                .descripcion(tipoPersonas.getDescripcion())
                .build();
    }
}
