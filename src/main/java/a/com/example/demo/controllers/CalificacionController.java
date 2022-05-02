package a.com.example.demo.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import a.com.example.demo.dto.CalificacionResponse;
import a.com.example.demo.entities.Calificacion;
import a.com.example.demo.services.CalificacionService;
import a.com.example.demo.util.EntityDtoConverter2;


@RestController
@RequestMapping("/calificacion")
public class CalificacionController {
    private CalificacionService calificacionService;
    private EntityDtoConverter2 converter;

    public CalificacionController(CalificacionService calificacionService, EntityDtoConverter2 converter){
        this.calificacionService = calificacionService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<CalificacionResponse>> findBestParking() {
        List<Calificacion> calificacion = calificacionService.getBestParking();
        return new ResponseEntity<>(converter.convertEntityToDto2(calificacion), HttpStatus.OK);
    }
}
