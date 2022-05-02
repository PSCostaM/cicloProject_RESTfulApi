package com.ciclo.Controllers;

import java.util.List;

import com.ciclo.Dto.ParkingDto;
import com.ciclo.Entities.Parking;
import com.ciclo.Services.ParkingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping
	public ResponseEntity<Parking> createParking(@RequestBody ParkingDto parkingDto) {
		Parking parking = parkingService.createParking(parkingDto);
		return new ResponseEntity<>(parking, HttpStatus.OK);
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

}
