package com.ciclo.Controllers;

import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CicloviaRequestDto;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Services.CicloviaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<Ciclovia> createCiclovia(@RequestBody CicloviaRequestDto ciclovia){
        Ciclovia cicloviaCreated = cicloviaService.createCiclovia(ciclovia);
        return new ResponseEntity<>(cicloviaCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{cicloviaId}")
    public ResponseEntity<Ciclovia> getCicloviaById(@PathVariable Long cicloviaId){
        Ciclovia ciclovia = cicloviaService.getCicloviaById(cicloviaId);
        return new ResponseEntity<>(ciclovia, HttpStatus.OK);
    }

    @PutMapping("/{cicloviaId}/{calificacionId}")
    public ResponseEntity<Calificacion> getCalificacionxCicloviaId(@PathVariable Long cicloviaId, @PathVariable Long calificacionId){
        Calificacion calificacion = cicloviaService.getCalificacionxCicloviaId(cicloviaId, calificacionId);
        return new ResponseEntity<>(calificacion, HttpStatus.OK);
    }

    @GetMapping("/{cicloviaId}/calificacionPromedio")
    public ResponseEntity<Float> getCalificacionPromedioById(@PathVariable Long cicloviaId){
        float calificacion = cicloviaService.getAverageCalificacionById(cicloviaId);
        return new ResponseEntity<>(calificacion, HttpStatus.OK);
    }

    @GetMapping("/{cicloviaId}/calificaciones")
    public ResponseEntity<List<Calificacion>> getCalificacionesById(@PathVariable Long cicloviaId){
        List<Calificacion> calificacion = cicloviaService.getCalificacionesById(cicloviaId);
        return new ResponseEntity<>(calificacion, HttpStatus.OK);
    }
    
    @PutMapping("/{cicloviaId}/calificaciones")
    public ResponseEntity<Calificacion> createCalificacion(@PathVariable Long cicloviaId, @RequestBody CalificacionRequestDto calificacion){
        Calificacion calificacionCreated = cicloviaService.createCalificacion(cicloviaId, calificacion);
        return new ResponseEntity<>(calificacionCreated, HttpStatus.CREATED);
    }
}
