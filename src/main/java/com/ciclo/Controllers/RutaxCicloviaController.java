package com.ciclo.Controllers;

import java.util.List;

import com.ciclo.Dto.RutaxCicloviaRequest;
import com.ciclo.Dto.RutaxCicloviaResponse;
import com.ciclo.Entities.RutaxCiclovia;
import com.ciclo.Services.RutaxCicloviaService;
import com.ciclo.Util.RutaxCicloviaDtoConverter;

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
@RequestMapping("/rutaxciclovia")
public class RutaxCicloviaController {
	private RutaxCicloviaService rutaxCicloviaService;
	private RutaxCicloviaDtoConverter converter;

	public RutaxCicloviaController(RutaxCicloviaService rutaxCicloviaService, RutaxCicloviaDtoConverter converter) {
		this.rutaxCicloviaService = rutaxCicloviaService;
		this.converter = converter;
	}

	@PostMapping
	public ResponseEntity<RutaxCicloviaResponse> createRutaxCiclovia(@RequestBody RutaxCicloviaRequest request) {
		RutaxCiclovia rutaxCiclovia = rutaxCicloviaService.createRutaxCiclovia(request);
		return new ResponseEntity<>(converter.convertRutaxCicloviaToDto(rutaxCiclovia), HttpStatus.CREATED);
	}

	@GetMapping("/tiemposPorCiclovia/{idRuta}")
	public ResponseEntity<List<RutaxCicloviaResponse>> getTiemposByCiclovia(@PathVariable Long idRuta) {
		List<RutaxCiclovia> rutaxCiclovias = rutaxCicloviaService.getAllTiemposByCiclovia(idRuta);
		return new ResponseEntity<>(converter.convertRutaxCicloviaToDto(rutaxCiclovias), HttpStatus.OK);
	}
}
