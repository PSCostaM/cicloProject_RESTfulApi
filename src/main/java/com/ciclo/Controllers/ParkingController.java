package com.ciclo.Controllers;

import java.util.List;

<<<<<<< Updated upstream
import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CalificacionResponseDto;
import com.ciclo.Dto.ParkingDto;
import com.ciclo.Entities.Calificacion;
//import com.ciclo.Entities.Calificacion;
=======
import com.ciclo.Dto.CalificacionResponseDto;
import com.ciclo.Dto.ParkingDto;
import com.ciclo.Entities.Calificacion;
>>>>>>> Stashed changes
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
public class ParkingController {
	@Autowired
	private ParkingService parkingService;
	private EntityDtoConverter converter;
<<<<<<< Updated upstream
    public ParkingController(ParkingService parkingService, EntityDtoConverter converter) {
        this.parkingService = parkingService;
        this.converter = converter;
    }

=======
>>>>>>> Stashed changes
	@PostMapping
	public ResponseEntity<Parking> createParking(@RequestBody ParkingDto parkingDto) {
		Parking parking = parkingService.createParking(parkingDto);
		return new ResponseEntity<>(parking, HttpStatus.OK);
		this.converter = converter;
	}

	@PutMapping("rating")
	public ResponseEntity<String> updateStars(@RequestParam Long parkingId, @RequestParam Long parkingStars) {
		String response = parkingService.updateParkingStars(parkingId, parkingStars);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("full")
	public ResponseEntity<String> updateStatus(@RequestParam Long parkingId, @RequestParam int isFull) {
		String response = parkingService.updateParkingStatus(parkingId, isFull);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("list")
	public ResponseEntity<List<Parking>> listAllParkings() {
		List<Parking> response = parkingService.listAllParkings();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/calificaciones/{id}")
	public ResponseEntity<List<CalificacionResponseDto>> getCalificacionbyId(@PathVariable Long id){
<<<<<<< Updated upstream
		List<Calificacion> calificacion = parkingService.getParkingCalificacionbyId(id);
=======
		List<Calificacion> calificacion = parkingService.getParkingbyId(id);
>>>>>>> Stashed changes
		return new ResponseEntity<>(converter.convertEntityToDto(calificacion), HttpStatus.OK);
	}

	@GetMapping("disponible")
	public ResponseEntity<List<Parking>> getDisponibilidadParking(){
		List<Parking> calificacion = parkingService.getDisponibilidad();
		return new ResponseEntity<>(calificacion, HttpStatus.OK);
	}

<<<<<<< Updated upstream
	@PostMapping("/{parkingId}/calificaciones")
    public ResponseEntity<CalificacionResponseDto> createCalificacion(@PathVariable Long parkingId, @RequestBody CalificacionRequestDto calificacion){
        Calificacion calificacionCreated = parkingService.createCalificacion(parkingId, calificacion);
        return new ResponseEntity<>(converter.convertEntityToDto(calificacionCreated), HttpStatus.CREATED);
    }

	@GetMapping("/{id}")
	public ResponseEntity<ParkingDto> findParkingbyId(@PathVariable Long Id){
        Parking parking = parkingService.getParkingbyId(Id);
        return new ResponseEntity<>(converter.convertEntityToDto2(parking), HttpStatus.OK);
    }
=======
>>>>>>> Stashed changes
}
