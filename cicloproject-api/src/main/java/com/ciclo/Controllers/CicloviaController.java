package com.ciclo.Controllers;

import com.ciclo.Dto.CicloviaDto;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Services.CicloviaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ciclovia")
public class CicloviaController {
    private CicloviaService cicloviaService;
    public CicloviaController(CicloviaService cicloviaService) {
        this.cicloviaService = cicloviaService;
    }

    @PostMapping
    public ResponseEntity<Ciclovia> createCiclovia(@RequestBody CicloviaDto ciclovia){
        Ciclovia cicloviaCreated = cicloviaService.createCiclovia(ciclovia);
        return new ResponseEntity<>(cicloviaCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{cicloviaId}/calificacion")
    public ResponseEntity<Float> getCalificacionById(@PathVariable Long cicloviaId){
        Float calificacion = cicloviaService.getCalificacionById(cicloviaId);
        return new ResponseEntity<>(calificacion, HttpStatus.OK);
    }

    @PutMapping("calificacion")
    public ResponseEntity<String> updateCalificacion(@RequestParam Long cicloviaId, @RequestParam Float calificacion){
        String response = cicloviaService.updateCalificacionCiclovia(cicloviaId, calificacion);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
