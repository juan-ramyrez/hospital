package com.hospital.controller;


import com.hospital.controller.request.HistoriaClinicaRequest;
import com.hospital.controller.response.HistoriaClinicaResponse;
import com.hospital.entitys.HistoriaClinica;
import com.hospital.services.HistoriaClinicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Permite que las apps usen la lógica de la app
@RequestMapping("historiaClinica/v1") //Ruta base de los demás métodos. "v1" es la versión 1 de la API
@RequiredArgsConstructor //Crear constructores pero en tiempo de ejecución

public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    @GetMapping("/list") //Trae la lista que se crea abajo
    public ResponseEntity<List<HistoriaClinica>> listHistoriaClinicaApi(){
        List<HistoriaClinica> historiaClinicaList = historiaClinicaService.getListHistoriasClinicas();
        return new ResponseEntity<>(historiaClinicaList, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete") //Trae la lista que se crea abajo
    public ResponseEntity<String> deleteHistoriaClinicaApi(@RequestParam(name = "id") Long id){
        historiaClinicaService.deleteHistorialClinico(id);
        return ResponseEntity.accepted().body("La acción solicitada se realizo");
    }

    @GetMapping("/search/{id}") //Trae la lista que se crea abajo
    public ResponseEntity<HistoriaClinicaResponse> searchHistoriaClinicaApi(@PathVariable Long id){
        HistoriaClinicaResponse historiaClinicaResponse = historiaClinicaService.searchHistorialClinico(id);
        return ResponseEntity.accepted().body(historiaClinicaResponse);
    }

    @PostMapping("/save") //Trae la lista que se crea abajo
    public ResponseEntity<String> saveHistoriaClinicaApi(@RequestBody HistoriaClinicaRequest historiaClinicaRequest){//Enviara un objeto
        historiaClinicaService.saveHistorialClinico(historiaClinicaRequest);
        return ResponseEntity.accepted().body("La acción solicitada se realizo");
    }

    @PostMapping("/update") //Trae la lista que se crea abajo
    public ResponseEntity<String> updateHistoriaClinicaApi(@RequestBody HistoriaClinicaRequest historiaClinicaRequest){
        historiaClinicaService.updateHistorialClinico(historiaClinicaRequest);
        return ResponseEntity.accepted().body("La acción solicitada se realizo");
    }
}
