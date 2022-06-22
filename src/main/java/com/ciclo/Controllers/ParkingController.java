package com.ciclo.Controllers;

import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CalificacionResponseDto;
import com.ciclo.Dto.ParkingDtoRequest;
import com.ciclo.Dto.ParkingDtoResponse;
import com.ciclo.Entities.Calificacion;
//import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Parking;
import com.ciclo.Services.ParkingService;
import com.ciclo.Util.EntityDtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking")
//@CrossOrigin(origins = "*")
public class ParkingController {
	@Autowired
	private ParkingService parkingService;
	private EntityDtoConverter converter;

	public ParkingController(ParkingService parkingService, EntityDtoConverter converter) {
		this.parkingService = parkingService;
		this.converter = converter;
	}

	@PostMapping
	public ResponseEntity<Parking> createParking(@RequestBody ParkingDtoRequest parkingDto) {
		Parking parking = parkingService.createParking(parkingDto);
		return new ResponseEntity<>(parking, HttpStatus.OK);
	}

	@PutMapping("/rating/{idParking}")
	public ResponseEntity<String> updateStars(@PathVariable Long idParking) {
		String response = parkingService.updateParkingStars_(idParking);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/full/{parkingId}")
	public ResponseEntity<String> updateStatus(@PathVariable Long parkingId) {
		String response = parkingService.updateParkingStatus(parkingId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Parking>> listAllParkings() {
		List<Parking> response = parkingService.listAllParkings();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("disponible")
	public ResponseEntity<List<Parking>> getDisponibilidadParking() {
		List<Parking> calificacion = parkingService.getDisponibilidad();
		return new ResponseEntity<>(calificacion, HttpStatus.OK);
	}

	@GetMapping("/{idParking}")
	public ResponseEntity<ParkingDtoResponse> findParkingbyId(@PathVariable Long Id) {
		Parking parking = parkingService.getParkingbyId(Id);
		return new ResponseEntity<>(converter.convertEntityToDto2(parking), HttpStatus.OK);
	}

	@GetMapping("/calificaciones/{idParking}")
	public ResponseEntity<List<CalificacionResponseDto>> getCalificacionesbyId(@PathVariable Long idParking) {
		List<Calificacion> calificacion = parkingService.getParkingCalificacionbyId(idParking);
		return new ResponseEntity<>(converter.convertEntityToDto(calificacion), HttpStatus.OK);
	}

	@PostMapping("/{parkingId}/calificaciones")
	public ResponseEntity<CalificacionResponseDto> createCalificacion(@PathVariable Long parkingId, @RequestBody CalificacionRequestDto calificacion) {
		Calificacion calificacionCreated = parkingService.createCalificacion(parkingId, calificacion);
		return new ResponseEntity<>(converter.convertEntityToDto(calificacionCreated), HttpStatus.CREATED);
	}

	@GetMapping("/{idParking}/calificaciones")
	public ResponseEntity<List<CalificacionResponseDto>> getCalificacionesById(@PathVariable Long idParking) {
		List<Calificacion> calificaciones = parkingService.getParkingCalificacionbyId(idParking);
		return new ResponseEntity<>(converter.convertEntityToDto(calificaciones), HttpStatus.OK);
	}

	@GetMapping("/{idParking}/calificaciones/promedio")
	public ResponseEntity<Float> getCalificacionPromedioById(@PathVariable Long idParking) {
		Float calificacionMessage = parkingService.getAverageCalificacionById(idParking);
		return new ResponseEntity<>(calificacionMessage, HttpStatus.OK);
	}
}
