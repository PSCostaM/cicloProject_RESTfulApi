package com.ciclo.Controllers;

import java.util.List;

import com.ciclo.Dto.RutaRequest;
import com.ciclo.Dto.RutaResponse;
import com.ciclo.Entities.Ruta;
import com.ciclo.Services.RutaService;
import com.ciclo.Util.RutaDtoConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
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
}
