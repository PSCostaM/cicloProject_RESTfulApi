package com.ciclo.Services;

import com.ciclo.Dto.ParkingDto;
import com.ciclo.Entities.Parking;
import com.ciclo.Repositories.ParkingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ParkingService {
	@Autowired
	private ParkingRepository parkingRepository;

	// Crear un estacionamiento
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Parking createParking(ParkingDto parkingDto) {
		Parking parking = new Parking(parkingDto);
		return parkingRepository.save(parking);
	}

	// Calificar el estado de estacionamiento
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public String updateParkingStars(Long parkingId, Long parkingStars) {
		String parkingName = parkingRepository.getById(parkingId).getUbicacion();
		parkingRepository.updateStars(parkingId, parkingStars);
		return String.format("Now %s is %d stars", parkingName, parkingStars);
	}

	// Reportar si un estacionamiento esta full
	public String updateParkingStatus(Long parkingId, int isFull) {
		String parkingName = parkingRepository.getById(parkingId).getUbicacion();
		parkingRepository.updateStatus(parkingId, isFull);
		return String.format("%s full: %d", parkingName, isFull);
	}

}
