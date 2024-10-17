package com.hospital.services.service;

import com.hospital.controller.request.HistoriaClinicaRequest;
import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.*;
import com.hospital.entitys.*;
import com.hospital.entitys.repository.HistoriaClinicaRepository;
import com.hospital.services.HistoriaClinicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //Validar que la app está bien creada. También se usa "@Component"
@RequiredArgsConstructor

public class HistoriaClinicaServiceImplement implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public List<HistoriaClinica> getListHistoriasClinicas() {
        var listHistoriasClinicas = historiaClinicaRepository.listHistoriasClinicas();
        return listHistoriasClinicas;
    }

    @Override
    public void deleteHistorialClinico(Long id) {
        historiaClinicaRepository.deleteById(id);
    }

    @Override
    public HistoriaClinicaResponse searchHistorialClinico(Long id) {
        HistoriaClinica historiaClinica = historiaClinicaRepository.searchHistoriaClinica(id);
        return Objects.nonNull(historiaClinica) ?
                buildHistoriaClinicaResponse(historiaClinica) :
                HistoriaClinicaResponse.builder().build();
        //IF corto= "?" significa si da True. ":" significa que si da false
    }

    @Override
    public void saveHistorialClinico(HistoriaClinicaRequest historiaClinicaRequest) {
        HistoriaClinica historiaClinica = new HistoriaClinica();
        CentrosAtencion centrosatencion = new CentrosAtencion();
        Diagnosticos diagnosticos = new Diagnosticos();
        Persona persona = new Persona();

        if(Objects.nonNull(historiaClinicaRequest)){
            persona.setId(historiaClinicaRequest.getFk_persona());
            persona.setId(historiaClinicaRequest.getFk_profesional());
            centrosatencion.setId(historiaClinicaRequest.getFk_diagnostico());
            historiaClinica.setFecha_creacion(Date.valueOf(String.valueOf(historiaClinicaRequest.getFecha_creacion())));
            diagnosticos.setId(historiaClinicaRequest.getFk_centro_atencion());
            historiaClinica.setEstado_sistema(historiaClinicaRequest.getEstado_sistema());

            historiaClinicaRepository.save(historiaClinica);
        }
    }

    @Override
    public void updateHistorialClinico(HistoriaClinicaRequest historiaClinicaRequest) {

        if(Objects.nonNull(historiaClinicaRequest)){
            Optional<HistoriaClinica> historiaClinica = historiaClinicaRepository.findById(historiaClinicaRequest.getId());
            // "Optional" nos indica que puede haber un dato o no (true or false)
            if(historiaClinica.isPresent()){
                // Con este IF se guarda la persona en dado caso que el OPTIONAL sea true
                HistoriaClinica historiaClinicaActualizar = buildHistoriaClinicaEntity(historiaClinicaRequest);
                historiaClinicaRepository.save(historiaClinicaActualizar);
            }else{
                // Con este ELSE se crea la persona en dado caso que el OPTIONAL sea false
                HistoriaClinica historiaClinicaGuardar = buildHistoriaClinicaEntity(historiaClinicaRequest);
                historiaClinicaRepository.save(historiaClinicaGuardar);
            }
        }
    }

    private static HistoriaClinica buildHistoriaClinicaEntity(HistoriaClinicaRequest historiaClinicaRequest) {
        return HistoriaClinica.builder()
                .id(historiaClinicaRequest.getId())
                .fk_persona(buildPersonaEntity(historiaClinicaRequest))
                .fk_profesional(buildProfesionalEntity(historiaClinicaRequest))

                .fk_diagnostico(buildDiagnosticosEntity(historiaClinicaRequest))
                .fk_centro_atencion(buildCentrosAtencionEntity(historiaClinicaRequest))

                .fecha_creacion(Date.valueOf(String.valueOf(historiaClinicaRequest.getFecha_creacion())))
                .estado_sistema(historiaClinicaRequest.getEstado_sistema())
                .build();
    }

    private static Persona buildPersonaEntity(HistoriaClinicaRequest historiaClinicaRequest) {
        return Persona.builder()
                .id(historiaClinicaRequest.getFk_persona())
                .build();
    }

    private static Persona buildProfesionalEntity(HistoriaClinicaRequest historiaClinicaRequest) {
        return Persona.builder()
                .id(historiaClinicaRequest.getFk_profesional())
                .build();
    }

    private static Diagnosticos buildDiagnosticosEntity(HistoriaClinicaRequest historiaClinicaRequest) {
        return Diagnosticos.builder()
                .id(historiaClinicaRequest.getFk_diagnostico())
                .build();
    }

    private static CentrosAtencion buildCentrosAtencionEntity(HistoriaClinicaRequest historiaClinicaRequest) {
        return CentrosAtencion.builder()
                .id(historiaClinicaRequest.getFk_centro_atencion())
                .build();
    }

    private static HistoriaClinicaResponse buildHistoriaClinicaResponse(HistoriaClinica historiaClinica) {
        return HistoriaClinicaResponse.builder()
                .id(historiaClinica.getId())
                .fecha_creacion(Date.valueOf(historiaClinica.getFecha_creacion().toLocalDate()))
                .estado_sistema(historiaClinica.getEstado_sistema())

                .personaResponse(buildPersonaResponse(historiaClinica.getFk_persona()))
                .personaResponse(buildProfesionalResponse(historiaClinica.getFk_profesional()))

                .diagnosticosResponse(buildDiagnosticosResponse(historiaClinica.getFk_diagnostico()))
                .centroAtencionResponse(buildCentrosAtencionResponse(historiaClinica.getFk_centro_atencion()))
                .build();
    }

    private static PersonaResponse buildPersonaResponse (Persona persona){
        return PersonaResponse.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())

                .tipoDocumentoResponse(buildTipoDocumentoResponse(persona.getFk_tipo_documento()))
                .tipoPersonasResponse(buildTipoPersonasResponse(persona.getFk_tipo_persona()))

                //Missing fk_tipo_documento
                //Missing fk_tipo_persona
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

    private static PersonaResponse buildProfesionalResponse (Persona persona){
        return PersonaResponse.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                //Missing fk_tipo_documento
                //Missing fk_tipo_persona
                .build();
    }

    private static DiagnosticosResponse buildDiagnosticosResponse(Diagnosticos diagnosticos){
        return DiagnosticosResponse.builder()
                .id(diagnosticos.getId())
                .descripcion_diagnostico(diagnosticos.getDescripcion_diagnostico())
                .enfermedades(diagnosticos.getEnfermedades())
                .fecha_creacion((Date) diagnosticos.getFecha_creacion())
                .fecha_actualizacion((Date) diagnosticos.getFecha_actualizacion())
                .build();
    }

    private static CentroAtencionResponse buildCentrosAtencionResponse(CentrosAtencion centrosAtencion){
        return CentroAtencionResponse.builder()
                .id(centrosAtencion.getId())
                .nit(centrosAtencion.getNit())
                .razon_social(centrosAtencion.getRazon_social())
                .estado_sistema(centrosAtencion.getEstado_sistema())
                .build();
    }
}

