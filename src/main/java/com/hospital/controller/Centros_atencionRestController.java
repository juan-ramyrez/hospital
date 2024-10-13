package com.hospital.controller;

import com.hospital.entitys.Centros_atencion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Permite que las apps usen la lógica de la app
@RequestMapping(name= "v1/centroAtencion")
@RequiredArgsConstructor
public class Centros_atencionRestController {

   /** private final CentrosAtencionService centrosAtencionService;

    @GetMapping(name = "/list")
    public ResponseEntity<List<Centros_atencion>> listCentrosAtencionApi(){
        List<Centros_atencion> centrosAtencionList = centrosAtencionService.getListCentroAtencion();
        return new ResponseEntity<>(centrosAtencionList, HttpStatus.ACCEPTED);
    }**/
}