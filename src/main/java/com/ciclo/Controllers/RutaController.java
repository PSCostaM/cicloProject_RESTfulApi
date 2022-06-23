package com.ciclo.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ciclo.Dto.RutaRequest;
import com.ciclo.Dto.RutaResponse;
import com.ciclo.Util.RutaDtoConverter;
import com.ciclo.Entities.Ruta;
import com.ciclo.Services.RutaService;

@RestController
@RequestMapping("/ruta")
public class RutaController {
    private RutaService rutaService;
    private RutaDtoConverter converter;
    public RutaController(RutaService rutaService, RutaDtoConverter converter) {
        this.rutaService = rutaService;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<RutaResponse> createRuta(@RequestBody RutaRequest request) {
        Ruta ruta = rutaService.createRuta(request);
        return new ResponseEntity<>(converter.convertRutaToDto(ruta), HttpStatus.CREATED);
    }

    @GetMapping("/encontrarRutasByUsuario/{idUser}")
    public ResponseEntity<List<RutaResponse>> encontrarRutasByUsuario(@PathVariable Long idUser) {
        List<Ruta> rutas = rutaService.getRutasByUsuario(idUser);
        return new ResponseEntity<>(converter.convertRutaToDto(rutas), HttpStatus.OK);
    }

    @GetMapping("/compararRutas")
    public ResponseEntity<List<RutaResponse>> compararRutas() {
        List<Ruta> rutas = rutaService.getAllRutas();
        return new ResponseEntity<>(converter.convertRutaToDto(rutas), HttpStatus.OK);
    }

    @GetMapping("/distintasRutas/{ubicacionSalida}/{ubicacionLlegada}")
    public ResponseEntity<List<RutaResponse>> distintasRutas(@PathVariable String ubicacionSalida, @PathVariable String ubicacionLlegada) {
        List<Ruta> rutas = rutaService.getRutasxPuntos(ubicacionSalida,ubicacionLlegada);
        return new ResponseEntity<>(converter.convertRutaToDto(rutas), HttpStatus.OK);
    }
    @GetMapping("/tiempoMinimo/{ubicacionSalida}/{ubicacionLlegada}")
    public ResponseEntity<Ruta> getTiempoMinimo(@PathVariable String ubicacionSalida, @PathVariable String ubicacionLlegada){
        Ruta rutaxCicloviaMessage = rutaService.getTiempoMinimo(ubicacionSalida, ubicacionLlegada);
        return new ResponseEntity<>(rutaxCicloviaMessage,HttpStatus.OK);
    }
    @GetMapping("/tiempoMinimo2/{ubicacionSalida}/{ubicacionLlegada}")
    public ResponseEntity<Float> getTiempoEstimado(@PathVariable String ubicacionSalida, @PathVariable String ubicacionLlegada){
        Float rutaxCicloviaMessage = rutaService.getTiempoMinimo2(ubicacionSalida, ubicacionLlegada);
        return new ResponseEntity<>(rutaxCicloviaMessage,HttpStatus.OK);
    }
}
